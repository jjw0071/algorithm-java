package Chp02;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void start(){
        int go, num;
        Scanner sc = new Scanner(System.in);
        do{
            do{
                System.out.println("배열의 요소수를 입력해 주세요.");
                System.out.print("요소수 : ");
                num = sc.nextInt();
            }while(num<=0);

            int[] a = new int[num];

            for(int i = 0 ; i<num;i++){
                System.out.print("a["+i+"] :");
                a[i] = sc.nextInt();
            }
            reverse(a);

            System.out.println("a = "+ Arrays.toString(a));
            System.out.println("한번 더 하시겠습니까?(계속하시려면 1을 누르세요)");
            go = sc.nextInt();
        }while(go == 1);
    }

    public static void reverse(int[] a){
        int temp;
        for(int i=0;i<a.length/2;i++){
            temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
        System.out.println("배열이 역순으로 재배열 되었습니다.");
    }
}
