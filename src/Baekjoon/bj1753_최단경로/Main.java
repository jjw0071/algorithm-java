package Baekjoon.bj1753_최단경로;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] route;
    static PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1]-o2[1];
        }
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <=V ; i++){
            graph.add(new ArrayList<>());
        }
        int s,e,w;
        for(int i = 0; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e,w});
        }

        route = new int[V+1];
        Arrays.fill(route,-1);
        q.add(new int[]{K,0});
        cal();
        for(int i = 1 ; i < V+1 ; i++){
            if(route[i] == -1){
                bw.write("INF"+"\n");
                continue;
            }
            bw.write(route[i]+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static void cal(){
        boolean[] checked = new boolean[route.length];
        int[] temp;
        int des, w;
        while(!q.isEmpty()){
            temp = q.poll();
            des = temp[0];
            w = temp[1];
            if(checked[des]){
                continue;
            }
            checked[des] = true;

            if(route[des] == -1 || route[des] > w){
                route[des] = w;
                for(int[] t : graph.get(des)){
                    q.add(new int[]{t[0],w+t[1]});
                }
            }
        }
    }
}
