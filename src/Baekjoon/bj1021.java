package Baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class bj1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> qu = new ArrayDeque<>();
        int answer  = 0;
        int num = sc.nextInt();
        int target;
        int temp;
        int size;
        for(int i = 0 ; i< num;i++){
            qu.add(i+1);
        }
        num = sc.nextInt();
        int loop;
        for(int i = 0 ; i< num;i++){
            loop = 0;
            target = sc.nextInt();
            size = qu.size();
            temp = qu.poll();
            while(temp != target){
                qu.add(temp);
                temp = qu.poll();
                loop++;
            }
            if(size%2 == 0){
                if(loop< size/2){
                    answer += loop;
                }else{
                    answer += (size-loop);
                }
            }else{
                if(loop< (size+1)/2){
                    answer += loop;
                }else{
                    answer += (size-loop);
                }
            }

        }
        System.out.println(answer);

    }
}
