class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li  = new ArrayList<>();

        int n = nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==i+1)
                continue;

            else{
                int j = nums[i];
                while(nums[j-1]!=j){
                    int temp = nums[j-1];
                    nums[j-1] = j;
                    j = temp;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                li.add(i+1);
        }

        return li;


    }
}