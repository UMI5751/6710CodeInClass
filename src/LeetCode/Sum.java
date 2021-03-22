package LeetCode;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length - 1; j++){
                if (nums[i] + nums[j + 1] == target){
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }
}