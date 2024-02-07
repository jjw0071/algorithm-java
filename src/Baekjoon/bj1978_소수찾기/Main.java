package Baekjoon.bj1978_소수찾기;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        int count = sc.nextInt();
        int answer = 0;
        int number;
        for(int i = 0 ; i < count ;i++){
            number = sc.nextInt();
            if(isPrime(number)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isPrime(int number){
        if(number==1){
            return false;
        }
        int toDivide = number-1;
        while(toDivide>1){
            if(number%toDivide ==0){
                return false;
            }
            toDivide--;
        }
        return true;
    }
}
