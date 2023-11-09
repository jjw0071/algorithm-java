package Baekjoon.bj1018_체스판다시칠하기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] board = new int[row][col];
        for(int i = 0 ; i < row; i++){
            st = new StringTokenizer(br.readLine());
            String oneRow = st.nextToken();
            for(int j = 0 ; j < col ; j++){
                if(oneRow.charAt(j)=='B'){
                    board[i][j] = 0;
                }else{
                    board[i][j]=1;
                }
            }
        }
        int[][] answerExample1 = new int[8][8];
        int[][] answerExample2 = new int[8][8];
        int[] answerRow1 = {1,0,1,0,1,0,1,0};
        int[] answerRow2 = {0,1,0,1,0,1,0,1};
        for(int i = 0 ; i < 8; i++){
            if(i%2==0){
                answerExample1[i] = answerRow1;
            }else{
                answerExample1[i] = answerRow2;
            }
        }

        for(int i = 0 ; i < 8; i++){
            if(i%2==0){
                answerExample2[i] = answerRow2;
            }else{
                answerExample2[i] = answerRow1;
            }
        }
        int answer = checkAnswer(board,answerExample1,answerExample2);

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    public static int checkAnswer(int[][] board,
                                   int[][] answer1,
                                   int[][] answer2){
        int answer = board.length*board[0].length;
        int localMinimun = answer;
        for(int i=0; i <= board.length-8;i++){
            for(int j = 0 ; j <= board[0].length-8;j++){
                localMinimun = Math.min(
                        compareWithAnswer(i,i+8,j,j+8, board,answer1),
                        compareWithAnswer(i,i+8,j,j+8, board,answer2)
                );
                answer = Math.min(answer, localMinimun);
            }
        }
        return answer;
    }

    private static int compareWithAnswer(int rowStart,
                                         int rowEnd,
                                         int colStart,
                                         int colEnd,
                                         int[][] board,
                                         int[][] answer){
        int toPaint = 0;
        for(int i = rowStart ; i < rowEnd;i++){
            for(int j = colStart ; j < colEnd;j++){
                if(board[i][j] != answer[i-rowStart][j-colStart]){
                    toPaint++;
                }
            }
        }

        return toPaint;
    }
}
