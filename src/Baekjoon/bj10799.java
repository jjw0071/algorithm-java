package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj10799 {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] chars = input.toCharArray();
        int loopnum = chars.length;
        int answer = 0;
        char check;
        for(int i = 0 ; i< loopnum;i++){
            check = chars[i];
            if(check == '(')
                st.add(check);
            if(check == ')'){
                if(chars[i-1] == '('){
                    st.pop();
                    answer += st.size();
                }else if(chars[i-1] == ')'){
                    answer += 1;
                    st.pop();
                }
            }
        }
        System.out.println(answer);
    }
}
