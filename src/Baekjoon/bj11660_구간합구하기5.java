package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int iteration = Integer.parseInt(st.nextToken());
        int sum[][] = new int[length][length+1];
        for(int i = 0 ; i < length ; i++){
            st  = new StringTokenizer(br.readLine());
            sum[i][0] = 0;
            for(int j = 0 ; j <length;j++){
                sum[i][j+1]= sum[i][j]+Integer.parseInt(st.nextToken());
            }
        }
        int x1,y1,x2,y2,answer;
        for(int i = 0 ; i< iteration;i++){
            st = new StringTokenizer(br.readLine());
            answer = 0;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int j = x1 ; j < x2+1;j++){
                answer += sum[j-1][y2]-sum[j-1][y1-1];
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
