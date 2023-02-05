package bj1874;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt(); // 정수의 개수
        String command;
        int put;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for(int i =0 ; i<num;i++){
            command = sc.next();
            switch(command) {
                case "push" :
                    put = sc.nextInt();
                    que.add(put);
                    break;
                case "pop" :
                    if(que.isEmpty())
                        sb.append(-1).append('\n');
                    else
                        sb.append(que.poll()).append('\n');
                    break;
                case "size" :
                    sb.append(que.size()).append('\n');
                    break;
                case "empty" :
                    if(que.isEmpty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front" :
                    if(que.isEmpty())
                        sb.append(-1).append('\n');
                    else sb.append(que.peek()).append('\n');
                    break;
                case "back" :
                    if(que.isEmpty())
                        sb.append(-1).append('\n');
                    else sb.append(que.getLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);


    }

}
