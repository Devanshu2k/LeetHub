class Solution {
    int count = 0;
    Map<String,Integer> map;

    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return helper(nums,target,0);
    }

    int helper(int[] nums,int target,int curr){
        if(curr==nums.length){
            return target==0?1:0;
        }
        String s = target+":"+curr;
        if(map.containsKey(s))
            return map.get(s);
        
        int add = helper(nums,target+nums[curr],curr+1);
        int sub = helper(nums,target-nums[curr],curr+1);
        map.put(s,add+sub);
        return add+sub;
    }
}