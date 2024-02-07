package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2750_수정렬하기_bubble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        int[] input = new int[length];
        for(int i = 0 ; i < length ;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        bubble_sort(input);

        for(int i = 0 ; i < length ;i++){
            sb.append(input[i]).append('\n');
        }

        System.out.println(sb);
    }

    private static void bubble_sort(int[] input) {
        int length = input.length;
        int temp;
        for(int i = length-1 ; i>0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(input[j]>input[j+1]){
                    temp =input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
        }
    }
}
