package Baekjoon.bj7569_토마토;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    private static int[][][] box;
    private static Queue<Location> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int hei = Integer.parseInt(st.nextToken());
        box = new int [hei+2][row+2][col+2];
        for(int[][] side:box){
            for(int[] arr:side){
                Arrays.fill(arr,-1);
            }
        }
        int tomato = 0;
        int doneTom = 0;
        for(int h = 0 ; h < hei; h++){
            for(int r = 0 ; r < row ; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < col ; c++){
                    int now = Integer.parseInt(st.nextToken());
                    if(now != -1){
                        tomato++;
                        if(now == 1){
                            doneTom++;
                            queue.add(new Location(h + 1, r + 1, c + 1));
                        }
                    }
                    box[h + 1][r + 1][c + 1] = now;
                }
            }
        }
        if(queue.size() == tomato){
            bw.write(0+"\n");
            bw.flush();
            bw.close();
            exit(0);
        }
        int answer = bfs(tomato,doneTom);


        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

    private static int bfs(int tomato, int doneTom){
        int hei = box.length;
        int row = box[0].length;
        int col = box[0][0].length;
        int day = 0;
        int[] dx = new int[] {1,-1,0,0,0,0};
        int[] dy = new int[] {0,0,-1,1,0,0};
        int[] dz = new int[] {0,0,0,0,1,-1};
        boolean[][][] visited = new boolean[hei][row][col];

        int tom = tomato;
        int done = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size;i++){
                Location l = queue.poll();
                if(!visited[l.height][l.row][l.column]){
                    visited[l.height][l.row][l.column] = true;
                    done++;
                    for(int j = 0; j<6;j++){
                        int tStatus = box[l.height+dz[j]][l.row+dx[j]][l.column+dy[j]];
                        if(tStatus == 0){
                            queue.add(new Location(
                                    l.height+dz[j],
                                    l.row+dx[j],
                                    l.column+dy[j]));
                        }
                    }
                }
            }
            if(done == tom){
                return day;
            }

            if(day > row*col*hei+2){
                return -1;
            }

            day++;

        }
        if(done < tom){
            return -1;
        }

        return day;

    }

    public static class Location{
        private int height;
        private int row;
        private int column;

        public Location(int height, int row, int column) {
            this.height = height;
            this.row = row;
            this.column = column;
        }
    }
}
