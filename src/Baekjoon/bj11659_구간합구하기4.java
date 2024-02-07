package Baekjoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        //구간 합 함수가 아닌 매번 전체 구간의 합 구하는 경우
        /*Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int iteration = sc.nextInt();
        int[] input = new int[length];
        for(int i = 0 ; i < length ; i++){
            input[i] = sc.nextInt();
        }
        int first;
        int last;
        int sum;
        for(int i = 0 ; i<iteration;i++){
            sum = 0;
            first = sc.nextInt();
            last = sc.nextInt();
            for(int j = first-1; j<last;j++){
                sum += input[j];
            }
            System.out.println(sum);
        }*/

        //구간의 합 구하는 경우
        /*Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int iteration = sc.nextInt();
        int[] sum = new int[length+1];
        sum[0] = 0;
        for(int i = 0 ; i < length;i++){
            sum[i+1] = sum[i]+sc.nextInt();
        }
        int first, last;
        for(int i = 0 ; i < iteration ;i++){
            first = sc.nextInt();
            last = sc.nextInt();
            System.out.println(sum[last]-sum[first-1]);
        }*/

        //구간의 합 구하는 경우(빠른 입출력)
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int iteration = Integer.parseInt(st.nextToken());
        int[] sum = new int[length+1];
        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for(int i = 0 ; i < length;i++){
            sum[i+1] = sum[i]+Integer.parseInt(st.nextToken());
        }
        int first, last,answer;
        for(int i = 0 ; i < iteration ;i++){
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            last = Integer.parseInt(st.nextToken());
            answer =sum[last]-sum[first-1];
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
