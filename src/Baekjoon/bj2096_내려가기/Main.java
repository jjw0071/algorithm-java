package Baekjoon.bj2096_내려가기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        int[][] small = new int[count][3];
        int[][] big = new int[count][3];
        int[][] stair = new int[count][3];

        for(int i=0;i<count;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                stair[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        small[0][0] = stair[0][0];
        small[0][1] = stair[0][1];
        small[0][2] = stair[0][2];
        big[0][0] = stair[0][0];
        big[0][1] = stair[0][1];
        big[0][2] = stair[0][2];

        for(int i=1;i<count;i++) {
            small[i][0] = Math.min(small[i-1][0],small[i-1][1]) + stair[i][0];
            small[i][1] = Math.min(small[i-1][0], Math.min(small[i-1][1], small[i-1][2])) + stair[i][1];
            small[i][2] = Math.min(small[i-1][1], small[i-1][2]) + stair[i][2];

            big[i][0] =  Math.max(big[i-1][0], big[i-1][1]) + stair[i][0];
            big[i][1] = Math.max(big[i-1][0], Math.max(big[i-1][1],big[i-1][2])) + stair[i][1];
            big[i][2] = Math.max(big[i-1][1],big[i-1][2]) + stair[i][2];
        }

        int a = 0, b = 0;
        for(int i = 0 ; i < 3; i ++){
            a= Math.max(big[count-1][0], Math.max(big[count-1][1], big[count-1][2]));
            b= Math.min(small[count-1][0], Math.min(small[count-1][1], small[count-1][2]));
        }

        bw.write(a+" "+b);
        bw.flush();
        bw.close();
    }
}
