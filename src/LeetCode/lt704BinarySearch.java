package LeetCode;

public class lt704BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        while(start<=end){
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                end = mid-1;
                mid = (start+end)/2;
            }else{
                start = mid+1;
                mid = (start+end)/2;
            }
        }
        return -1;
    }
}
