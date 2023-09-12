package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] toSort = new int[length];
        for(int i = 0 ; i < length; i++){
            toSort[i] = sc.nextInt();
        }

        Arrays.sort(toSort);
        for(int i = 0 ; i < length ;i++){
            System.out.println(toSort[i]);
        }

    }
}
