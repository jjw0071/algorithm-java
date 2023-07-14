package Baekjoon;

import java.util.ArrayDeque;
import java.util.Scanner;

public class bj11866_요세푸스문제0 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int people = sc.nextInt();
        int where = sc.nextInt();
        for(int i = 1 ; i < people+1; i++){
            ad.add(i);
        }

        sb.append("<");
        while(ad.size()>1){
            for(int i = 0 ; i < where ;i++){
                if(i!=where-1){
                    ad.add(ad.removeFirst());
                }else{
                    sb.append(ad.removeFirst()).append(", ");
                }
            }
        }
        sb.append(ad.remove()).append(">");
        System.out.println(sb);

    }
}
