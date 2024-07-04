package Baekjoon.bj11404_플로이드;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());

        for(int i = 0 ;i < map.length;i++){
            Arrays.fill(map[i],10_000_000);
        }

        for(int i = 0 ;i < map.length;i++){
            for(int j = 0 ; j < map[i].length;j++){
                if(i == j){
                    map[i][j] = 0;
                }
            }
        }
        int start,end,weight;
        for(int i = 0 ; i < C ; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end],weight);
        }

        // 플로이드 워셜 알고리즘
        //경유지 먼저
        for(int i = 1 ; i < N+1; i++){

            //시작점
            for(int j = 1 ; j < N+1; j++){


                // 도착점
                for(int k = 1 ; k < N+1;k++){

                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }

        for(int i = 1 ; i < N+1; i++){
            for(int j = 1 ; j < N+1 ; j++){
                if(map[i][j] == 10_000_000){
                    bw.write(0+" ");
                    continue;
                }
                bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
