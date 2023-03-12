package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int num = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < num;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        int temp;
        while(pq.size()!=1){
            temp =pq.poll();
            temp += pq.poll();
            pq.add(temp);
            answer += temp;
        }
        if(num == 0){
            answer = 0;
        }
        System.out.println(answer);


    }
}
