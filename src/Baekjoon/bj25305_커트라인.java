package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj25305_커트라인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int cutline = sc.nextInt();
        int[] scores = new int[length];
        for(int i = 0 ; i < length;i++){
            scores[i] = sc.nextInt();
        }
        Arrays.sort(scores);
        System.out.println(scores[length-cutline]);

    }
}
