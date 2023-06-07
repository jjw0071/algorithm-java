package Programmers;

public class pm42840_모의고사 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] no1 = {1,2,3,4,5};
        int[] no2 = {2,1,2,3,2,4,2,5};
        int[] no3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[4];
        score[0] = check(answers, no1);
        score[1] = check(answers, no2);
        score[2] = check(answers, no3);
        score[3] = 0;
        for(int i = 0 ; i < 3;i++){
            if(score[i]>score[3]){
                score[3] = score[i];
            }
        }
        int temp = 0;

        for(int i = 0 ; i < 3; i ++){
            if(score[i] == score[3]){
                answer[temp] = i+1;
                temp++;
            }
        }

        int[] answer1 = new int[temp];
        for(int i = 0 ; i< temp;i++){
            answer1[i] = answer[i];
        }


        return answer1;
    }

    public int check(int[] answer, int[] no){
        int score = 0;
        int length = no.length;
        for(int i = 0 ; i < answer.length;i++){
            if(answer[i] == no[i%length]){
                score++;
            }
        }

        return score;
    }
}
