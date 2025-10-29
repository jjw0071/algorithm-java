package Baekjoon.bj11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < count + 1 ; i++){
            list.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[count+1];
        int s, e;
        for(int i = 0 ; i < count-1; i++){
            st =  new StringTokenizer(br.readLine());
            s= Integer.parseInt(st.nextToken());
            e= Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        int answer = 0;
        int[] p = new int[count+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        ArrayList<Integer> con;
        while(!q.isEmpty()){
            s= q.poll();
            if(visited[s]) continue;

            con = list.get(s);

            for(int n : con){
                if(visited[n]) continue;
                p[n] = s;
                q.add(n);
            }

            visited[s] = true;
        }

        for(int i = 2 ; i < count+1 ; i++){
            bw.write(p[i]+"\n");
        }


        bw.flush();
        bw.close();
    }
}
