package Baekjoon.bj11399_ATM;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int[] waitlist = new int[length];

        st = new StringTokenizer(br.readLine());
        int person;
        for(int i =0 ; i < length;i++){
            person = Integer.parseInt(st.nextToken());
            waitlist[i] = person;
        }
        Arrays.sort(waitlist);

        int totalTime = 0;
        for(int i=0 ; i < length ;i++){
            totalTime += waitlist[i] * (length-i);
        }


        bw.write(totalTime+"\n");
        bw.flush();
        bw.close();
    }
}
