package containsDuplicateII_219;

import java.util.HashMap;

/**
* @description 
* @createDate ：2020年3月31日
*/
class Solution {
	/*
	 * 题目没有对空间复杂度做要求，可用hashmap存储已访问过的元素，num作key，index做value
	 */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(map.containsKey(num)&&i-map.get(num)<=k)
                return true;
            map.put(num, i);
        }
        return false;
    }
}
