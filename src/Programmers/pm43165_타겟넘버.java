package Programmers;

public class pm43165_타겟넘버 {
    static int solution(int[] numbers, int target) {
        int[] checked = new int[numbers.length];
        int end = 0;
        for (int number : numbers) {
            end -= number;
        }
        int compare = 0;
        int answer = 0;
        boolean check;
        while(compare!=end){
            compare = 0;
            for(int i = 0 ; i<numbers.length;i++){
                if(checked[i] == 2){
                    checked[i-1]++;
                    checked[i] = 0;
                    i -=2;
                }
            }
            for(int i = 0 ; i<numbers.length;i++){
                if(checked[i] == 0){
                    compare += numbers[i];
                }
                if(checked[i] == 1){
                    compare -= numbers[i];
                }
                if(i == numbers.length-1){
                    checked[i]++;
                }
            }
            if(compare == target){
                System.out.println(" Correct!");
                answer++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,1,1,1};
        int target = 3;
        solution(numbers, target);
    }
}
