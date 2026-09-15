class Solution {
    public void fcomb(int idx,int target,List<List<Integer>> ans,int n,List<Integer> ds,int [] candidates){
        if(idx==n){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[idx]<=target){
            ds.add(candidates[idx]);
            fcomb(idx,target-candidates[idx],ans,n,ds,candidates);
            ds.remove(ds.size()-1);
        }
        fcomb(idx+1,target,ans,n,ds,candidates);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n=candidates.length;
        fcomb(0,target,ans,n,new ArrayList<>(),candidates);
        return ans;
    }
}