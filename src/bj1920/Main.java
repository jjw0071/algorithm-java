package bj1920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num; // 숫자 개수

        StringBuilder sb = new StringBuilder();
        num = sc.nextInt();
        int[] box = new int[num];
        for(int i = 0 ; i<num; i++){
            box[i] = sc.nextInt();
        }
        Arrays.sort(box);
        num = sc.nextInt();
        for(int i = 0 ; i<num;i++){
            int comp = sc.nextInt();
            boolean check = false;
            int left = 0;
            int right = box.length-1;
            while(left<=right){
                int midIndex = (left+right)/2;
                int midValue = box[midIndex];
                if(comp<midValue){
                    right = midIndex-1;
                }else if(comp > midValue){
                    left = midIndex+1;
                }else{
                    check = true;
                    break;
                }
            }
            if(check){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);


    }
}
