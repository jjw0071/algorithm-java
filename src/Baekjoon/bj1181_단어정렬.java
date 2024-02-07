package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < length;i++){
            set.add(br.readLine());
        }

        String[] words = set.toArray(new String[0]);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()){
                    return o1.length() - o2.length();
                }
                char[] co1 = o1.toCharArray();
                char[] co2 = o2.toCharArray();
                int index = 0;
                while(co1[index]==co2[index]){
                    index++;
                }
                return co1[index]-co2[index];

            }
        });

        for(int i = 0 ; i < words.length ;i++){
            sb.append(words[i]).append('\n');

        }


        System.out.println(sb);

    }
}
