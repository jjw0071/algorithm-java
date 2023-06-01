package Programmers;
import java.util.*;

public class pm42586_기능개발 {
    public static void main(String[] args) {


    }

    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        
        int temp =0;
        int days = 0;
        int totaldays = 0;
        daystogo(progresses, speeds, 0);
        st.add(days);
        totaldays += days;
        for(int i = 1 ; i< speeds.length; i++){
            daystogo(progresses, speeds, i);
            temp=st.peek();
            if(temp>days){
                st.add(days);
            }else if(temp == days){
                ans.add(st.size()+1);
            }else {
                ans.add(st.size());
                st.clear();
                st.add(days);
            }
            
        }
        return answer;
    }

    private static void daystogo(int[] progresses, int[] speeds, int i) {
        int days;
        days = (100- progresses[i])/ speeds[i];
        if((100- progresses[i])% speeds[i] != 0){
            days++;
        }
    }
}
