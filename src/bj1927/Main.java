package bj1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int input;
        for(int i = 0; i<num;i++){
            input = sc.nextInt();
            if (input == 0) {
                if (pq.isEmpty())
                    sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.add(input);
            }
        }
        System.out.println(sb);
    }
}
