package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< count ;i++){
            String input = br.readLine();
            char[] chars = input.toCharArray();
            if(chars[0] == ')'){
                sb.append("NO").append('\n');
                continue;
            }
            if(checkVPS(chars)){
                sb.append("YES").append('\n');
            }else{
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);

    }

    private static boolean checkVPS(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for(int j = 0; j< chars.length; j++){
            if(chars[j] =='('){
                stack.add(chars[j]);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
