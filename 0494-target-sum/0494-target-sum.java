class Solution {
    Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int idx, int remainingTarget) {
        if (idx == nums.length) {
            return remainingTarget == 0 ? 1 : 0;
        }

        String key = idx + "," + remainingTarget;
        if (memo.containsKey(key)) return memo.get(key);

        // Choose + sign → reduces remaining target by nums[idx]
        int plus = dfs(nums, idx + 1, remainingTarget - nums[idx]);
        // Choose - sign → increases remaining target by nums[idx]
        int minus = dfs(nums, idx + 1, remainingTarget + nums[idx]);

        int ways = plus + minus;
        memo.put(key, ways);
        return ways;
    }
}
