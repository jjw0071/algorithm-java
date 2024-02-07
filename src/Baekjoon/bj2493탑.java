package Baekjoon;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj2493탑 {
    public static void main(String[] args) throws IOException {
        Stack<int[]> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] towers = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tower;
        int[] temptower;
        for(int i = 0 ; i< num;i++){
            tower = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                bw.write(0+" ");
                stack.add(new int[]{tower,i+1});
            }else{
                while(true){
                    if(stack.isEmpty()){
                        bw.write(0 + " ");
                        stack.add(new int[]{tower,i+1});
                        break;
                    }
                    temptower = stack.peek();
                    if(temptower[0]<tower){
                        stack.pop();
                        continue;
                    }else{
                        bw.write(temptower[1]+" ");
                        stack.add(new int[]{tower,i+1});
                        break;
                    }
                }
            }
        }

        bw.flush();


    }
}
