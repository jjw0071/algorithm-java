package Programmers.KakaoWinterIntern3_2024;

import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int[] diceCompare = new int[dice.length];
        for(int i = 0 ; i < dice.length;i++){
            for(int j = i ; j < dice.length;j++){
                if(i == dice.length-1){
                    continue;
                }
                compareWinning(dice[i],dice[j], diceCompare,i,j);
            }
        }

        Map<Integer, Integer> originalDiceCompare = new HashMap<>();
        for(int i= 0 ; i < diceCompare.length;i++){
            originalDiceCompare.put(diceCompare[i],i+1);
        }
        for(int i: diceCompare){
            System.out.println(i);
        }

        List<Integer> answerList = new ArrayList<>();

        Arrays.sort(diceCompare);
        for(int i = diceCompare.length-1 ; i>diceCompare.length/2;i++){
            answerList.add(originalDiceCompare.get(diceCompare[i]));
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        return answer;
    }

    private void compareWinning(int[] dice1, int[] dice2, int[] diceCompare,int i, int j) {
        int win = 0;
        int draw = 0;
        for (int result1 : dice1) {
            for (int result2 : dice2) {
                if (result1 > result2) {
                    win++;
                } else if (result1 == result2) {
                    draw++;
                }
            }
        }

        if(win > 18){
            diceCompare[i]++;
        }else if(draw + win < 18){
            diceCompare[j]++;
        }else if(36-(win+draw)>win){
            diceCompare[j]++;
        }else if(36-(win+draw)<win){
            diceCompare[i]++;
        }
    }
}
