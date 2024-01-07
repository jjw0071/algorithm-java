package Programmers.pm43163_단어변환;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public int solution(String begin, String target, String[] words) {
        // 포함되어 있지 않으면 0 return;
        boolean contain = false;
        LinkedList<String> wordsList = new LinkedList<>();
        for(String word:words){
            if(target.equals(word)){
                contain = true;
            }
            wordsList.add(word);
        }
        if(!contain){
            return 0;
        }

        Stack<StringNumberPair> stack = new Stack<>();
        for(String word:words){
            if(comp(begin, word)==1){
                if(comp(word,target)==1){
                    return 2;
                }
                stack.push(new StringNumberPair(word,1));
                wordsList.remove(word);
            }
        }

        HashSet<String> checked = new HashSet<>();
        int answer = 51;
        while(!stack.isEmpty()){
            StringNumberPair toCheck = stack.pop();
            if(toCheck.word.equals(target)){
                answer = Math.min(answer, toCheck.depth);
            }
            if(checked.contains(toCheck.word)){
                continue;
            }
            checked.add(toCheck.word);
            for(String word: wordsList){
                if(comp(toCheck.word,word)==1){
                    stack.push(new StringNumberPair(word,toCheck.depth+1));
                }
            }
        }
        return answer;
    }

    private int comp(String a, String b){
        int diff = 0;
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();
        for(int i = 0 ; i < achar.length; i++){
            if(achar[i] != bchar[i]){
                diff++;
            }
        }
        return diff;
    }

    public class StringNumberPair{
        private String word;
        private int depth;

        public StringNumberPair(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
}
