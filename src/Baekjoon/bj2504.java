package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<int[]> st = new Stack<>();
        Stack<Integer> toadd = new Stack<>();
        String input = sc.next();
        char[] in = input.toCharArray();
        boolean over = false;
        boolean inttoadd = false;
        int answer=0;
        int tempint = 0;
        for(int i = 0 ; i<in.length;i++){
            char command = in[i];
            char temp;
            switch(command) {
                case '(', '[':
                    if(inttoadd){
                        toadd.add(tempint);
                        inttoadd = false;
                        tempint = 0;
                    }
                    st.add(new int[]{command,1});
                    break;
                case ']' :
                    if(st.isEmpty() || (temp = st.pop()) != '['){
                        over =true;
                        break;
                    }
                    if(tempint == 0){
                        tempint += 3;
                    }else{
                        tempint *=3;
                    }
                    inttoadd = true;

                    break;
                case ')' :
                    if(st.isEmpty() || (temp = st.pop()) != '('){
                        over =true;
                        break;
                    }
                    if(tempint == 0){
                        tempint += 2;
                    }else{
                        tempint *=2;
                    }
                    inttoadd = true;

                    break;
            }
            if(over)
                break;
        }
        if(over)
            System.out.println(0);
        else
            System.out.println(answer);
    }
}
