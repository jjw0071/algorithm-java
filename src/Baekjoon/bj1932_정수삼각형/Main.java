package Baekjoon.bj1932_정수삼각형;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> prior = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());

        int answer = 0;
        int cur = 0;

        // 방법 1 읽으며 바로바로 처리
        for(int i = 0 ;i < N ; i++){
            st = new StringTokenizer(br.readLine());
            if ( i == 0 ){
                cur =Integer.parseInt(st.nextToken());
                prior.add(cur);
                answer = cur;
                continue;
            }

            if ( i == N-1){
                for(int j = 0; j < N ; j++){
                    cur = Integer.parseInt(st.nextToken());
                    if(j == 0 ){
                        answer = Math.max(answer, prior.get(j)+cur);
                        continue;
                    }

                    if(j == N-1){
                        answer = Math.max(answer, prior.get(j-1)+cur);
                        break;
                    }

                    answer = Math.max(answer,
                            Math.max(prior.get(j-1)+cur,prior.get(j)+cur));
                }
                break;
            }

            for(int j = 0 ; j < i+1 ; j++){
                cur = Integer.parseInt(st.nextToken());
                if(j == 0 ){
                    prior.add(prior.get(j)+cur);
                    continue;
                }

                if(j == i){
                    prior.add(prior.get(j-1)+cur);
                    for(int k = 0 ; k < j ; k++){
                        prior.remove(0);
                    }
                    break;
                }

                prior.add(Math.max(prior.get(j-1)+cur,prior.get(j)+cur));
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
