class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele=n/3;

        HashMap<Integer,Integer> m = new HashMap<>();
        for(int num: nums){
            m.put(num,m.getOrDefault(num,0)+1);
        }
        List<Integer> ans= new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: m.entrySet()){
            int freq= entry.getValue();
            int a= entry.getKey();
            if(freq>ele){
                ans.add(a);
            }
        }
        return ans;
    }
}