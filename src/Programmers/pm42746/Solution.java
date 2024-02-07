package Programmers.pm42746;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        //solution(new int[]{1, 59, 2, 95, 6});
    }
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for(int i = 0 ;i <numbers.length; i++){
            strings[i] = String.valueOf(numbers[i]);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i<numbers.length;i++){
            pq.add(strings[i]);
        }

        String answer = "";
        for(int i = 0 ; i<numbers.length;i++){
            answer += pq.poll();
        }
        return answer;
    }
}
