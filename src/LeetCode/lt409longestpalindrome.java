package LeetCode;

import java.util.Enumeration;
import java.util.Hashtable;

public class lt409longestpalindrome {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<>();
        int temp;
        char tempchar;
        char[] check = s.toCharArray();
        for(int i = 0 ; i < check.length; i++){
            tempchar = check[i];
            if(ht.containsKey(tempchar)){
                temp = ht.get(tempchar);
                temp++;
                ht.replace(tempchar,temp);
            }else{
                ht.put(tempchar,1);
            }
        }
        Enumeration<Integer> e = ht.elements();
        int answer = 0;
        boolean odd = false;
        while(e.hasMoreElements()){
            temp = e.nextElement();
            if(temp%2 == 1){
                odd = true;
            }
            answer += temp/2*2;
        }
        if(odd){
            return answer +1;
        }
        return answer;
    }
}
