package bj11279;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int command;
        for(int i = 0; i<num;i++){
            command = sc.nextInt();
            if(command == 0){
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else{
                   sb.append(pq.poll()).append('\n');
                }

            }
            else  pq.add(command);
        }
        System.out.println(sb);
    }
}
