package Baekjoon.bj2178_미로탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] maze = new int[row+2][col+2];
        for(int[] oneRow : maze){
            Arrays.fill(oneRow,0);
        }

        int num=0;

        for(int i = 1 ; i < row+1;i++){
            String line = br.readLine();
            String[] splitted = line.split("");
            for(int j = 1 ; j < col+1;j++){
                num = Integer.parseInt(splitted[j-1]);
                maze[i][j] = num;
            }
        }
        int answer = 0;

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
