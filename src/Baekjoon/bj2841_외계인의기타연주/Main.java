package Baekjoon.bj2841_외계인의기타연주;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Stack<Integer>> guitar = new HashMap<>();
        for(int i = 1 ; i < 7; i++){
            guitar.put(i,new Stack<>());
        }

        int number = Integer.parseInt(st.nextToken());
        int biggest = Integer.parseInt(st.nextToken());
        int line  = 0;

        int numberToPush = 0;
        int movement = 0;

        for(int i = 0 ; i < number ; i++){
            st = new StringTokenizer(br.readLine());
            line = Integer.parseInt(st.nextToken());
            numberToPush = Integer.parseInt(st.nextToken());
            Stack<Integer> lineToPlay = guitar.get(line);
            movement += play(numberToPush,lineToPlay);

        }

        bw.write(movement+"\n");
        bw.flush();
        bw.close();
    }

    private static int play(int numberToPush, Stack<Integer> lineToPlay) {
        if(lineToPlay.isEmpty()){
            lineToPlay.push(numberToPush);
            return 1;
        }

        int count=0;
        int alreadyPushed = lineToPlay.peek();
        while(alreadyPushed > numberToPush){
            lineToPlay.pop();
            count++;
            if(lineToPlay.isEmpty()){
                break;
            }
            alreadyPushed = lineToPlay.peek();

        }
        if(alreadyPushed == numberToPush){
            return count;
        }
        lineToPlay.push(numberToPush);
        count++;
        return count;


    }
}
