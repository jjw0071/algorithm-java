package Programmers;

public class pm42842_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        int length = 1;
        int height = 0;
        while(true){
            if(total%length != 0){
                length++;
                continue;
            }
            height = total/length;
            if(brown == (height+length)*2-4){
                break;
            }
            length++;
        }
        answer[0] = height;
        answer[1] = length;
        return answer;
    }
}
