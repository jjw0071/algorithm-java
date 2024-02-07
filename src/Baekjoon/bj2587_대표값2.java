package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2587_대표값2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[5];
        int sum = 0;
        for(int i = 0 ; i<5;i++){
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        Arrays.sort(scores);
        System.out.println(sum/5);
        System.out.println(scores[2]);
    }
}
