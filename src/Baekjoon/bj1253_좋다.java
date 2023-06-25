package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < size ;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int startindex = 0;
        int lastindex = size-1;
        int answer = 0;
        int check = 0;

        for(int i = 0 ; i < size ;i++){
            startindex = 0;
            lastindex = size-1;
            while(startindex<lastindex){
                check = nums[startindex]+ nums[lastindex];
                if(nums[i] == check){
                    answer++;
                    break;
                }
                if(check < nums[i]){
                    startindex++;
                    if(startindex == i){
                        startindex++;
                    }
                    if(lastindex == i){
                        lastindex--;
                    }
                    continue;
                }
                if(check > nums[i]){
                    lastindex--;
                    if(startindex == i){
                        startindex++;
                    }
                    if(lastindex == i){
                        lastindex--;
                    }
                    continue;
                }


            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
