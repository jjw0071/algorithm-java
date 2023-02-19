package Programmers.pm12909;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    boolean solution(String s) {
        boolean answer = true;
        char[] arr= s.toCharArray();
        Stack<Character> st = new Stack<>();
        char com;
        for(int i = 0 ;i < arr.length;i++){
            com = arr[i];
            switch (com){
                case '(' : st.add(com);
                break;
                case ')' :
                    if(st.isEmpty()){
                        return false;
                    }
                    st.pop();
                    break;
                }
            }
        return st.isEmpty();
        }

}

