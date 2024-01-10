package Programmers.KakaoWinterIntern3_2_2024;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[][] dice) {
        int[] answer = {};
        int diceNumber = dice.length;
        int[] dices = new int[diceNumber];
        for(int i = 0 ;i < dices.length;i++){
            dices[i] = i;
        }

        int n = diceNumber;
        int k = n / 2;

        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(dices, k, 0, new ArrayList<Integer>(), combinations);

        // 결과 출력
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }

        List<Integer> currentWinner = combinations.get(0);
        int winningCount = 0;
        for (List<Integer> combination : combinations) {
            winningCount = simulate(combination,dice);
        }



        return answer;
    }

    private int simulate(List<Integer> combination, int[][] dice) {

        return 0;
    }

    public static void generateCombinations(int[] array, int k, int start, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < array.length; i++) {
            current.add(array[i]);
            generateCombinations(array, k, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}
