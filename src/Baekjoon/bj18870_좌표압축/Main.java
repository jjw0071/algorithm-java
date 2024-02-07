package Baekjoon.bj18870_좌표압축;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        int currentnum = 0;
        Set<Integer> sortedNumbers = new HashSet<>(numbers);
        for(int i = 0 ; i < number ; i++){
            currentnum = Integer.parseInt(st.nextToken());
            numbers.add(currentnum);
            sortedNumbers.add(currentnum);
        }

        List<Integer> sortedNumbersInList = new ArrayList<>(sortedNumbers);
        sortedNumbersInList.sort(Comparator.naturalOrder());
        Map<Integer, Integer> numbersWithIndex = new HashMap<>();
        for(int i = 0 ;i  < sortedNumbersInList.size();i++){
            numbersWithIndex.put(sortedNumbersInList.get(i),i);
        }

        for(int i = 0 ; i < numbers.size();i++){
            bw.write(numbersWithIndex.get(
                    numbers.get(i)
            )+" ");
        }
        bw.flush();
        bw.close();
    }
}
