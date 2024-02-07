package Baekjoon.bj10816_숫자카드2;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> cardsNumber = new HashMap<>();
        int cardsCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int card;
        int cardinMap;
        for(int i =0 ; i < cardsCount;i++){
            card = Integer.parseInt(st.nextToken());
            if(cardsNumber.containsKey(card)){
                cardinMap = cardsNumber.get(card);
                cardinMap++;
                cardsNumber.replace(card,cardinMap);

            }else{
                cardsNumber.put(card,1);
            }
        }

        int checkCount = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int answer = 0;
        int cardToCheck;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < checkCount;i++){
            cardToCheck = Integer.parseInt(st.nextToken());
            if(cardsNumber.containsKey(cardToCheck)){
                bw.write(cardsNumber.get(cardToCheck)+" ");
            }else{
                bw.write(0+" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
