package Baekjoon.bj17427_약수의합2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;

        int N = Integer.parseInt(st.nextToken());

        if(N == 1){
            answer = 1;
            bw.write(answer + "\n");
            bw.flush();
            bw.close();
            System.exit(0);
        }
        
        for(int i = 1 ; i <= N ; i++){
            answer += i * (N/i);
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
