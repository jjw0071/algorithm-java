package Baekjoon.bj10866;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        String command;
        int commandnum;
        for(int i = 0 ; i < num ; i++){
            command = sc.next();
            switch (command) {
                case "push_front" -> {
                    commandnum = sc.nextInt();
                    ad.addFirst(commandnum);
                }
                case "push_back" -> {
                    commandnum = sc.nextInt();
                    ad.addLast(commandnum);
                }
                case "pop_front" -> {
                    if (ad.isEmpty())
                        sb.append(-1).append('\n');
                    else sb.append(ad.removeFirst()).append('\n');
                }
                case "pop_back" -> {
                    if (ad.isEmpty())
                        sb.append(-1).append('\n');
                    else sb.append(ad.removeLast()).append('\n');
                }
                case "size" -> sb.append(ad.size()).append('\n');
                case "empty" -> {
                    if (ad.isEmpty())
                        sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                }
                case "front" -> {
                    if (ad.isEmpty())
                        sb.append(-1).append('\n');
                    else sb.append(ad.getFirst()).append('\n');
                }
                case "back" -> {
                    if (ad.isEmpty())
                        sb.append(-1).append('\n');
                    else sb.append(ad.getLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
