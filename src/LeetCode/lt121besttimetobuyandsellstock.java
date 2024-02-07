package LeetCode;

public class lt121besttimetobuyandsellstock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2}));

    }

    public static int maxProfit(int[] prices) {
        int profit=0;
        int min = prices[0];
        int temp;
        for(int i = 0 ; i < prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
                continue;
            }
            temp = prices[i]-min;
            if(profit<temp){
                profit = temp;
            }
        }
        return profit;
    }
}
