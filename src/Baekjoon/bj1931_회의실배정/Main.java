package Baekjoon.bj1931_회의실배정;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfMeeting = Integer.parseInt(st.nextToken());
        List<Integer[]> meetingTimes = new ArrayList<>();
        int start= 0;
        int end = 0;
        Integer[] meeting;
        for(int i = 0 ; i < numberOfMeeting;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            meeting = new Integer[]{start,end};
            meetingTimes.add(meeting);
        }

        meetingTimes.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(!o1[1].equals(o2[1])){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int count = 0;
        end = 0;
        for(int i = 0 ; i < meetingTimes.size();i++){
            if(meetingTimes.get(i)[0]>=end){
                end = meetingTimes.get(i)[1];
                count++;
            }
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}
