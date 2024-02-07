package Programmers.pm42584;

public class Solution {
    public static void main(String[] args) {

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count;
        for(int i = 0;i<prices.length;i++){
            for(int j = i+1;j<prices.length;j++){
                if(prices[i]>prices[j]){
                    count = j - i;
                    answer[i] = count;
                    break;
                }
                if(j == prices.length -1){
                    count = j - i;
                    answer[i] = count;
                    break;
                }
            }

        }
        return answer;
    }
}
