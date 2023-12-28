package Programmers.pm42627_디스크컨트롤러;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution(int[][] jobs) {
        PriorityQueue<int[]> works = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        for(int[] job:jobs){
            works.add(job);
        }

        PriorityQueue<int[]> currentOnQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });
        int total = 0;
        int current = 0;
        int end = 0;
        int done = 0;
        int[] job;
        while(done < jobs.length){
            while(currentOnQueue.isEmpty() || (!works.isEmpty() && works.peek()[0] <= end)){
                currentOnQueue.add(works.poll());
            }
            job = currentOnQueue.poll();
            if(job[0]>current){
                current = job[0];
            }
            end = current+job[1];
            total += end - job[0];
            done++;
            current = end;
        }

        return total/done;
    }
}
