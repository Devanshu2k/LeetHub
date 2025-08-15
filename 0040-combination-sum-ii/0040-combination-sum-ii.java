class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = target;
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), candidates,0);
        return res;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums,int sum) {
        if (i == nums.length) {
            if(sum==ans){
                res.add(new ArrayList<>(subset));
            }
            return;
        }

        if(sum>ans)
            return;
        if(sum==ans){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i + 1, subset, nums,sum+nums[i]);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(i + 1, subset, nums,sum);
    }
}