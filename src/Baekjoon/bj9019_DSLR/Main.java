package Baekjoon.bj9019_DSLR;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = "";
        int start;
        int end;
        int time = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < time ; i++){
            st = new StringTokenizer(br.readLine());
            start =Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            answer = findShortestCommand(start, end);
            bw.write(answer +"\n");
        }
        bw.flush();
        bw.close();
    }

    // bfs를 통해 탐색 진행
    private static String findShortestCommand(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        String[] commands = new String[10000];
        boolean[] visited = new boolean[10000];
        Arrays.fill(commands,  "");

        // 처음 start 값을 가지고 한번 씩 d,s,l,r 연산을 하여 확인 후 큐에 넣는 것
        int d,s,l,r;
        d = dCommand(start);
        if(d == end){
            return "D";
        }
        queue.add(d);
        commands[d] = "D";
        visited[d] = true;

        s = sCommand(start);
        if(s == end){
            return "S";
        }
        queue.add(s);
        commands[s] = "S";
        visited[s] = true;

        l = lCommand(start);
        if(l == end){
            return "L";
        }
        queue.add(l);
        commands[l] = "L";
        visited[l] = true;

        r = rCommand(start);
        if(r == end){
            return "R";
        }
        queue.add(r);
        commands[r] = "R";
        visited[r] = true;


        // bfs 진행하는 부분
        while(!queue.isEmpty()){

            // 여기서는 다르게 뽑아서 확인 후 연산 결과를  큐에 넣을 때 visited를 true로 바꿔 준다.
            int current = queue.poll();
            d = dCommand(current);
            if(d == end){
                return commands[current]+"D";
            }
            if(!visited[d]){
                queue.add(d);
                commands[d] = commands[current]+"D";
                visited[d] = true;
            }

            s = sCommand(current);
            if(s == end){
                return commands[current]+"S";
            }
            if(!visited[s]){
                queue.add(s);
                commands[s] = commands[current]+"S";
                visited[s] = true;
            }

            l = lCommand(current);
            if(l == end){
                return commands[current]+"L";
            }
            if(!visited[l]){
                queue.add(l);
                commands[l] = commands[current]+"L";
                visited[l] = true;
            }

            r = rCommand(current);
            if(r == end){
                return commands[current]+"R";
            }
            if(!visited[r]){
                queue.add(r);
                commands[r] = commands[current]+"R";
                visited[r] = true;
            }


        }
        return "";

    }

    //각종 d,s,l,r을 하는 함수들
    private static int dCommand(int input){
        return (2*input) % 10000;
    }

    private static int sCommand(int input){
        if(input == 0){
            return 9999;
        }
        return input-1;
    }

    private static int lCommand(int input){
        return (input % 1000) * 10 + input / 1000;
    }

    private static int rCommand(int input){
        return (input % 10) * 1000 + input / 10;
    }
}
