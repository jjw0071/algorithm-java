package Baekjoon;

import java.util.Scanner;

public class bj1913_달팽이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int input = sc.nextInt();
        int tofind = sc.nextInt();
        int count = input*input;
        int x=1;
        int y=1;
        int[] answer = {0,0};
        int[][] table = new int[input+2][input+2];
        for(int i=0; i < table.length;i++){
            for(int j = 0 ; j<table[0].length;j++){
                if(i==0 || j==0 || i ==input+1 || j==input+1){
                    table[i][j] = -1;
                }
            }
        }
        A:while(true){
            while(table[x][y]==0){
                table[x][y] = count;
                if(count == tofind){
                    answer[0] = x;
                    answer[1] = y;
                }
                count--;
                if(count == 0){
                    break A;
                }
                x++;
            }
            x--;
            y++;
            while(table[x][y]==0){
                table[x][y] = count;
                if(count == tofind){
                    answer[0] = x;
                    answer[1] = y;
                }
                count--;
                if(count == 0){
                    break A;
                }
                y++;
            }
            y--;
            x--;
            while(table[x][y]==0){
                table[x][y] = count;
                if(count == tofind){
                    answer[0] = x;
                    answer[1] = y;
                }
                count--;
                if(count == 0){
                    break A;
                }
                x--;
            }
            x++;
            y--;
            while(table[x][y]==0){
                table[x][y] = count;
                if(count == tofind){
                    answer[0] = x;
                    answer[1] = y;
                }
                count--;
                if(count == 0){
                    break A;
                }
                y--;
            }
            y++;
            x++;
        }
        for(int i = 1 ; i<input+1;i++){
            for(int j = 1 ; j<input+1;j++){
                sb.append(table[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.append(answer[0]).append(' ').append(answer[1]);
        System.out.println(sb);

    }



}
