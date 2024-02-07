package Programmers.pm42748;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        for( int i = 0 ;i <commands.length;i++){
            for(int j = commands[i][0]-1;j<commands[i][1]; j++){
                pq.add(array[j]);
            }
            int size = pq.size();
            int[] check = new int[size];
            for(int j = 0;j<size;j++){
                check[j] = pq.poll();
            }
            al.add(check[commands[i][2]-1]);
            pq.clear();
        }
        int num = al.size();
        int[] answer = new int[num];
        for(int i = 0 ; i<num;i++){
            answer[i] = al.get(i);
        }
        return answer;
    }
}
