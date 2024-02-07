package Baekjoon;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj2606_virus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean[] visited = new boolean[num+1];
        int connection = sc.nextInt();
        Queue<Integer> check = new ArrayDeque<>();
        PriorityQueue<Integer>[] pq = new PriorityQueue[num+1];
        for(int i = 0; i<num;i++){
            pq[i+1] = new PriorityQueue<>();
        }
        int from, to;
        for(int i = 0 ; i < connection ; i++){
            from = sc.nextInt();
            to = sc.nextInt();
            pq[from].add(to);
            pq[to].add(from);
        }
        int infected = 0;
        while(!pq[1].isEmpty()){
            check.add(pq[1].poll());
        }
        visited[1] = true;
        int togo;
        while(!check.isEmpty()){
            togo = check.poll();
            if(!visited[togo]){
                while(!pq[togo].isEmpty()){
                    check.add(pq[togo].poll());
                }
                visited[togo] = true;
                infected++;
            }
        }
        System.out.println(infected);

    }
}

