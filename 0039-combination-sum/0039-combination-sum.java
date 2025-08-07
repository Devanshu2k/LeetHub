class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        helper(result,new ArrayList<>(),0,0,target,candidates);
        return new ArrayList<>(result);
    }

    public void helper(Set<List<Integer>> result, List<Integer> temp,int sum,int pos,int target,int[] candidates ){
        if(pos==candidates.length){
            if(sum==target)
                result.add(new ArrayList<>(temp));
            return;
        }  

        if(sum>target)
            return;

        temp.add(candidates[pos]);

        helper(result,temp,sum+candidates[pos],pos,target,candidates);

        helper(result,temp,sum+candidates[pos],pos+1,target,candidates);

        temp.remove(temp.size()-1);

        helper(result,temp,sum,pos+1,target,candidates);
    }
}