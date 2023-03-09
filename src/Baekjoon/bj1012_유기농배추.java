package Baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bj1012_유기농배추 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        Stack<int[]> listoflettuce;
        Queue<int[]> placetocheck;
        boolean[][] visited;
        int[][] farm;
        int[] temp;
        while(testcase!=0){
            int length;
            int height;
            int bugs = 0;
            length = sc.nextInt();
            height = sc.nextInt();
            listoflettuce = new Stack<>();
            placetocheck = new ArrayDeque<>();
            farm = new int[height+2][length+2];
            visited = new boolean[height+2][length+2];
            int lettuce = sc.nextInt();
            for(int i = 0 ; i< lettuce;i++){
                length = sc.nextInt();
                height = sc.nextInt();
                farm[height+1][length+1] = 1;
                listoflettuce.add(new int[]{height+1,length+1});
            }

            //search sequence begins
            while(!listoflettuce.isEmpty()){
                if(placetocheck.isEmpty()){
                    temp = listoflettuce.pop();
                    if(!visited[temp[0]][temp[1]])
                        bugs++;
                    else continue;
                }else{
                    temp = placetocheck.poll();
                }

                if(!visited[temp[0]][temp[1]])
                    visited[temp[0]][temp[1]] = true;
                else continue;

                if(farm[temp[0]-1][temp[1]] == 1){
                    placetocheck.add(new int[]{temp[0]-1,temp[1]});
                }
                if(farm[temp[0]][temp[1]+1] == 1){
                    placetocheck.add(new int[]{temp[0],temp[1]+1});
                }
                if(farm[temp[0]][temp[1]-1] == 1){
                    placetocheck.add(new int[]{temp[0],temp[1]-1});
                }
                if(farm[temp[0]+1][temp[1]] == 1){
                    placetocheck.add(new int[]{temp[0]+1,temp[1]});
                }
            }
            System.out.println(bugs);
            testcase--;

        }

    }
}
