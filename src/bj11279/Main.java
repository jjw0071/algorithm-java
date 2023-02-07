package bj11279;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int command;
        int size;
        for(int i = 0; i<num;i++){
            command = sc.nextInt();
            if(command == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else{
                    size = pq.size();
                    for(int j = 0 ;j<size;j++){
                        ad.addLast(pq.poll());
                    }
                    sb.append(ad.pollLast()).append('\n');
                    size = ad.size();
                    for(int j = 0 ; j<size;j++){
                        pq.add(ad.pollLast());
                    }
                }

            }
            else  pq.add(command);
        }
        System.out.println(sb);
    }
}
