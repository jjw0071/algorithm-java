package Baekjoon.bj1238_파티;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] road;
    static int[][] reverseRoad;
    static int target;
    static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        int from, to, time;
        road = new int[N+1][N+1];
        reverseRoad = new int[N+1][N+1];
        for(int[] r : road){
            Arrays.fill(r,-1);
        }

        for(int[] r : reverseRoad){
            Arrays.fill(r,-1);
        }

        for(int i = 0 ; i < road.length ;i++){
            road[i][i] = 0;
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            road[from][to] = time;
            reverseRoad[to][from] = time;
        }

        pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        int[] s1 = d(target, road);
        int[] s2 = d(target, reverseRoad);

        int answer = -1;
        int dist;
        for(int i = 0 ; i < road.length; i++){
            dist = s1[i] + s2[i];
            answer = Math.max(answer, dist);
        }


        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    public static int[] d(int i, int[][] road){
        int[] shortest = new int[road.length];
        int dest = 0;
        for(int a : road[i]){
            if(a == 0 || a == -1){
                dest++;
                continue;
            }

            pq.add(new int[]{a, dest});
            dest++;
        }

        int[] info;
        int time;
        int stime;
        int ntime;
        int nextTime;
        while(!pq.isEmpty()){
            info = pq.poll();
            time = info[0];
            dest = info[1];
            stime = shortest[info[1]];
            if(stime == 0 || stime > info[0]){
                shortest[dest] = time;
                for(int j = 1;  j < road.length; j++){
                    if(j == i){
                        continue;
                    }
                    nextTime = road[dest][j];
                    if(nextTime == 0 || nextTime == -1){
                        continue;
                    }
                    ntime = nextTime + time;
                    if(shortest[j] >time || shortest[j] == 0){
                        pq.add(new int[]{ntime, j});
                    }
                }
            }
        }
        return shortest;
    }
}
