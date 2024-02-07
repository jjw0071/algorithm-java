package Programmers;
import java.util.*;

public class pm12906_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,0,1};
        int[] answer = solution(arr);
        for(int i = 0 ; i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }

    public static int[] solution(int[] arr) {
        Stack<Integer> st = new Stack();
        int temp = 0 ;
        st.add(arr[0]);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(int i = 1 ; i< arr.length;i++){
            temp = arr[i];
            if(st.peek() != temp){
                st.add(temp);
            }
        }
        int size = st.size();
        int[] answer = new int[size];
        for(int i = size ; i >0;i--){
            answer[i-1] = st.pop();
        }

        return answer;
    }
}
