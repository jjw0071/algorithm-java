package Baekjoon;

import java.util.*;

public class bj1260_DFS와BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> qu = new ArrayDeque<>();
        Stack<Integer> st = new Stack<>();
        int num = sc.nextInt();
        int size;
        boolean[] visited = new boolean[num+1];
        PriorityQueue[] pq = new PriorityQueue[num+1];
        for(int i = 0 ; i<num;i++){
            pq[i+1]= new PriorityQueue<Integer>(Collections.reverseOrder());
        }
        PriorityQueue[] pq2 = new PriorityQueue[num+1];
        int lines = sc.nextInt();
        st.add(sc.nextInt());
        qu.add(st.peek());
        int at;
        int towhere;
        for(int i = 0 ; i< lines;i++){
            at = sc.nextInt();
            towhere = sc.nextInt();
            pq[at].add(towhere);
            pq[towhere].add(at);
        }
        for(int i = 0 ; i<num;i++){
            size = pq[i+1].size();
            pq2[i+1] = new PriorityQueue<Integer>();
            for (Object o : pq[i + 1]) {
                pq2[i + 1].add(o);
            }
        }

        //dfs 부분
        //처음 탐색
        int going = st.pop();
        size = pq[going].size();
        int temp;
        for(int i = 0 ; i< size; i++){
            st.add((Integer) pq[going].poll());
        }
        visited[going] = true;
        sb.append(going).append(' ');
        while(!st.isEmpty()){
            going = st.pop();
            size = pq[going].size();
            for(int i = 0 ; i < size ; i++){
                temp = (int) pq[going].poll();
                if(!visited[temp]){
                    st.add(temp);
                }
            }
            if(!visited[going]){
                sb.append(going).append(' ');
                visited[going] = true;
            }
        }
        sb.append('\n');

        //bfs 부분
        Stack<Integer> tempstack = new Stack<>();
        visited = new boolean[num+1];
        going = qu.poll();
        size = pq2[going].size();
        for(int i = 0 ; i < size;i++){
            qu.add((Integer) pq2[going].poll());
        }
        visited[going] = true;
        sb.append(going).append(' ');
        while(!qu.isEmpty()){
            going = qu.poll();
            size = pq2[going].size();
            for(int i = 0 ; i < size ; i++){
                temp = (int) pq2[going].poll();
                if(!visited[temp]){
                    qu.add(temp);
                }
            }
            if(!visited[going]){
                sb.append(going).append(' ');
                visited[going] = true;
            }
        }

        System.out.println(sb);








    }
}
