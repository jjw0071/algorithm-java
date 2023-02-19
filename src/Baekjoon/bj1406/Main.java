package Baekjoon.bj1406;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        input = sc.next();
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> ll = new LinkedList<>();
        for(int i = 0; i<input.length();i++){
            ll.add(input.charAt(i));
        }
        ListIterator<Character> iter = ll.listIterator();
        while(iter.hasNext()){
            iter.next();
        }
        int num = sc.nextInt();
        for(int i = 0;i<num;i++){
            input = sc.next();
            switch (input) {
                case "L" :
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case "D" :
                    if (iter.hasNext()) {
                        iter.next();
                    }
                    break;
                case "B" :
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;

                case "P" :
                    iter.add(sc.next().charAt(0));
                    break;
            }
        }

        for (Character character : ll) {
            sb.append(character);
        }
        System.out.println(sb);

    }
}
