class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0);
        return new ArrayList<>(res);
    }

    void helper(List<List<Integer>> res,List<Integer> li,int[] nums,int curr){
        if(curr==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[curr]);
        helper(res,li,nums,curr+1);

        li.remove(li.size()-1);

        while(curr<nums.length-1 && nums[curr]==nums[curr+1])
            curr++;
        
        helper(res,li,nums,curr+1);
    }
}