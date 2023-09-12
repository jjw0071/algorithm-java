package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class bj18258_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int count = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "push" :
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;

                case "pop" :
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                        break;
                    }
                    sb.append(queue.peek()).append('\n');
                    queue.remove();
                    break;

                case "size" :
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty" :
                    if(queue.isEmpty()){
                        sb.append(1).append('\n');
                    }else{
                        sb.append(0).append('\n');
                    }
                    break;

                case "front" :
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(queue.peek()).append('\n');
                    }
                    break;

                case "back" :
                    if(queue.isEmpty()){
                        sb.append(-1).append('\n');
                    }else{
                        sb.append(queue.getLast()).append('\n');
                    }
                    break;
                default:
                    break;
            }

        }
        System.out.println(sb);



    }
}
