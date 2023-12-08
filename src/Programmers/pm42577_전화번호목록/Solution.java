package Programmers.pm42577_전화번호목록;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] phone_book = new String[] {
                "1", "23", "234"
        };

        System.out.println(solution(phone_book));


    }

    public static boolean solution(String[] phone_book) {
        HashSet<String> check = new HashSet<>();
        Arrays.sort(phone_book, (String s1 ,String s2) -> s1.length()-s2.length());
        int minimumLength = phone_book[0].length();
        int maximumLength = minimumLength;
        for(String number : phone_book){
            if(check.isEmpty()){
                check.add(number);
            }else{
                for(int length = maximumLength; length <= number.length();length++){
                    String partToCheck = number.substring(0,length);
                    if(check.contains(partToCheck)){
                        return false;
                    }
                }
                check.add(number);
            }
        }
        return true;
    }
}
