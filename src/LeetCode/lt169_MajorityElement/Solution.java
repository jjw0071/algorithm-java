package LeetCode.lt169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i : nums){
            if(m.get(i) == null){
                m.put(i,1);
            }else{
                m.replace(i,m.get(i)+1);
            }
        }
        int n = nums.length;
        for(Map.Entry<Integer,Integer> entry : m.entrySet()){
            Integer value = entry.getValue();
            if(value > n/2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
