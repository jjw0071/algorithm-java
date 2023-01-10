package Chp02;

import java.util.Scanner;

public class CardConv {
    public static void start() {
        int go; // retry?
        int number; // number to change
        int cd; // 기수
        int dno; // number after change
        char [] cno = new char[32];
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("10진수를 기수 변환합니다.");
            do {
                System.out.print("10진수 : ");
                number = sc.nextInt();
            } while (number < 0);

            do {
                System.out.print("어떤 진수로 변환할까요(2~36)? : ");
                cd = sc.nextInt();
            } while (cd < 2 || cd>36);

            dno = cardConv(number, cd, cno);

            System.out.print(cd +"진수로 ");
            for (int i = 0; i < dno; i++) {
                System.out.print(cno[i]);
            }
            System.out.println("입니다.");
            System.out.println("한번 더 하시겠습니까?(계속하시려면 1을 누르세요)");
            go = sc.nextInt();
        } while (go == 1);
    }

    public static int cardConv(int number, int cd, char[] cno){
        int digits = 0; // 변환 후 자릿수
        String dchar ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do{
            cno[digits++]=dchar.charAt(number%cd);
            number /= cd;
        }while(number != 0);

        for(int i =0;i<digits/2;i++){
            char t = cno[i];
            cno[i] = cno[digits-i-1];
            cno[digits-i-1] = t;
        }
        return digits;
    }
}
