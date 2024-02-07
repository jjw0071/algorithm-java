package Programmers.pm42576_완주하지못한선수;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String[] participant = new String[] {
                "leo", "kiki", "eden"
        };

        String[] completion = new String[]{
                "eden", "kiki"
        };

        System.out.println(solution(participant,completion));
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> complete = new HashMap<>();
        int oldCount =0;
        for(String player : completion){
            if(complete.containsKey(player)){
                oldCount = complete.get(player);
                oldCount++;
                complete.replace(player,oldCount);
            }else{
                complete.put(player,1);
            }
        }

        for(String player : participant){
            if(!complete.containsKey(player)){
                return player;
            }
            if(complete.get(player) == 0){
                return player;
            }else{
                oldCount = complete.get(player);
                oldCount--;
                complete.replace(player,oldCount);
            }
        }
        return null;
    }
}
