package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        int[] toSort = new int[length];
        for(int i = 0 ; i < length; i++){
            toSort[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(toSort);
        for(int i = 0 ; i < length ;i++){
            sb.append(toSort[i]).append('\n');
        }
        System.out.println(sb);

    }
}
