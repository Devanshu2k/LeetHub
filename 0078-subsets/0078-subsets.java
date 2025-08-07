class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();

        subset(nums,res,new ArrayList<>(),0);
        return res;
    }

    void subset(int[] nums, List<List<Integer>> res,List<Integer> li,int i){
        if(i==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[i]);
        subset(nums,res,li,i+1);
        li.remove(Integer.valueOf(nums[i]));
        subset(nums,res,li,i+1);
    }
}