package Baekjoon.bj13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if(start >= end){
            bw.write(start-end + "\n");
            bw.flush();
            bw.close();
            System.exit(0);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        int answer = end-start;
        int[] current;

        int time = 0;
        boolean[] visited = new boolean[end+1];

        while(!q.isEmpty()){
            current = q.poll();
            start=current[0];
            visited[start]=true;
            time=current[1];
            answer = Math.min(answer, time+end-start);

            if(start*2 == end){
                answer = Math.min(answer, time);
            }

            if(start*2 > end){
                answer = Math.min(answer, time+start*2-end);
            }

            if(start*2 < end && !visited[start*2]){
                q.add(new int[]{start*2,time});
            }

            if((start+1)*2 == end){
                answer = Math.min(answer, time+1);
            }

            if((start+1)*2 < end && !visited[start+1]) {
                q.add(new int[]{start+1, time+1});
            }

            if((start+1)*2 > end) {
                answer = Math.min(answer, time+1+(start+1)*2-end);
            }

            if(start>1 && !visited[start-1]) {
                q.add(new int[]{start-1, time+1});
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
