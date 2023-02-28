package Baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class bj1260_DFS와BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = sc.nextInt();
        boolean[] visited = new boolean[num+1];
        PriorityQueue<Integer>[] pq = new PriorityQueue[num+1];
        int lines = sc.nextInt();
        st.add(sc.nextInt());
        int at;
        int towhere;
        for(int i = 0 ; i< lines;i++){
            at = sc.nextInt();
            towhere = sc.nextInt();
            pq[at].add(towhere);
        }

        //처음 탐색
        int going = st.pop();
        int size = pq[going].size();
        for(int i = 0 ; i< size; i++){
            st.add(pq[going].poll());
        }
        visited[going] = true;
        sb.append(going).append(' ');
        while(!st.isEmpty()){
            going = st.pop();

        }






    }
}
