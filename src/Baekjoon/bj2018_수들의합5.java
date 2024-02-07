package Baekjoon;

import java.io.*;

public class bj2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        int low = 0;
        int big = 0;
        int answer = 0;
        int cal = 0;
        while(low <= input){
            if(cal == input){
                answer++;
            }
            if(cal>input){
                cal -= low;
                low++;
            }else{
                big++;
                cal += big;
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
