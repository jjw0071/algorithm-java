package Baekjoon;

import java.util.Scanner;

public class bj11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] c = s.toCharArray();
        int answer = 0;
        for(int i = 0 ; i<n;i++){
            answer += c[i]-48;
        }
        System.out.println(answer);
    }
}
