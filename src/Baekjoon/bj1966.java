package Baekjoon;

import java.util.*;

public class bj1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<int[]> qu = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int num = sc.nextInt();
        for(int i = 0; i < num;i++){
            int howmanydocs = sc.nextInt();
            int where = sc.nextInt();
            int count = 0;
            int temp = 0;
            for(int j = 0;j<howmanydocs;j++){
                temp = sc.nextInt();
                qu.add(new int[]{j,temp});
                pq.add(temp);
            }
            boolean check = false;
            while(!check){
                int biggest = pq.peek();
                int[] firstdoc = qu.poll();
                if(biggest == firstdoc[1]) {
                    pq.poll();
                    count++;
                    if (firstdoc[0] == where) {
                        sb.append(count).append('\n');
                        check = true;
                        break;
                    }
                }
                qu.add(firstdoc);
            }
            pq.clear();
            qu.clear();
        }
        System.out.println(sb);

    }
}
