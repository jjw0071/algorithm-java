package SearchAtArrays;

import java.util.Scanner;

public class SeqSearch {
    public static void start() {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num+1];

        for(int i = 0 ;i< num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = sc.nextInt();

        int idx = seqSearchSen(x, num, ky);

        if(idx == -1){
            System.out.print("그런 요소가 없습니다.");
        }else{
            System.out.print("그 값은 x["+idx+"]에 있습니다.");
        }
    }

    static int seqSearch(int[] x, int num, int key){
        int i = 0;
        while(true){
            if(i==num)
                return -1;
            if(x[i] == key)
                return i;
            i++;
        }
    }

    static int seqSearchSen(int[] x, int num, int key){
        int i = 0;
        x[num] = key;
        while(true){
            if(x[i] == key){
                break;
            }
            i++;
        }
        if(i == num)
            return -1;
        else
            return i;
    }

}
