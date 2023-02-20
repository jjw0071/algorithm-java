package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String input = sc.next();
        char[] in = input.toCharArray();
        boolean over = false;
        for(int i = 0 ; i<in.length;i++){
            char command = in[i];
            char temp;
            switch(command) {
                case '(' :
                    st.add(command);
                    break;
                case '[' :
                    st.add(command);
                    break;
                case ']' :

                    if(st.isEmpty() || (temp = st.pop()) != '('){
                        sb.setLength(0);
                        sb.append(0);
                        over =true;
                        return;
                    }
                    if(temp == '['){

                    }
                    break;
                case ')' :

                    break;
            }
            if(over)
                break;
        }
    }
}
