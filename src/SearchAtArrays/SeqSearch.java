package SearchAtArrays;

import java.util.Scanner;

public class SeqSearch {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        for(int i = 0 ;i< num;i++){
            System.out.println("x["+i+"]: ");
            x[i] = sc.nextInt();
        }

        System.out.println("검색할 값 : ");
        int ky = sc.nextInt();

        int idx = seqSearch(x, num, ky);

        if(idx == -1){
            System.out.println("그런 요소가 없습니다.");
        }else{
            System.out.println("그 값은 x["+idx+"]에 있습니다.");
        }
    }

}
