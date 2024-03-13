package SWEA.swea1208_flatten;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int answer = 0;
        int maxMove = 0;
        int num = 0;

        for(int test_case = 1; test_case <= 10; test_case++){
            ArrayList<Integer> blocks = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            maxMove = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < 100 ; i++){
                num = Integer.parseInt(st.nextToken());
                blocks.add(num);
            }
            Collections.sort(blocks);
            blocks = flatten(blocks, maxMove);
            answer = blocks.get(99) - blocks.get(0);

            bw.write("#"+test_case+" "+answer+"\n");



        }
        bw.flush();
        bw.close();
    }

    private static ArrayList<Integer> flatten(ArrayList<Integer> blocks, int maxMove){

        int max, min;
        for(int i = 0 ; i < maxMove ; i++){
            min = blocks.get(0);
            max = blocks.get(99);
            blocks.remove(0);
            blocks.remove(98);
            blocks.add(++min);
            blocks.add(--max);
            Collections.sort(blocks);
        }

        return blocks;
    }
}
