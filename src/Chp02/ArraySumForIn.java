package Chp02;

public class ArraySumForIn {
    public static void start() {
        double[] a = {1.0, 3.0, 2.0, 5.0, 1.0};
        for(int i =0;i<a.length;i++){
            System.out.println("a["+i+"] = "+a[i]);
        }

        double sum = 0;
        for(double i:a)
            sum += i;

        System.out.println("모든 요소의 합은 "+sum+"입니다.");
    }
}
