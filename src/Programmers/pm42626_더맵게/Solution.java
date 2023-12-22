package Programmers.pm42626_더맵게;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: scoville){
            pq.add(i);
        }
        int low1,low2;
        int move = 0;
        while(pq.peek()<K && pq.size() != 1){
            low1= pq.poll();
            low2 = pq.poll();
            low1 = low1 + (low2*2);
            pq.add(low1);
            move++;
        }
        if(pq.peek()<K){
            return -1;
        }
        return move;
    }
}
