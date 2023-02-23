package Baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class bj11286 {
    public static <command> void main (String[] args){
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<int[]> tempstack = new Stack<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int num = sc.nextInt();
        int command;
        int size;
        int[] temp;
        for(int i = 0 ; i< num;i++){
            boolean contains = false;
            size = pq.size();
            command = sc.nextInt();
            switch(command){
                case 0:
                    if(pq.isEmpty()){
                        sb.append(0).append('\n');
                    }else{
                        temp = pq.poll();
                        if(temp[1]==0){
                            sb.append(temp[0]).append('\n');
                            temp[2]--;
                        }else{
                            sb.append(-temp[0]).append('\n');
                            temp[1]--;
                            temp[2]--;

                        }
                        if(temp[2]>0)
                            pq.add(temp);
                    }
                    break;

                default:
                    if(command>0){
                        for(int j = 0 ; j< size;j++){
                            temp = pq.poll();
                            if(temp[0] == command){
                                temp[2]++;
                                pq.add(temp);
                                contains = true;
                                break;
                            }
                            tempstack.add(temp);
                        }
                        if(!tempstack.isEmpty()){
                            size = tempstack.size();
                            for(int j = 0 ; j< size;j++){
                                pq.add(tempstack.pop());
                            }
                        }
                        if(!contains){
                            pq.add(new int[]{command,0,1});
                        }

                    }else{
                        for(int j = 0 ; j< size;j++){
                            temp = pq.poll();
                            if(temp[0] == -command){
                                temp[2]++;
                                temp[1]++;
                                pq.add(temp);
                                contains = true;
                                break;
                            }
                            tempstack.add(temp);
                        }
                        if(!tempstack.isEmpty()){
                            size = tempstack.size();
                            for(int j = 0 ; j< size;j++){
                                pq.add(tempstack.pop());
                            }
                        }
                        if(!contains){
                            pq.add(new int[]{-command,1,1});
                        }
                    }
                    break;

            }
        }
        System.out.println(sb);

    }
}
