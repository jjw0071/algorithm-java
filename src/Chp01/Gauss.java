package Chp01;
import java.util.Scanner;

//가우스 덧셈을 구현한 클래스
public class Gauss {
    public static void start() {
        int go;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1부터 n까지의 합을 가우스 덧셈으로 구합니다.\nn값을 입력하세요.");
            int n;
            do{
                System.out.println("n 값");
                n = sc.nextInt();
            }while(n<1);
            gausssum(n);
            System.out.println("한번 더 하시겠습니까?(계속하시려면 1을 누르세요)");
            go = sc.nextInt();
        }while(go == 1);
    }

    public static void gausssum(int n){
        int sum;
        if(n%2 == 0){
            sum = (1+n)*(n/2);
        }else{
            sum = (1+n)*(n/2)+((1+n)/2);
        }
        System.out.println("합은 "+sum+" 입니다.");
    }
}
