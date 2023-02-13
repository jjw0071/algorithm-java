package bj11053;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] input = new int[num];
        for(int i = 0 ; i < num; i++){
            input[i] = sc.nextInt();
        }
        int[] check = new int[num];
        int forComp;
        for(int i = 0;i<input.length;i++){
            forComp = input[i];
            int max = 1;
            boolean thereisbig = false;
            if(i != 0){
                for(int j = 0 ; j < i;j++){
                    if(input[j]<forComp){
                        thereisbig = true;
                        if(max<check[j])
                            max = check[j];
                    }
                }
                if(thereisbig)
                    max++;
            }
            check[i] = max;
        }
        int max = 1;
        for(int i = 0 ; i < check.length;i++){
            if(check[i]>max)
                max = check[i];
        }

        System.out.println(max);
    }
}
