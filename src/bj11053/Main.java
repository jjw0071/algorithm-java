package bj11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] howlong = new int[num][num+1];
        for(int i = 0 ; i < num; i++){
            howlong[i][0] = 0;
        }

        for(int i = 0; i<num;i++){
            int input = sc.nextInt();
            boolean check = false;
            int j = 0;
            while(!check){
                if(howlong[j][0] == 0){
                    howlong[j][1] = input;
                    howlong[j][0] = 1;
                    check = true;
                }else if(howlong[j][howlong[j][0]]<input){
                    howlong[j][howlong[j][0]+1] = input;
                    howlong[j][0]++;
                    check = true;
                }else {
                    j++;
                }
            }
        }

        for(int i = 0; i<howlong.length;i++){
            for(int j = 0;j<howlong[0].length;j++)
                System.out.print(howlong[i][j]+" ");
            System.out.println();
        }

        int answer = 0;
        for(int i = 0; i<howlong.length;i++){
            if(howlong[i][0]>answer)
                answer = howlong[i][0];
        }
        if(answer == 1)
            answer = 0;
        System.out.println(answer);
    }
}
