class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int temp = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){

            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(target==sum)
                    return target;
                else if(sum>target)
                    k--;
                else
                    j++;
                
                if(Math.abs(sum-target)<Math.abs(temp-target))
                    temp = sum;
            }
        }

    return temp;
    }
} 