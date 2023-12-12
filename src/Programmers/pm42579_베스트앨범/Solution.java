package Programmers.pm42579_베스트앨범;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] genres = new String[] {
                "classic", "pop", "classic", "classic", "pop"
        };

        int[] plays = new int[] {
                500, 600, 150, 800, 2500
        };

        solution(genres, plays);


    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalPlayed = new HashMap<>();
        HashMap<String, PriorityQueue<Map.Entry<Integer, Integer>>> mapForGenre = new HashMap<>();
        for(int i = 0 ; i < genres.length; i++){
            if(totalPlayed.containsKey(genres[i])){
                int played = totalPlayed.get(genres[i]);
                played += plays[i];
                totalPlayed.replace(genres[i],played);
                PriorityQueue<Map.Entry<Integer, Integer>> queue = mapForGenre.get(genres[i]);
                queue.add(new AbstractMap.SimpleEntry<>(plays[i],i));
                mapForGenre.replace(genres[i],queue);


            }else{
                totalPlayed.put(genres[i],plays[i]);
                PriorityQueue<Map.Entry<Integer,Integer>> queue = createPriorityQueue();
                queue.add(new AbstractMap.SimpleEntry<>(plays[i],i));
                mapForGenre.put(genres[i], queue);
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> sortedTotalPlayed = sortTotalPlayed(totalPlayed);
        ArrayList<Integer> answerList = new ArrayList<>();
        while(!sortedTotalPlayed.isEmpty()){
            String genre = sortedTotalPlayed.poll().getKey();
            PriorityQueue<Map.Entry<Integer, Integer>> queue = mapForGenre.get(genre);
            answerList.add(queue.poll().getValue());
            if(queue.isEmpty()){
                continue;
            }
            answerList.add(queue.poll().getValue());
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0 ; i < answer.length;i++){
            answer[i] = answerList.get(i);
        }
        return answer;

    }

    private static PriorityQueue<Map.Entry<String,Integer>> sortTotalPlayed(HashMap<String, Integer> totalPlayed){
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        queue.addAll(totalPlayed.entrySet());

        return queue;

    }

    private static PriorityQueue<Map.Entry<Integer,Integer>> createPriorityQueue(){
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (entry1, entry2) -> {
                    // 첫 번째 key에 대해 내림차순 정렬
                    int keyCompare = entry2.getKey().compareTo(entry1.getKey());
                    if (keyCompare != 0) {
                        return keyCompare;
                    }
                    // key가 같을 경우, value에 대해 오름차순 정렬
                    return entry1.getValue().compareTo(entry2.getValue());
                }
        );
        return queue;
    }
}
