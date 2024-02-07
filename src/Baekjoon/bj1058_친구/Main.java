package Baekjoon.bj1058_친구;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //주어진 사람 수
        int people = Integer.parseInt(st.nextToken());


        //각자 친구 관계
        ArrayList<ArrayList<Integer>> rel = new ArrayList<>();

        //2-친구 모음
        ArrayList<HashSet<Integer>> dfriends = new ArrayList<>();

        //입력값 읽어와서 친구 관계 확인
        for(int i = 0 ; i < people ; i++){
            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();

            HashSet<Integer> dfriend = new HashSet<>();
            ArrayList<Integer> friends = new ArrayList<>();
            for(int j = 0 ; j < people; j++){
                if(input[j] == 'Y'){
                    friends.add(j);
                    dfriend.add(j);
                }
            }
            rel.add(friends);
            dfriends.add(dfriend);
        }

        // 한다리 건너 2-친구들 추가
        for(int i = 0 ; i < people ; i++){
            HashSet<Integer> dfriend = dfriends.get(i);

            // 직접 친구들이 담긴 list 받아옴
            ArrayList<Integer> friends = rel.get(i);

            // 그 친구들의 list 받아와 그 친구들의 친구들 본인과 다른 사람 set에 추가
            for(int f : friends){
                ArrayList<Integer> ff = rel.get(f);
                for(int d_f : ff){
                    if(d_f != i){
                        dfriend.add(d_f);
                    }
                }
            }
        }

        int answer = 0;
        // 2-친구 가장 많은 값 탐색
        for(HashSet<Integer> dFr : dfriends){
            if(dFr.size()>answer){
                answer = dFr.size();
            }
        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();
    }
}
