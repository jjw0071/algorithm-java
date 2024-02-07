package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = sc.nextInt();
        int[] numbers = new int[num];
        int[] answer = new int[num];
        for(int i = 0 ; i< num ; i++){
            numbers[i] = sc.nextInt();
        }
        boolean goin ;
        for(int i = 0 ; i < num; i++){
            goin = true;
            while(goin){
                if(st.isEmpty()){
                    break;
                }
                if(numbers[i]>numbers[st.peek()]){
                    answer[st.pop()] = numbers[i];
                }else{
                    goin = false;
                }
            }
            st.add(i);
        }
        for(int i = 0 ; i< num ; i++){
            if(answer[i] == 0){
                sb.append(-1).append(' ');
            }else{
                sb.append(answer[i]).append(' ');
            }
        }
        System.out.println(sb);
    }
}
