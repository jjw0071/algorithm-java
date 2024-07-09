package Baekjoon.bj1916_최소비용구하기;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<int[]> route = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int roads = Integer.parseInt(st.nextToken());

        int[] temp;
        for(int i = 0 ; i < cities; i++){
            temp = new int[cities];
            Arrays.fill(temp,Integer.MAX_VALUE);
            temp[i] = 0;
            route.add(temp);
        }

        int from,to,w;
        for(int i = 0 ; i < roads ; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken())-1;
            to = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());
            route.get(from)[to] = Math.min(w,route.get(from)[to]);
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken())-1;
        to = Integer.parseInt(st.nextToken())-1;

        int answer = dijkstra(from, to);


        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    static int dijkstra(int from, int to){
        int[] costs = route.get(from).clone();

        boolean[] checked = new boolean[route.size()];
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        checked[from] = true;
        for(int i = 0 ; i < costs.length;i++){
            if(costs[i] < Integer.MAX_VALUE){
                q.add(new int[]{i,costs[i]});
            }
        }

        int dest,cost;
        int[] temp;
        while(!q.isEmpty()){
            temp = q.poll();
            dest = temp[0];
            cost = temp[1];

            if(checked[dest]) continue;

            checked[dest] = true;

            if(costs[dest]<cost) continue;
            costs[dest] = cost;

            temp = route.get(dest);
            for(int i = 0 ; i < temp.length ; i++){
                if(temp[i] != Integer.MAX_VALUE && temp[i]+cost<costs[i]){
                    q.add(new int[]{i,temp[i]+cost});
                }
            }

        }
        return costs[to];
    }
}
