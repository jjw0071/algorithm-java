package Baekjoon;

import java.io.*;
import java.util.*;

public class bj1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< size ;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        int answer =0;
        Arrays.sort(nums);
        int startindex = 0;
        int endindex = size-1;
        int check = 0;
        while(startindex <endindex){
            check = nums[startindex]+nums[endindex];
            if(check>target){
                endindex--;
                continue;
            }
            if(check == target){
                endindex--;
                startindex++;
                answer++;
                continue;
            }
            if(check<target){
                startindex++;
                continue;
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();



    }
}
