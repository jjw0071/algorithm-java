package Baekjoon.bj5430_AC;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 개수
        int test_case = Integer.parseInt(st.nextToken());

        // 테스트 케이스 만큼 반복
        for(int i = 0 ; i < test_case ; i++){
            // 명령어를 char[] 형태로 받아옴.
            st = new StringTokenizer(br.readLine());
            char[] command = st.nextToken().toCharArray();

            // 총 배열의 길이
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());

            // 실제 배열을 string으로 받아옴.
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            // 받아온 string에서 '[', ']' 제거
            input = input.substring(1, input.length()-1);

            // string에서 ,으로 분리
            String[] strings = input.split(",");

            // 각각의 값을 deque에 int로 바꾸어 추가
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(String s : strings){
                if(s.isBlank()){
                    break;
                }
                deque.add(Integer.parseInt(s));
            }

            String answer = work(command, deque);
            bw.append(answer).append("\n");
        }

        bw.flush();
        bw.close();
    }

    private static String work(char[] command, ArrayDeque<Integer> deque){
        // 처음 뒤집기 전 front -> back 으로 보도록 함.
        boolean forward = true;

        for( char com : command){
            switch (com){
                case 'R' :
                    forward = !forward;
                    continue;

                case 'D' :
                    if(deque.isEmpty()){
                        return "error";
                    }
                    if(forward){
                        deque.removeFirst();
                        continue;
                    }
                    deque.removeLast();
                    continue;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(deque.isEmpty()){
            sb.append("]");
            return sb.toString();
        }
        if(forward){
            while(deque.size()>1){
                sb.append(deque.getFirst()).append(',');
                deque.removeFirst();
            }
            sb.append(deque.getFirst()).append(']');
            return sb.toString();
        }

        while(deque.size()>1){
            sb.append(deque.getLast()).append(',');
            deque.removeLast();
        }
        sb.append(deque.getLast()).append(']');
        return sb.toString();



    }
}
