package Baekjoon.bj9251_LCS;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        char[] b = st.nextToken().toCharArray();

        int[][] answer = new int[a.length+1][b.length+1];
        for(int i = 1 ; i < a.length+1 ;i++){
            for(int j = 1 ; j < b.length+1 ; j++ ) {
                if (a[i-1] == b[j-1]) {
                    if (answer[i - 1][j - 1] + 1 <= j) {
                        answer[i][j] = answer[i - 1][j - 1] + 1;
                        continue;
                    }
                }
                answer[i][j] = Math.max(answer[i-1][j],answer[i][j-1]);
            }
        }

        bw.write(answer[answer.length-1][answer[0].length-1]+"\n");
        bw.flush();
        bw.close();
    }
}
