package Baekjoon.bj1967_숨바꼭질;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,start});
        boolean[] visited = new boolean[100001];
        visited[start] = true;

        int[] current;

        while(q.peek()[1]!=end){
            current = q.poll();
            visited[current[1]] = true;
            if(current[1]+1>=0 && current[1]+1<=100000){
                if(!visited[current[1]+1]){
                    q.add(new int[]{current[0]+1,current[1]+1});
                }
            }

            if(current[1]-1>=0 && current[1]-1<=100000){
                if(!visited[current[1]-1]){
                    q.add(new int[]{current[0]+1,current[1]-1});
                }
            }

            if(current[1]*2>=0 && current[1]*2<=100000){
                if(!visited[current[1]*2]){
                    q.add(new int[]{current[0]+1,current[1]*2});
                }
            }
        }

        answer = q.peek()[0];

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
