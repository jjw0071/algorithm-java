package Programmers.pm43162_네트워크;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution(int n, int[][] computers) {
        int computerCount = computers.length;
        boolean[] visited = new boolean[computerCount];
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        LinkedList<Integer> pc;
        for(int i = 0 ;i < computerCount;i++){
            graph.add(new LinkedList<Integer>());
            pc = graph.get(i);
            for(int j = 0 ; j < computerCount;j++){
                if(computers[i][j]==1){
                    pc.add(j);
                }
            }
        }
        int answer = 0;
        Queue<Integer> toVisit = new ArrayDeque<>();

        for(int computer = 0 ; computer < computerCount; computer++){
            if(!visited[computer]){
                answer++;
                visited[computer] = true;
                pc = graph.get(computer);
                toVisit.addAll(pc);
                while(!toVisit.isEmpty()){
                    int connectedTo = toVisit.poll();
                    if(!visited[connectedTo]){
                        visited[connectedTo] = true;
                        pc = graph.get(connectedTo);
                        toVisit.addAll(pc);
                    }
                }
            }
        }
        return answer;
    }
}
