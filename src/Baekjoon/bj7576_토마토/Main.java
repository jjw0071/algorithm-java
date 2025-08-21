package Baekjoon.bj7576_토마토;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();

        int[][] box = new int[N+2][M+2];
        boolean done = true;
        int t = 0;
        for(int i = 0 ; i < N+2 ; i++){
            if(i != 0 && i != N+1){
                st = new StringTokenizer(br.readLine());
            }

            for(int j = 0 ; j < M+2 ; j++){
                if(i == 0 || j == 0 || i == N+1 || j == M+1){
                    box[i][j] = -1;
                }else{
                    t = Integer.parseInt(st.nextToken());
                    box[i][j] = t;
                    if(t == 0){
                        done = false;
                    }

                    if(t==1){
                        q.add(new int[] {i, j, 0});
                    }
                }
            }
        }

        if(done){
            bw.write(0 + "\n");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        int[] dx = new int[] {-1, 1,0, 0};
        int[] dy = new int[] {0, 0, -1, 1};

        int[] check;
        int tx, ty;
        while(!q.isEmpty()){
            check = q.poll();

            for(int i = 0 ; i < 4; i ++){
                tx = check[0] + dx[i];
                ty = check[1] + dy[i];
                if(box[tx][ty] != 0 ){
                    continue;
                }
                box[tx][ty] = check[2]+1;
                q.add(new int[] {
                        tx, ty, check[2] + 1
                });
            }
        }

        int answer = 0;


        for(int i = 0 ; i < N+2 ; i++){
            for(int j = 0 ; j < M+2 ; j++){
                if(box[i][j] == 0){
                    bw.write(-1 + "\n");
                    bw.flush();
                    bw.close();
                    System.exit(0);
                }

                answer = Math.max(answer, box[i][j]);
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
