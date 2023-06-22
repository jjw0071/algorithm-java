package Baekjoon;

import java.util.Scanner;

public class bj11659_구간합구하기4 {
    public static void main(String[] args) {
        //구간 합 함수가 아닌 매번 전체 구간의 합 구하는 경우
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int iteration = sc.nextInt();
        int[] input = new int[length];
        for(int i = 0 ; i < length ; i++){
            input[i] = sc.nextInt();
        }
        int first;
        int last;
        int sum;
        for(int i = 0 ; i<iteration;i++){
            sum = 0;
            first = sc.nextInt();
            last = sc.nextInt();
            for(int j = first-1; j<last;j++){
                sum += input[j];
            }
            System.out.println(sum);
        }


    }
}
