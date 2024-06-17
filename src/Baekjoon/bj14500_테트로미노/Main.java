package Baekjoon.bj14500_테트로미노;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];

        for(int i = 0 ; i < row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int score = 0;
        ArrayList<int[][]> a = new ArrayList<>();
        ArrayList<int[][]> b = new ArrayList<>();

        a.add(new int[][]{{0,0}, {0,1}});
        a.add(new int[][]{{0,1}, {0,2}});
        a.add(new int[][]{{1,0}, {1,1}});
        a.add(new int[][]{{1,1}, {1,2}});
        a.add(new int[][]{{0,0}, {0,2}});
        a.add(new int[][]{{0,0}, {1,2}});
        a.add(new int[][]{{1,0}, {0,2}});
        a.add(new int[][]{{1,0}, {1,2}});

        b.add(new int[][]{{0,0},{1,0}});
        b.add(new int[][]{{1,0},{2,0}});
        b.add(new int[][]{{0,1},{1,1}});
        b.add(new int[][]{{1,1},{2,1}});
        b.add(new int[][]{{0,0},{2,0}});
        b.add(new int[][]{{0,0},{2,1}});
        b.add(new int[][]{{0,1},{2,0}});
        b.add(new int[][]{{0,1},{2,1}});

        int answer = 0;
        int space = 0;

        for(int i = 0 ; i<row ; i++ ){
            for(int j = 0 ; j < col-3 ; j++){
                space = board[i][j]+board[i][j+1]+board[i][j+2]+board[i][j+3];
                answer = Math.max(space, answer);
            }
        }

        for(int i = 0 ; i < row-3 ; i++){
            for(int j = 0;j < col ; j++){
                space = board[i][j]+board[i+1][j]+board[i+2][j]+board[i+3][j];
                answer = Math.max(space,answer);
            }
        }

        for(int i = 0 ; i < row-1 ; i++){
            for(int j = 0 ; j < col-1 ; j++){
                space = board[i][j]+board[i+1][j]+board[i][j+1]+board[i+1][j+1];
                answer = Math.max(space,answer);
            }
        }

        for(int i = 0 ; i < row-1 ; i++){
            for(int j = 0 ; j < col-2 ; j++){
                space = board[i][j]+board[i+1][j]+board[i][j+1]+board[i+1][j+1]+board[i][j+2]+board[i+1][j+2];
                for(int[][] hole : a){
                    answer = Math.max(answer,space - board[i+hole[0][0]][j+hole[0][1]]-board[i+hole[1][0]][j+hole[1][1]]);
                }
            }
        }

        for(int i = 0 ; i < row-2 ; i++){
            for(int j = 0 ; j < col-1 ; j++){
                space = board[i][j]+board[i][j+1]+board[i+1][j]+board[i+1][j+1]+board[i+2][j]+board[i+2][j+1];
                for(int[][] hole : b){
                    answer = Math.max(answer,space - board[i+hole[0][0]][j+hole[0][1]]-board[i+hole[1][0]][j+hole[1][1]]);
                }
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
