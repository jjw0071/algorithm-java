package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj_template {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }

}
