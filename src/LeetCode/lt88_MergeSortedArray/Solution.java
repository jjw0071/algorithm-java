package LeetCode.lt88_MergeSortedArray;

import java.util.PriorityQueue;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < m ; i++){
            queue.add(nums1[i]);
        }

        for(int i = 0 ; i < n ; i++){
            queue.add(nums2[i]);
        }

        for(int i = 0 ; i < m + n ; i++){
            nums1[i] = queue.poll();
        }
    }
}
