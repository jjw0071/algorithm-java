package Baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class bj1874 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int num = sc.nextInt();
        for(int i = 0 ; i<num;i++){
            pq.add(i+1);
        }
        int targetnum = 0;
        for(int i = 0 ; i < num ;i++){
            targetnum = sc.nextInt();
            if(st.isEmpty()){
                if(pq.peek()>targetnum){
                    sb.setLength(0);
                    sb.append("NO").append('\n');
                    break;
                }
                do{
                    st.add(pq.poll());
                    sb.append('+').append('\n');
                }while(st.peek() != targetnum);
            }
            int topofstack = st.peek();
            if (topofstack > targetnum) {
                sb.setLength(0);
                sb.append("NO").append('\n');
                break;
            }else if(topofstack == targetnum){
                st.pop();
                sb.append('-').append('\n');
            } else if(topofstack<targetnum){
                while(st.peek() != targetnum){
                    st.add(pq.poll());
                    sb.append('+').append('\n');
                }
                st.pop();
                sb.append('-').append('\n');
            }
        }
        System.out.println(sb);
    }
}
