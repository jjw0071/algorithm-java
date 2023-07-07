package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        int[] nums = new int[chars.length];
        for(int i = 0 ; i < chars.length;i++){
            nums[i] = chars[i] - 48;
        }
        Arrays.sort(nums);
        for(int i = chars.length-1 ; i>=0;i--){
            sb.append(nums[i]);
        }
        System.out.println(sb);

    }
}
