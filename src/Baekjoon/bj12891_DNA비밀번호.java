package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj12891_DNA비밀번호 {

    static int[] passwordtemplate = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int totalLength = Integer.parseInt(st.nextToken());
        int passwordLength = Integer.parseInt(st.nextToken());

        char[] totalString = br.readLine().toCharArray();
        int startindex = 0;
        int lastindex = passwordLength-1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< 4;i++){
            passwordtemplate[i] = Integer.parseInt(st.nextToken());
        }
        int[] passwordcheck = new int[4];
        int answer = 0;
        char tempchar;
        for(int i = 0 ; i < passwordLength;i++){
            tempchar = totalString[i];
            switch(tempchar){
                case 'A':
                    passwordcheck[0]++;
                    break;

                case 'C':
                    passwordcheck[1]++;
                    break;

                case 'G':
                    passwordcheck[2]++;
                    break;

                case 'T':
                    passwordcheck[3]++;
                    break;
            }
        }
        if(checkpassword(passwordcheck)){
            answer++;
        }
        lastindex++;
        char todelete;
        char toadd;
        for(int i = lastindex ; i<totalLength;i++){
            todelete = totalString[startindex];
            startindex++;
            switch(todelete){
                case 'A':
                    passwordcheck[0]--;
                    break;
                case 'C':
                    passwordcheck[1]--;
                    break;
                case 'G':
                    passwordcheck[2]--;
                    break;
                case 'T':
                    passwordcheck[3]--;
                    break;
            }

            toadd = totalString[i];
            switch(toadd){
                case 'A':
                    passwordcheck[0]++;
                    break;

                case 'C':
                    passwordcheck[1]++;
                    break;

                case 'G':
                    passwordcheck[2]++;
                    break;

                case 'T':
                    passwordcheck[3]++;
                    break;
            }

            if(checkpassword(passwordcheck)){
                answer++;
            }

        }

        bw.write(answer+"\n");
        bw.flush();
        bw.close();

    }

    public static boolean checkpassword(int[] passwordcheck){
        for(int i = 0 ; i < 4; i++){
            if(passwordcheck[i] < passwordtemplate[i]){
                return false;
            }
        }
        return true;
    }
}
