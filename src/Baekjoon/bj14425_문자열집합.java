package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj14425_문자열집합 {
    public static void main(String[] args) throws NumberFormatException,IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<String> al = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ;i <n ; i++){
            al.add(br.readLine());
        }
        int answer = 0;
        for(int i = 0 ; i<m;i++){
            if(al.contains(br.readLine())){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
