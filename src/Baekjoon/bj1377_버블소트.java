package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        int[] input = new int[length];
        for(int i = 0 ; i < length ;i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(bubble_sort(input));


    }

    private static int bubble_sort(int[] input) {
        boolean check = false;
        int length = input.length;
        int temp;
        for(int i = 0 ; i<length ; i++){
            check = false;
            for(int j = 0 ; j<length-i-1 ; j++){
                if(input[j]>input[j+1]){
                    check = true;
                    temp =input[j+1];
                    input[j+1] = input[j];
                    input[j] = temp;
                }
            }
            if(!check){
                return i+1;
            }
        }
        return 1;
    }
}
