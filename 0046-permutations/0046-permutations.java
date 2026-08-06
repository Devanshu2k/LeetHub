class Solution {

    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        this.n = nums.length;
        boolean[] visited = new boolean[n];

        permutations(nums,visited,0,new ArrayList<>());

        return ans;
    }

    void permutations(int[]nums,boolean[]visited,int curr,List<Integer> li){
        if(li.size()==n){
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                li.add(nums[i]);
                permutations(nums,visited,curr+1,li);
                li.remove(li.size()-1);
                visited[i] = false;
            }
        }
    }
} 