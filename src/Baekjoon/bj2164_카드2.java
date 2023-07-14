package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class bj2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i =1 ; i<num+1; i++){
            ad.add(i);
        }
        while(ad.size()>1){
            ad.removeFirst();
            ad.add(ad.removeFirst());
        }

        System.out.println(ad.remove());

    }
}
