package Programmers.KakaoWinterIntern1_2023;

import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsNumber = friends.length;
        int[][] giveAndTake = new int[friendsNumber][friendsNumber];

        HashMap<String, Integer> friendsMap =putNamesIntoMap(friends);
        for(String giftRelation : gifts){
            String[] giverAndTaker = giftRelation.split(" ");
            checkGiveAndTake(friendsMap, giverAndTaker, giveAndTake);
        }

        int[][] results = checkGive(friendsNumber, giveAndTake);
        checkTake(giveAndTake, results);

        checkGiftIndex(results);

        int[] nextMonthPredict = predictNextMonth(results,giveAndTake);


        for (int i : nextMonthPredict) {
            System.out.print(i + " ");
        }
        System.out.println();




        int answer = 0;
        return answer;
    }

    private int[] predictNextMonth(int[][] results, int[][] giveAndTake) {
        int[] nextMonth = new int[giveAndTake.length];
        for(int i = 0 ; i < giveAndTake.length;i++){
            for(int j = 0 ; j < i;j++){
                if(giveAndTake[i][j]>giveAndTake[j][i]){
                    nextMonth[j]++;
                    continue;
                } else if (giveAndTake[i][j]<giveAndTake[j][i]) {
                    nextMonth[i]++;
                    continue;
                }else{
                    if(results[i][2]> results[j][2]){
                        nextMonth[j]++;
                        continue;
                    }else if(results[i][2]< results[j][2]){
                        nextMonth[i]++;
                        continue;
                    }else{
                        continue;
                    }
                }
            }
        }
        return nextMonth;
    }

    private void checkGiftIndex(int[][] results) {
        for(int i = 0 ; i < results.length;i++){
            results[i][2] = results[i][0]-results[i][1];
        }
    }

    private static void checkTake(int[][] giveAndTake, int[][] results) {
        int take = 0;
        for(int i = 0; i < giveAndTake[0].length; i++){
            for(int j = 0; j < giveAndTake.length; j++){
                take += giveAndTake[j][i];
            }
            results[i][1] = take;
            take =0;
        }
    }

    private static int[][] checkGive(int friendsNumber, int[][] giveAndTake) {
        int[][] results = new int[friendsNumber][3];
        int give = 0;
        for(int i = 0; i < giveAndTake.length; i++){
            for(int j = 0; j < giveAndTake[0].length; j++){
                give += giveAndTake[i][j];
            }
            results[i][0] = give;
            give = 0;

        }
        return results;
    }

    private static void checkGiveAndTake(HashMap<String, Integer> friendsMap, String[] giverAndTaker, int[][] giveAndTake) {
        int giver = friendsMap.get(giverAndTaker[0]);
        int taker = friendsMap.get(giverAndTaker[1]);
        giveAndTake[giver][taker]++;
    }

    private static HashMap<String, Integer> putNamesIntoMap(String[] friends) {
        int count = 0;
        HashMap<String, Integer> friendsMap = new HashMap<>();
        for(String name : friends){
            friendsMap.put(name, count);
            count++;
        }

        return friendsMap;
    }
}
