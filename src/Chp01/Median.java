package Chp01;
import java.util.Scanner;

public class Median {
    public static void start(){
        int go;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("세 정수의 중앙값을 구합니다.\n3개의 정수를 입력하세요");
            System.out.println("a의 값");
            int a = sc.nextInt();
            System.out.println("b의 값");
            int b= sc.nextInt();
            System.out.println("c의값");
            int c = sc.nextInt();

            System.out.println("중앙값은 "+ med3(a,b,c)+"입니다.");
            System.out.println("한번 더 하시겠습니까?(계속하시려면 1을 누르세요)");
            go = sc.nextInt();
        }while(go == 1);
    }
    public static int med3(int a, int b, int c){
        if(a>=b){
            if(b>=c)
                return b;
            if(a>=c)
                return c;
            return a;
        }
        if(a>=c)
            return a;
        if(b>=c)
            return c;
        return b;
    }

}
