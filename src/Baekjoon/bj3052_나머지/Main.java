package Baekjoon.bj3052_나머지;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int input;
        for(int i = 0 ; i < 10 ;i++ ){
            input = sc.nextInt();
            hashSet.add(input%42);
        }
        System.out.println(hashSet.size());
    }
}
