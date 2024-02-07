package Programmers;

public class pm43105_정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangle));

    }

    public static int solution(int[][] triangle) {
        for(int i = 1 ; i < triangle.length;i++){
            for(int j = 0 ; j <= i;j++){
                System.out.println("i is " + i + ", j is "+ j);
                if(j==0){
                    triangle[i][j] += triangle[i-1][0];
                }else if(j==i){
                    triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j],triangle[i-1][j-1]);
                }
            }
            for(int k = 0 ; k < triangle.length;k++){
                for(int t = 0 ; t < triangle[k].length;t++){
                    System.out.print(triangle[k][t]+" ");
                }
                System.out.println();
            }
        }
        int answer = triangle[triangle.length-1][0];
        for(int num: triangle[triangle.length-1]){
            if(num> answer){
                answer = num;
            }
        }
        return answer;
    }
}
