package Programmers;
import java.util.*;

public class pm42586_기능개발 {
    public static void main(String[] args) {


    }

    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> ans = new Stack<>();

        int togo = 1;
        int days = check(progresses[0],speeds[0]);
        int temp;
        for(int i = 1; i < progresses.length;i++){
            System.out.println(i);
            temp=check(progresses[i],speeds[i]);
            if(days == 0){
                days = temp;
                continue;
            }
            if(temp>days){
                System.out.println(togo+" into answ");
                ans.add(togo);
                togo = 1;
                days = temp;
            }else {
                System.out.println("togo++");
                togo++;
            }

        }
        System.out.println(togo);
        if(togo != 0){
            ans.add(togo);
        }
        System.out.println(ans.size());
        int[] answer = new int[ans.size()];
        for(int i = ans.size()-1;i>-1;i--){
            answer[i] = ans.pop();
        }
        return answer;

    }

    public static int check(int pro, int speeds){
        int cal = (100-pro)/speeds;
        if((100-pro)%speeds == 0){
            return cal;
        }
        return cal+1;

    }
}

