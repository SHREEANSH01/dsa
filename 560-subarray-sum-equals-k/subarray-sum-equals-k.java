class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum store in a map

        int [] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(prefix[i]==k){
                cnt++;
            }
            for(int j=0;j<i;j++){
                if(prefix[i]-prefix[j]==k){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}