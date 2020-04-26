package jumpGame_055;


/*
       Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    Example 1:

    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    Example 2:

    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
 */
public class Solution {
    public boolean canJump(int[] nums){
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(max<i)   return false;   //通过max与当前位置index比较，max表示之前步骤能到达的最远，
                                        //若max<i则表示之前步骤最远走不到当前位置
            max = Math.max(nums[i]+i, max); //nums[i]+i表示从当前位置i能走到的最远位置
        }
        return max>=(nums.length-1);
    }



}
