class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        int left = -1;
        int right = -2;

        int max = nums[0];
        int i = 0;
        while(i!=n){
            if(nums[i]<max)
                right = i;
            if(nums[i]>max)
                max = nums[i];
            i++;
        }
        i=n-1;
        max = nums[i];
        while(i>=0){
            if(nums[i]>max)
                left = i;
            if(nums[i]<max)
                max = nums[i];
            i--;
        }

        return right-left+1;
    }
}
