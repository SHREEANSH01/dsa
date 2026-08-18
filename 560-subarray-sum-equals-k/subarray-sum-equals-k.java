class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum store in a map

        // int [] prefix=new int[nums.length];
        // prefix[0]=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     prefix[i]=prefix[i-1]+nums[i];
        // }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        int cnt=0;
        for(int num:nums){
            sum+=num;
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        // for(int i=0;i<nums.length;i++){
        //     if(prefix[i]==k){
        //         cnt++;
        //     }
        //     for(int j=0;j<i;j++){
        //         if(prefix[i]-prefix[j]==k){
        //             cnt++;
        //         }
        //     }
        // }
        return cnt;
    }
}