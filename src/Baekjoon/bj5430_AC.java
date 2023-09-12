package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class bj5430_AC {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb, tempsb;
    public static void main(String[] args) throws IOException {
        int count= Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i = 0 ; i < count;i++){
            sb.append(work()).append('\n');
        }

        System.out.println(sb);

    }

    public static String work() throws IOException {
        boolean forward = true;
        ArrayDeque<String> al = new ArrayDeque<>();
        char[] command = br.readLine().toCharArray();
        br.readLine();
        String numsinput = br.readLine();
        String[] nums = numsinput.substring(1,numsinput.length()-1).split(",");
        for(int i = 0 ; i < nums.length;i++){
            al.add(nums[i]);
        }
        char commandnow;
        for(int i = 0 ; i < command.length;i++){
            commandnow = command[i];
            switch(commandnow){
                case 'R':
                    forward = !forward;
                    break;

                case 'D':
                    if(al.isEmpty()||al.contains("")){
                        return "error";
                    }
                    if(forward){
                        al.removeFirst();
                    }else{
                        al.removeLast();
                    }
                    break;
            }
        }

        ArrayList<String> answer = new ArrayList<>(){
            @Override
            public String toString() {
                int size = this.size();
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                for(int i = 0 ; i < size;i++){
                    sb.append(this.get(i));
                    if(i!=size-1){
                        sb.append(',');
                    }

                }
                sb.append("]");
                return sb.toString();

            }
        };
        if(forward){
            while(!al.isEmpty()){
                answer.add(al.removeFirst());
            }
        }else{
            while(!al.isEmpty()){
                answer.add(al.removeLast());
            }
        }
        return answer.toString();

    }
}
