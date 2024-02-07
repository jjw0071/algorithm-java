package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<int[]> st = new Stack<>();
        String input = sc.next();
        char[] in = input.toCharArray();
        if(in[in.length-1] == '[' || in[in.length-1] == '('){
            System.out.println(0);
            System.exit(0);
        }
        boolean inttoadd = false;
        int now=1;
        int answer = 0;
        for(int i = 0 ; i<in.length;i++){
            char command = in[i];
            int[] temp;
            switch(command) {
                case '(', '[':
                    if(now != 1){
                       if(st.isEmpty()){
                           answer = now;
                           now=1;
                       }else{
                           temp = st.pop();
                           temp[1] += now;
                           st.add(temp);
                           now = 1;
                       }
                    }
                    st.add(new int[]{command,0});
                    break;
                case ']' :
                    if(st.isEmpty() || st.peek()[0] != '['){
                        System.out.println(0);
                        System.exit(0);
                    }
                    temp = st.pop();
                    if(now == 1){
                        now *=3;
                    }else{
                        now = (temp[1] + now)*3;
                    }
                    break;
                case ')' :
                    if(st.isEmpty() || st.peek()[0] != '('){
                        System.out.println(0);
                        System.exit(0);
                    }
                    temp = st.pop();
                    if(now == 1){
                        now *=2;
                    }else{
                        now = (temp[1] + now)*2;
                    }
                    break;
            }
        }
        if(!st.isEmpty()){
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(now+answer);

    }
}
