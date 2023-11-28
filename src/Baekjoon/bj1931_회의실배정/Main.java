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
                if(!o1[0].equals(o2[0])){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        start = meetingTimes.get(0)[0];
        end = meetingTimes.get(0)[1];
        int indexOfminimum = 0;
        int duration = end - start;
        for(int i = 1 ; i < meetingTimes.size();i++){
           meeting = meetingTimes.get(i);
           if(start==meeting[0]){
               if(meeting[0] == meeting[1]){
                   end = meeting[1];
                   indexOfminimum = i;
                   continue;
               }
               if(start == end && meeting[1]>end){
                   end = meeting[1];
                   indexOfminimum = i;
                   continue;
               }
               meetingTimes.remove(i);
               i--;
               continue;
           }
           if(start < meeting[0]){
               if(meeting[0]>=end){
                   start = meeting[0];
                   end = meeting[1];
                   indexOfminimum = i;
                   continue;
               }else{
                   if(meeting[1] >=end ){
                       meetingTimes.remove(i);
                       i--;
                       continue;
                   }else{
                       start = meeting[0];
                       end = meeting[1];
                       meetingTimes.remove(indexOfminimum);
                       indexOfminimum = i-1;
                       i--;
                       continue;
                   }

               }


           }
        }

        bw.write(meetingTimes.size()+"\n");
        bw.flush();
        bw.close();
    }
}
