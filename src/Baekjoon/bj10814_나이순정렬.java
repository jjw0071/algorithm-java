package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        String[][] inputs = new String[length][2];
        for(int i = 0 ; i < length;i++){
            st = new StringTokenizer(br.readLine());
            inputs[i][0] = st.nextToken();
            inputs[i][1] = st.nextToken();
        }
        Arrays.sort(inputs, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])){
                    return 0;
                }else{
                    return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
                }
            }
        });

        for(int i = 0 ; i < inputs.length ;i++){
            sb.append(inputs[i][0]).append(' ').append(inputs[i][1]).append('\n');

        }


        System.out.println(sb);

    }
}
