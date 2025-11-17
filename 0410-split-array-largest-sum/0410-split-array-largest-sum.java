class Solution {
    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE;
        int sum = 0;

        for(int i:nums){
            min = Math.max(i,min);
            sum+=i;
        }

        int lo = min;
        int hi = sum;

        while(lo<hi){
            int mid = lo+(hi-lo)/2;

            if(check(nums,mid,k))
                hi = mid;
            else
                lo = mid+1;
        }

        return lo;
    }

    public boolean check(int[] nums,int target,int k){
        int total = 0;
        int count = 1;
        for(int i:nums){
            total+=i;
            if(total>target){
                total = i;
                count++;
                if(count>k){
                    return false;
                }
            }
            
        }

        return true;
    }
}