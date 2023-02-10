package pm70128;

public class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 1234567890;
        for(int i = 0;i<a.length;i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}
