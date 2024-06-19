package Baekjoon.bj16928_뱀과사다리게임;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int move = Integer.parseInt(st.nextToken());
        move += Integer.parseInt(st.nextToken());

        int[] board = new int[101];
        int start;
        int end;
        for(int i = 0 ; i < move; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            board[start] = end-start;
        }

        int[] shortest = new int[101];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,2});
        q.add(new int[]{0,3});
        q.add(new int[]{0,4});
        q.add(new int[]{0,5});
        q.add(new int[]{0,6});
        q.add(new int[]{0,7});

        int[] cur;
        Arrays.fill(shortest,100);
        move = 0;
        int size;
        A:while(!q.isEmpty()){
            move++;
            size = q.size();
            for(int count = 0; count < size;count++){
                cur = q.poll();
                if(shortest[cur[1]]<cur[0]+1){
                    continue;
                }
                shortest[cur[1]] = cur[0]+1;
                if(cur[1] == 100){
                    break A;
                }
                for(int i = 1; i < 7 ; i++){
                    if(cur[1]+board[cur[1]]+i<=100){
                        q.add(new int[]{cur[0]+1,cur[1]+board[cur[1]]+i});
                    }
                }
            }
        }

        bw.write(move+"\n");
        bw.flush();
        bw.close();
    }
}
