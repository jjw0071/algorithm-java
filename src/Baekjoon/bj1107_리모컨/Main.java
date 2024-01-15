package Baekjoon.bj1107_리모컨;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static HashSet<Integer> brokenButtons = new HashSet<>();
    public static PriorityQueue<Integer> clickTimes = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        String tChannel = st.nextToken();
        int targetChannel = Integer.parseInt(tChannel);
        if(targetChannel == 100){
            bw.write(0 + "\n");
            bw.flush();
            bw.close();
            exit(0);
        }

        int bN = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        if(bN != 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i < bN;i++){
                brokenButtons.add(Integer.parseInt(st.nextToken()));
            }

        }


        clickTimes.add(diffFromStart(targetChannel));

        if(brokenButtons.size()==10){
            bw.write(clickTimes.poll() + "\n");
            bw.flush();
            bw.close();
            exit(0);
        }
        int[] targetChannelNums = new int[tChannel.length()];
        for(int i = 0 ; i < targetChannelNums.length;i++){
            targetChannelNums[i] = Character.getNumericValue(tChannel.charAt(i));
        }

        ArrayList<Integer> possibleDigit = new ArrayList<>();
        for(int i = 0 ; i < 10 ;i++){
            if(!brokenButtons.contains(i)){
                possibleDigit.add(i);
            }
        }

        int[] digits = new int[tChannel.length()];
        checkPossibleNums(possibleDigit, digits, 0, targetChannel);
        if(digits.length>1){
            digits = new int[tChannel.length()-1];
            checkPossibleNums(possibleDigit, digits, 0, targetChannel);
        }

        if(digits.length<9){
            digits = new int[tChannel.length()+1];
            checkPossibleNums(possibleDigit, digits, 0, targetChannel);
        }





        bw.write(clickTimes.poll()+"\n");
        bw.flush();
        bw.close();
    }

    private static void checkPossibleNums(ArrayList<Integer> possibleDigit, int[] digits, int location, int targetChannel) {
        if(location == digits.length){
            int channel = 0;
            int clicked = digits.length;
            for(int i = 0 ; i < digits.length;i++){
                channel += (int) (digits[i]*Math.pow(10, i));
            }
            int diff = Math.abs(channel-targetChannel);
            clickTimes.add(clicked+diff);
            return;
        }

        for(int digit : possibleDigit){
            digits[location] = digit;
            checkPossibleNums(possibleDigit,digits, location+1,targetChannel);
        }
    }

    private static Integer diffFromStart(int targetChannel) {
        if(targetChannel < 100){
            return 100 - targetChannel;
        }
        return targetChannel - 100;
    }


}
