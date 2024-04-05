package Baekjoon.bj2667_단지번호붙이기;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int length = Integer.parseInt(st.nextToken());
        int[][] city = new int[length+2][length+2];
        boolean[][] visited = new boolean[length+2][length+2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<int[]> q;

        String[] input;
        for(int i = 0 ; i < length ;i++){
            st = new StringTokenizer(br.readLine());
            input = st.nextToken().split("");
            for(int j = 0 ; j < length ; j++){
                city[i+1][j+1] = Integer.parseInt(input[j]);
            }
        }

        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};

        int area=0;
        int[] current;
        for(int i = 1 ; i <= length ; i++){
            q = new LinkedList<>();
            for(int j = 1 ; j <= length ; j++){
                if(visited[i][j] || city[i][j] == 0){
                    continue;
                }
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    current = q.poll();
                    if(visited[current[0]][current[1]]){
                        continue;
                    }
                    visited[current[0]][current[1]]= true;
                    area++;

                    for(int k = 0 ; k < 4; k++){
                        if(city[current[0]+dx[k]][current[1]+dy[k]]==1){
                            q.add(new int[]{current[0]+dx[k],current[1]+dy[k]});
                        }
                    }
                }

                pq.add(area);
                area = 0;
            }
        }

        bw.write(pq.size()+"\n");
        while(!pq.isEmpty()){
            bw.write(pq.poll()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
