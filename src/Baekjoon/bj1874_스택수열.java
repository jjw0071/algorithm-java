package Baekjoon;

import java.io.*;
import java.util.Stack;

public class bj1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stck = new Stack<>();
        int numberToPrint;
        int numberGoing = 1;
        for(int i = 0 ; i< num;i++){
            numberToPrint = Integer.parseInt(br.readLine());
            if(stck.isEmpty()||stck.peek()<numberToPrint){
                while(numberGoing<=numberToPrint){
                    stck.push(numberGoing);
                    sb.append("+\n");
                    numberGoing++;
                }
            }

            if(stck.peek()>numberToPrint){
                sb = new StringBuilder();
                sb.append("NO"+"\n");
                System.out.println(sb);
                System.exit(0);
            }

            if(stck.peek() == numberToPrint){
                stck.pop();
                sb.append("-\n");
            }

        }

        System.out.println(sb);
    }
}
