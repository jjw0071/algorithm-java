package Chp02;

public class PrimeNumber1 {
    public static void start() {
       //print all prime number in range of 1~1000
        int counter = 0; //number of primenumber

        for(int n=2 ;n<1000;n++){
            int i;
            for(i =2;i<n;i++){
                if(n%i == 0)
                    break;
            }
            if(n == i){
                System.out.println(n);
                counter ++;
            }
        }
        System.out.println("1000까지 소수의 수 : "+counter);
    }
}
