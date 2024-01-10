package Programmers.pm1844_게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution(int[][] maps) {
        int[][] realMap = new int[maps.length+2][maps[0].length+2];
        for(int i = 0 ; i < maps.length;i++){
            for(int j = 0 ; j < maps[0].length;j++){
                realMap[i+1][j+1] = maps[i][j];
            }
        }
        if(maps[maps.length-1][maps[0].length-1]==0){
            return -1;
        }

        return bfs(realMap);
    }

    private static int bfs(int[][] realMap){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[realMap.length][realMap[0].length];
        queue.add(new int[]{1,1});
        int maximum = realMap.length*realMap[0].length;
        int count = 0;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        if(realMap[realMap.length-3][realMap[0].length-2]==0 &&
                realMap[realMap.length-2][realMap[0].length-3]==0){
            return -1;
        }
        while(!queue.isEmpty()){
            int[] toCheck = queue.poll();
            int row = toCheck[0];
            int col = toCheck[1];
            if(visited[row][col]){
                continue;
            }

            visited[row][col] = true;
            for(int i = 0 ; i < dx.length;i++){
                if(realMap[row+dx[i]][col+dy[i]]==1 && !visited[row+dx[i]][col+dy[i]]){
                    queue.add(new int[]{row+dx[i],col+dy[i]});
                    realMap[row+dx[i]][col+dy[i]] = realMap[row][col]+1;
                }
            }
            count++;
            if(count>maximum){
                return -1;
            }
            if(realMap[realMap.length-2][realMap[0].length-2]!=1){
                return realMap[realMap.length-2][realMap[0].length-2];
            }

        }
        return -1;
    }
}
