package Baekjoon.bj11403_경로찾기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[][] answer = new int[length][length];
        ArrayList<Integer> current;

        for (int i = 0 ; i < length ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < length ; i++){
            st = new StringTokenizer(br.readLine());
            current = graph.get(i);
            for(int j = 0 ; j < length ; j++){
                int u = Integer.parseInt(st.nextToken());
                if(u == 1){
                    current.add(j);
                }
            }
        }

        boolean[] visited;
        int from;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < length ; i++){
            q.add(i);
            visited = new boolean[length];
            while(!q.isEmpty()){
                from = q.poll();
                current = graph.get(from);
                for(int des : current){
                    if(!visited[des]){
                        visited[des] = true;
                        q.add(des);
                        answer[i][des] = 1;
                    }
                }
            }
        }

        for(int i = 0 ; i < length ; i++){
            for(int j = 0 ; j < length ; j++){
                bw.write(answer[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
