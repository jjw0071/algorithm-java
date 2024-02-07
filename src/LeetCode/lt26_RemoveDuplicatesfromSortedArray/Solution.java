package LeetCode.lt26_RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        boolean[] checked = new boolean[201];
        int answer = 0;
        for(int num : nums){
            if(!checked[num+100]){
                nums[answer] = num;
                answer++;
                checked[num+100] = true;
            }
        }
        return answer;
    }
}
