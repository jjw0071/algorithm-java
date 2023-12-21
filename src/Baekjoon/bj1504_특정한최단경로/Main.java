package Baekjoon.bj1504_특정한최단경로;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0 ;i <node+1;i++){
            graph.add(new ArrayList<>());
        }
        int start = 0 ;
        int destination = 0;
        int distance =0;
        for(int i = 0 ; i < line;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            destination = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{destination,distance});
            graph.get(destination).add(new int[]{start,distance});

        }
        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());
        boolean flag1 = true;
        boolean flag2 = true;
        if(findShortest(graph,1,node,node)==-1){
            flag1 = false;
            flag2 = false;
        }

        long mid11 = findShortest(graph, 1, mid1,node);
        if(mid11 == -1){
            flag1 =false;
        }
        long mid1mid2 = findShortest(graph, mid1,mid2,node);
        if(mid1mid2 == -1){
            flag1 = false;
            flag2 = false;
        }
        long mid2node = findShortest(graph, mid2, node,node);
        if(mid2node == -1){
            flag1 = false;
        }

        long onemid2 = findShortest(graph, 1, mid2,node);
        if(onemid2 == -1){
            flag2 = false;
        }
        long mid1node = findShortest(graph, mid1, node,node);
        if(mid1node == -1){
            flag2 = false;
        }
        long answer =0;

        if(flag1 && flag2){
            answer = Math.min(mid11+mid1mid2+mid2node, onemid2+mid1mid2+mid1node);
        }else if(flag1){
            answer = mid11+mid1mid2+mid2node;
        }else if(flag2){
            answer = onemid2+mid1mid2+mid1node;
        }else{
            answer =-1;
        }



        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    private static long findShortest(ArrayList<ArrayList<int[]>> graph, int start, int destination,int node){
        boolean[] visited = new boolean[node+1];
        long[] time = new long[node+1];
        Arrays.fill(time,Long.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int to = 0;
        pq.add(new int[]{start,0});
        time[start] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            to = now[0];
            if(visited[to]){
                continue;
            }
            visited[to] = true;

            for(int[] road : graph.get(to)){
                if(time[road[0]]>time[to]+road[1]){
                    time[road[0]] = time[to]+road[1];
                    pq.add(road);
                }

            }
        }
        if(time[destination] == Long.MAX_VALUE){
            return -1;
        }
        return time[destination];

    }
}
