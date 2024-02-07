package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj4949_균형잡힌세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String toread = br.readLine();
        char[] tocheck = toread.toCharArray();
        if(isBalanced(tocheck)){
            sb.append("YES").append('\n');
        }else{
            sb.append("NO").append('\n');
        }

        System.out.println(sb);

    }

    private static boolean isBalanced(char[] tocheck) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < tocheck.length; i++){
            switch (tocheck[i]){
                case '(', '[':
                    stack.add(tocheck[i]);
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(!(stack.pop() == '(')){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(!(stack.pop() == '[')){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
}
