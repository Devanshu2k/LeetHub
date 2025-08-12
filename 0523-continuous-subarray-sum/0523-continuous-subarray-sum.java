class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;

        for(int i=0;i<n;i++){
            sum+=nums[i];

            int temp = sum%k;

            if(temp==0 && i>=1)
                return true;
            if(map.containsKey(temp)){ 
                if(i-map.get(temp)>=2)
                    return true;
            }
            else
            {
                map.put(temp,i);
            }
        }

        return false;
    }
}