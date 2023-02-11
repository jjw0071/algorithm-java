package pms1;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution {
    public int solution(int[][] lotteries) {
        int answer = 0;
        double[] probable = new double[lotteries.length];
        PriorityQueue<Double> bigProb = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < probable.length;i++){
            probable[i] = (double)lotteries[i][0]/(lotteries[i][1]+1);
            bigProb.add(probable[i]);
        }
        double biggestProb = bigProb.peek();
        Queue<Integer> a = new LinkedList<>();
        for(int i = 0 ; i< probable.length;i++){
            if(biggestProb == probable[i])
                a.add(i);
        }
        int biggest;
        int lottindex;
        if(a.size() == 1){
            answer = a.peek() + 1;
        }else{
            int size = a.size();
            biggest = lotteries[a.peek()][2];
            answer = a.peek();
            for(int i = 0; i<size;i++){
                lottindex = a.poll();
                if(biggest < lotteries[lottindex][2])
                    answer = lottindex;
            }
        }


        return answer;
    }
}
