class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=0;i<n;i++)
            temp[i]=nums[i];
        Arrays.sort(temp);
        int l = 0;
        int r = n-1;
        while(l<r && temp[l]==nums[l])
            l++;
        while(l<r && temp[r]==nums[r])
            r--;
        if(r==l)
            return 0;
        return r-l+1;
                
    }
}
