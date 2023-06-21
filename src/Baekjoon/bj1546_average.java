package Baekjoon;

import java.util.Scanner;

public class bj1546_average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float sum = 0;
        int max = 0;
        int temp;
        for(int i = 0 ; i<n;i++) {
            temp = sc.nextInt();
            sum += temp;
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(sum*100/(max*n));
    }
}
