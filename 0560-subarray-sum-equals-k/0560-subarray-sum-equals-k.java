class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int n = nums.length;

        int[] psa = new int[n];
        psa[0]= nums[0];
        for(int i=1;i<n;i++)
            psa[i] = psa[i-1] + nums[i];

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            int temp = psa[i]-k;
            if(map.containsKey(temp)){
                count+=map.get(temp);
            }
            map.put(psa[i],map.getOrDefault(psa[i],0)+1);
            
        }

        return count;
    }
}