package SWEA.swea1206_view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 1;
        int answer;

        for(int test_case = 1; test_case <= T; test_case++){
            answer = 0;
            bw.write("#"+test_case+" ");
            st = new StringTokenizer(br.readLine());
            int totalBuildings = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            LinkedList<Integer> buildings = new LinkedList<>();
            buildings.add(0);
            buildings.add(0);
            int added = 2;
            buildings.add(Integer.parseInt(st.nextToken()));
            buildings.add(Integer.parseInt(st.nextToken()));
            while(added < totalBuildings){
                buildings.add(Integer.parseInt(st.nextToken()));
                added++;
                answer += check(buildings);
                buildings.poll();
            }

            for(int i = 0 ; i < 2 ; i++){
                buildings.add(0);
                answer += check(buildings);
                buildings.poll();
            }

            bw.write(answer+"\n");
        }
        bw.flush();
    }

    private static int check(LinkedList<Integer> buildings){
        int toCheck = buildings.get(2);
        int answer = 256;
        int diff;
        for(int i = 0 ; i < 5 ; i++){
            if(i == 2){
                continue;
            }
            diff =toCheck - buildings.get(i);
            if(diff < 0){
                return 0;
            }

            answer = Math.min(answer , diff);
        }

        return answer;
    }
}
