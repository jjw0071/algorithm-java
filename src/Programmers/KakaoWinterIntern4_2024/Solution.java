package Programmers.KakaoWinterIntern4_2024;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int round = 1;
    public static void main(String[] args) {
        System.out.println(solution(10 , new int[]{3,6,7,2,1,10,5,9,8,12,11,4}));
    }
    public static int solution(int coin, int[] cards) {
        int answer = 0;
        int target = cards.length+1;
        ArrayList<Integer> pick = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i ++){
            pick.add(cards[i]);
        }

        boolean isOver = false;
        while(!isOver){
            System.out.println("Round: "+ round);
            isOver = playOneRound(coin,cards,pick,target);
            if(round > (cards.length-4)/2){
                return (cards.length-4)/2;
            }
        }
        return round;
    }

    private static boolean playOneRound(int coin, int[] cards, ArrayList<Integer> pick, int target) {
        int card1 = cards[4*round];
        int card2 = cards[4*round+1];
        int selfGo = checkSelfGo(pick,target);
        if(selfGo != -1){
            pick.removeIf(n -> n==selfGo || n == target-selfGo);
            round++;
        } else{
            if(pick.contains(target-card2) && coin >1 && pick.contains(target-card1)){
                coin --;
                coin --;
                pick.removeIf(n -> n==target-card1);
                pick.add(card2);
                round++;

            }else if (pick.contains(target-card1) && coin >0) {
                coin --;
                pick.removeIf(n -> n==target-card1);
                round++;
            } else if(pick.contains(target-card2) && coin >0) {
                coin --;
                pick.removeIf(n -> n==target-card1);
                round++;
            }else{
                return true;
            }
        }
        return false;

    }

    private static int checkSelfGo(ArrayList<Integer> pick, int target) {
        for(int number : pick){
            if(pick.contains(target-number)){
                return number;
            }
        }
        return -1;
    }
}
