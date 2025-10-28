package Baekjoon.bj7490_0만들기;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static BufferedWriter bw;
    public static boolean added;
    public static Queue<String> q;
    public static String[] cals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new ArrayDeque<>();
        added = false;
        cals = new String[]{" ", "+", "-"};

        int count = Integer.parseInt(st.nextToken());

        int input;
        boolean c = true;
        for(int i = 0 ; i < count ; i++){
            st = new StringTokenizer(br.readLine());
            input = Integer.parseInt(st.nextToken());
            ArrayList<String> x = new ArrayList<>();
            x.add("1");
            dfs(input, x, c, 2);
            if(added){
                bw.write("\n");
                added = false;
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int input, ArrayList<String> x, boolean c, int nextNum) throws IOException{
        if(nextNum == input+1){
            cal(x);
            return;
        }

        if(c){
            // 연산자 넣는 경우
            for(String s : cals){
                x.add(s);
                dfs(input, x, false, nextNum);
                x.remove(x.size()-1);
            }
        }else{
            // 숫자 넣는 경우
            x.add(String.valueOf(nextNum));
            dfs(input, x, true, nextNum+1);
            x.remove(x.size()-1);
        }
    }

    public static void cal(ArrayList<String> x) throws IOException{
        String t = "0";
        int size = x.size();
        String cur;
        int result = 0;
        String calculator;
        for(int i = 0 ; i < size ; i++){
            cur = x.get(i);
            if(cur.equals("+") || cur.equals("-")){
                if(q.isEmpty()){
                    result = Integer.parseInt(t);
                }else{
                    calculator = q.poll();
                    if(calculator.equals("+")){
                        result += Integer.parseInt(t);
                    }else{
                        result -= Integer.parseInt(t);
                    }
                }
                q.add(cur);
                t = "";
                continue;
            }

            if(cur.equals(" ")){
                continue;
            }

            t += cur;
            if(i == size-1){
                if(!q.isEmpty()){
                    calculator = q.poll();
                    if(calculator.equals("+")){
                        result += Integer.parseInt(t);
                    }else{
                        result -= Integer.parseInt(t);
                    }

                }else{
                    result += Integer.parseInt(t);
                }
                break;
            }
        }

        if(result == 0){
            for(String s : x){
                bw.append(s);
            }
            bw.append("\n");
            added = true;
        }
    }
}

