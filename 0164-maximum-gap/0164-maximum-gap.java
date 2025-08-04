class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2)
            return 0;
        
        int maxGap = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        if (max==min)
            return 0;
        
        int bucketSize = (int)Math.ceil((double)(max-min)/(n-1));

        int[] maxBucket = new int[n-1];
        int[] minBucket = new int[n-1];

        Arrays.fill(maxBucket,Integer.MIN_VALUE);
        Arrays.fill(minBucket,Integer.MAX_VALUE);

        for(int num:nums){
            if(num==min || num==max)
                continue;
            
            int bucketIndex = (num-min)/bucketSize;
        
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex],num);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex],num);
        }

        for(int i=0;i<n-1;i++){
            if(maxBucket[i]==Integer.MIN_VALUE)
                continue;

            maxGap = Math.max(maxGap,minBucket[i]-min);
            min = maxBucket[i];
        }

        maxGap = Math.max(maxGap,max-min);

        return maxGap;
    }
}