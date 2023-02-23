package Baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj11286 {
    public static <command> void main (String[] args){
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 <0 ){
                    if(o2 <0){
                        if(o1>o2){
                            return -1;
                        }
                        if(o1<o2){
                            return 1;
                        }
                        return 0;
                    }
                    if(o2 >0){
                        if(-o1 <= o2)
                            return -1;
                        if(-o1 > o2)
                            return 1;
                    }
                }
                if(o1>0){
                    if(o2<0){
                        if(o1 < -o2)
                            return -1;
                        if(o1>=-o2)
                            return 1;
                    }
                    if(o2>0){
                        if(o1>o2){
                            return 1;
                        }
                        if(o1<o2){
                            return -1;
                        }
                        return 0;
                    }
                }
                return 0;
            }
        });
        int num = sc.nextInt();
        int command;
        for(int i = 0 ; i< num;i++){
            command = sc.nextInt();
            switch(command){
                case 0:
                    if(pq.isEmpty()){
                        sb.append(0).append('\n');
                    }else{
                        sb.append(pq.poll()).append('\n');
                    }
                    break;

                default:
                    pq.add(command);
                    break;
            }
        }
        System.out.println(sb);

    }
}
