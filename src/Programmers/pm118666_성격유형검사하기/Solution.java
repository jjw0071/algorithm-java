package Programmers.pm118666_성격유형검사하기;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character,int[]> score = new HashMap<>();
        int[] a = new int[]{3,2,1,0,-1,-2,-3};
        int[] b = new int[]{-3,-2,-1,0,1,2,3};

        score.put('R',a);
        score.put('C',a);
        score.put('J',a);
        score.put('A',a);

        score.put('T',b);
        score.put('F',b);
        score.put('M',b);
        score.put('N',b);

        char first;
        int currentScore;
        int[] currentTable;
        int[] result = new int[4];
        String pick;
        for(int index = 0 ; index < survey.length; index++){
            pick = survey[index];
            first = pick.charAt(0);
            currentTable = score.get(first);
            currentScore = currentTable[choices[index]-1];
            result[indexOfPick(first)] += currentScore;
        }

        if(result[0]<0){
            answer += "T";
        }else{
            answer += "R";
        }
        if(result[1]<0){
            answer += "F";
        }else{
            answer += "C";
        }
        if(result[2]<0){
            answer += "M";
        }else{
            answer += "J";
        }
        if(result[3]<0){
            answer += "N";
        }else{
            answer += "A";
        }

        return answer;
    }

    public static int indexOfPick(char first){
        return switch(first) {
            case 'R', 'T' -> 0;
            case 'C', 'F' -> 1;
            case 'J', 'M' -> 2;
            case 'A', 'N' -> 3;
            default -> -1;
        };
    }
}
