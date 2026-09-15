class Solution {
    // public void fcomb(int idx, int target, Set<List<Integer>> ans,
    //                   int n, List<Integer> ds, int[] candidates) {

    //     if (idx == n) {
    //         if (target == 0) {
    //             ans.add(new ArrayList<>(ds));
    //         }
    //         return;
    //     }

    //     // Pick
    //     if (candidates[idx] <= target) {
    //         ds.add(candidates[idx]);

    //         // idx + 1 because each element can be used only once
    //         fcomb(idx + 1, target - candidates[idx],
    //               ans, n, ds, candidates);

    //         ds.remove(ds.size() - 1);
    //     }

    //     // Not pick
    //     fcomb(idx + 1, target, ans, n, ds, candidates);
    // }

    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     Set<List<Integer>> set = new HashSet<>();

    //     fcomb(0, target, set, candidates.length,
    //           new ArrayList<>(), candidates);

    //     return new ArrayList<>(set);
    // }
     public void fcomb(int idx, int target, List<List<Integer>> ans,
                      List<Integer> ds, int[] candidates) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            // Skip duplicate choices at the same level
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (candidates[i] > target) {
                break;
            }

            ds.add(candidates[i]);

            // i + 1 because each element can be used only once
            fcomb(i + 1, target - candidates[i], ans, ds, candidates);

            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        fcomb(0, target, ans, new ArrayList<>(), candidates);

        return ans;
    }
    
}