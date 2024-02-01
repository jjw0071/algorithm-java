package Baekjoon.bj10026_적록색약;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int side = Integer.parseInt(st.nextToken());

        // 배열 생성하기
        char[][] picture = new char[side+2][side+2];
        // 적록색약 용
        char[][] picture2 = new char[side+2][side+2];
        for(int i = 1 ; i <= side ;i++){
            st = new StringTokenizer(br.readLine());
            char[] line = st.nextToken().toCharArray();

            for(int j = 1 ; j <= side; j++){
                if(line[j-1] == 'B'){
                    picture[i][j] = 'B';
                    picture2[i][j] = 'B';
                }else{
                    picture2[i][j] = 'R';
                    if(line[j-1] == 'R'){
                        picture[i][j] = 'R';
                    }else{
                        picture[i][j] = 'G';
                    }
                }
            }
        }

        int answer = runBfs(picture);
        bw.write(answer+" ");

        answer = runBfs(picture2);
        bw.write(answer+" ");
        bw.flush();
        bw.close();
    }

    private static int runBfs(char[][] picture){
        int[] dx = new int[] {1,0,-1,0};
        int[] dy = new int[] {0,1,0,-1};
        boolean[][] visited = new boolean[picture.length][picture.length];
        Queue<int[]> queue = new LinkedList<>();

        int rowToCheck;
        int colToCheck;
        int sector = 0;
        for(int row = 1 ; row < picture.length-1;row++){
            for(int col = 1 ; col < picture.length-1;col++){
                if(!visited[row][col]){
                    sector++;
                    queue.add(new int[]{row,col});
                }

                while(!queue.isEmpty()){
                    int[] locationToCheck = queue.poll();
                    rowToCheck = locationToCheck[0];
                    colToCheck = locationToCheck[1];
                    if(visited[rowToCheck][colToCheck]){
                        continue;
                    }
                    visited[rowToCheck][colToCheck] = true;
                    char color = picture[rowToCheck][colToCheck];

                    for(int index = 0 ; index<4;index++){
                        if(picture[rowToCheck+dx[index]][colToCheck+dy[index]]==color){
                            queue.add(new int[]{rowToCheck+dx[index],colToCheck+dy[index]});
                        }
                    }
                }

            }
        }

        return sector;
    }
}
