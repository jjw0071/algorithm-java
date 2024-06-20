package Baekjoon.bj1149_RGB거리;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int[][] costs = new int[count][3];
        for(int i = 0 ; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i < count ;i++){
            for(int j = 0 ; j < 3 ; j++ ){
                if(j ==0){
                    costs[i][j] += Math.min(costs[i-1][1],costs[i-1][2]);
                    continue;
                }

                if(j ==1){
                    costs[i][j] += Math.min(costs[i-1][0],costs[i-1][2]);
                    continue;
                }

                costs[i][j] += Math.min(costs[i-1][1],costs[i-1][0]);
            }
        }

        int answer = costs[count-1][0];
        answer = Math.min(answer, Math.min(costs[count-1][1],costs[count-1][2]));

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
