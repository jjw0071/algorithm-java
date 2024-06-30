package Baekjoon.bj9663_NQueen;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] board;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N];
        Arrays.fill(board,-100);

        for(int i = 0 ; i < N ; i++){
            board[0] = i;
            dfs(1);
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }


    public static void dfs(int idx){
        if(idx == N){
            answer++;
            return;
        }
        boolean possible;
        for(int i = 0 ; i < N; i++){
            possible = true;
            for(int j = 0 ; j < idx ; j++){
                if(board[j] == i){
                    possible = false;
                    break;
                }
            }

            if(!possible){
                continue;
            }

            possible = true;
            for(int j = idx-1 ; j >= 0 ; j--){
                if(board[j] == i+j-idx || board[j] == i-j+idx){
                    possible = false;
                    break;
                }
            }

            if(possible){
                board[idx] = i;
                dfs(idx+1);
            }
        }
    }
}
