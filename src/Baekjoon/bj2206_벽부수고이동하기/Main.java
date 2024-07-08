package Baekjoon.bj2206_벽부수고이동하기;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        map = new int[row + 2][col + 2];
        for (int[] l : map) {
            Arrays.fill(l, -1);
        }

        for (int i = 1; i <= row; i++) {
            String line = br.readLine();
            for (int j = 1; j <= col; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        int answer = bfs(row, col);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static int bfs(int row, int col) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1, 0});

        boolean[][][] visited = new boolean[row + 2][col + 2][2];
        int[][][] route = new int[row + 2][col + 2][2];
        route[1][1][0] = 1;

        while (!q.isEmpty()) {
            int[] next = q.poll();
            int x = next[0], y = next[1], brokeWall = next[2];

            if (x == row && y == col) {
                return route[x][y][brokeWall];
            }

            if (visited[x][y][brokeWall]) continue;
            visited[x][y][brokeWall] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (map[nx][ny] == -1) continue;

                int newBrokeWall = brokeWall;
                if (map[nx][ny] == 1) {
                    if (brokeWall == 1) continue;
                    newBrokeWall = 1;
                }

                if (!visited[nx][ny][newBrokeWall]) {
                    route[nx][ny][newBrokeWall] = route[x][y][brokeWall] + 1;
                    q.add(new int[]{nx, ny, newBrokeWall});
                }
            }
        }

        return -1;
    }
}
