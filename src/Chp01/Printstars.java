package Chp01;
import java.util.Scanner;

public class Printstars {
    public static void start(){
        //n개의 별을 w개마다 줄을 바꿔서 출력
        int go;
        int n, w;
        Scanner sc = new Scanner(System.in);
        System.out.println("n개의 별을 w개마다 줄을 바꿔서 출력합니다.\n n, w값을 입력해 주세요.");
        do{
            do{
                System.out.print("n의 값 : ");
                n = sc.nextInt();
            }while(n<=0);

            do{
                System.out.print("w의 값 : ");
                w = sc.nextInt();
            }while(w<=0 || w>n);
            System.out.println("1번 함수, 2번 함수를 골라주세요");
            int funcnum = sc.nextInt();
            if(funcnum == 1)
                printstars1(n,w);
            else
                printstars2(n,w);
            System.out.println("한번 더 하시겠습니까?(계속하시려면 1을 누르세요)");
            go = sc.nextInt();
        }while(go ==1 );


    }

    public static void printstars1(int n, int w){
        for(int i=0;i<n;i++){
            System.out.print("*");
            if(i%w ==w-1)
                System.out.println();
        }
        if(n %w != 0)
            System.out.println();
    }

    public static void printstars2(int n, int w){
        for(int i = 0; i<n/w;i++){
            System.out.println("*".repeat(w));
        }
        int rest = n%w;
        if(rest != 0)
            System.out.println("*".repeat(rest));
    }
}
