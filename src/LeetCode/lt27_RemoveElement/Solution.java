package LeetCode.lt27_RemoveElement;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int endIndex = nums.length-1;
        int startIndex = 0;
        int answer = 0;
        while(startIndex<=endIndex){
            if(nums[startIndex] == val){
                nums[startIndex] = nums[endIndex];
                endIndex--;
                answer++;
                continue;
            }
            startIndex++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]
                {0,1,2,2,3,0,4,2};
        int val = 2;
        int answer = removeElement(nums,val);
    }
}
