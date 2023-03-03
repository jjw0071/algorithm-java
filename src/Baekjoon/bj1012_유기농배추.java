package Baekjoon;

import java.util.Scanner;

public class bj1012_유기농배추 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while(testcase!=0){
            int length;
            int height;
            length = sc.nextInt();
            height = sc.nextInt();
            int[][] farm = new int[height+2][length+2];
            int lettuce = sc.nextInt();
            for(int i = 0 ; i< lettuce;i++){
                length = sc.nextInt();
                height = sc.nextInt();
                farm[height+1][length+1] = 1;
            }




        }

    }
}
