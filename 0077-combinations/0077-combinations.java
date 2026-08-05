class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),n,k,0);
        return ans;
    }

    void helper(List<List<Integer>> ans, List<Integer> li, int n, int k, int curr){
        if(li.size()==k){
            ans.add(new ArrayList(li));
            return;
        }

        for(int i=curr;i<n;i++){
            li.add(i+1);
            helper(ans,li,n,k,i+1);
            li.remove(li.size()-1);
        }
    }
}