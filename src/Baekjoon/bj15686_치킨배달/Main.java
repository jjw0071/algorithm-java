package Baekjoon.bj15686_치킨배달;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<int[]> c;
    public static List<int[]> h;
    public static int answer;
    public static int S;
    public static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = new ArrayList<>();
        h = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int cur;
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                cur = Integer.parseInt(st.nextToken());
                if(cur == 1){
                    h.add(new int[]{i,j});
                    continue;
                }
                if(cur == 2){
                    c.add(new int[]{i,j});
                }
            }
        }
        visited = new boolean[c.size()];

        answer = Integer.MAX_VALUE;

        check(0,0);

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    public static void check(int count, int idx){
        if(count == S){
            int distance = 0;
            int tempD;
            int[] chick;
            for(int[] home : h){
                tempD = Integer.MAX_VALUE;
                for(int i = 0 ; i < visited.length;i++){
                    if(visited[i]){
                        chick = c.get(i);
                        tempD = Math.min(
                                Math.abs(home[0]-chick[0])+Math.abs(home[1]-chick[1])
                                ,tempD
                        );
                    }
                }
                distance += tempD;
            }
            answer = Math.min(distance,answer);
            return;
        }

        for(int i = idx ; i < c.size();i++){
            visited[i] = true;
            check(count+1,i+1);
            visited[i] = false;
        }
    }
}
