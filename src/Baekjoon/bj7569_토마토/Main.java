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
        // 토마토 수
        int tomato = 0;

        // 익은 토마토 수
        int doneTom = 0;

        // 처음 입력값 확인하며 박스에 토마토 채우기
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

        // 이미 익은 토마토와 총 토마토 수가 같을 경우 0 출력하고 종료
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

            // 당일에 큐에 들어있는 위치 확인(하루동안 익은 토마토만 확인)
            int size = queue.size();
            for(int i = 0 ; i < size;i++){
                Location l = queue.poll();
                if(!visited[l.height][l.row][l.column]){
                    visited[l.height][l.row][l.column] = true;
                    done++;

                    // 앞, 뒤, 좌, 우, 상, 하를 확인해 익지 않은 토마토의 위치만 큐에 추가
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

            // 존재하는 토마토가 모두 익은 경우
            if(done == tom){
                return day;
            }

            // 전체 박스 칸 수보다 일 수가 더 커지면 모든 칸을 확인했다 생각하고 -1 return
            if(day > row*col*hei+2){
                return -1;
            }

            // 하루가 지남
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
