class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen=0;
        int l=0;
        int r=0;
        int zero=0;
        for(r=0;r<nums.length;r++){
            if(nums[r]==0){
                zero++;
            }
            if(zero>k){
                if(nums[l]==0){
                    zero--;
                }
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}