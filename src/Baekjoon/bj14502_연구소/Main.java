package Baekjoon.bj14502_연구소;

import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int[][] board;
    static Queue<int[]> initQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N+2][M+2];
        for(int i = 0 ; i < board.length;i++){
            Arrays.fill(board[i],-1);
        }

        for(int i = 1 ; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < M+1 ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2){
                    initQ.add(new int[]{i,j});
                }
            }
        }

        dfs(0);


        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int c){
        if(c == 3){
            bfs(board);
            return;
        }
        
        for(int i = 1 ; i < board.length-1; i++){
            for(int j = 1; j < board[0].length-1; j++){
                if(board[i][j]==0){
                    board[i][j] = 1;
                    dfs(c+1);
                    board[i][j] =0;
                }
            }
        }
    }

    public static void bfs(int[][] board){
        Queue<int[]> move = new LinkedList<>(initQ);
        boolean[][] visited = new boolean[board.length-2][board[0].length-2];
        int[][] spread = new int[board.length][board[0].length];

        for(int i = 0 ; i < board.length; i++){
            spread[i] = board[i].clone(); 
        }
        
        int temp;
        int[] cLoc;
        while(!move.isEmpty()){
            cLoc = move.poll();
            visited[cLoc[0]-1][cLoc[1]-1] = true;

            for(int index = 0 ; index < 4 ; index++){
                temp = spread[cLoc[0]+dx[index]][cLoc[1]+dy[index]];
                if(temp == -1 || temp == 1){
                    continue;
                }
                if(visited[cLoc[0]+dx[index]-1][cLoc[1]+dy[index]-1]){
                    continue;
                }
                spread[cLoc[0]+dx[index]][cLoc[1]+dy[index]] = 2;
                move.add(new int[]{cLoc[0]+dx[index],cLoc[1]+dy[index]});
            }
        }
        int tempA = 0;
        for(int i = 0 ; i < spread.length ;i++){
            for(int j = 0 ; j < spread[0].length; j++){
                if(spread[i][j]==0){
                    tempA++;
                }
            }
        }
        answer = Math.max(tempA,answer);
    }
}
