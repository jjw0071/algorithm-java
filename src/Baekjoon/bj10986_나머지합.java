package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int todiv = Integer.parseInt(st.nextToken());
        int[] sum = new int[length+1];
        sum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< length;i++){
            sum[i+1] = sum[i] + Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i = 1 ; i<length+1;i++){
            for(int j = 0 ; j< i;j++){
                if((sum[i]-sum[j])%todiv==0){
                    answer++;
                }
            }
        }
        bw.write(answer+"\n");
        bw.flush();
        bw.close();

    }
}
