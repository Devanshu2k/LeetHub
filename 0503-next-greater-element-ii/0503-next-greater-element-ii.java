class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                ans[st.pop()] = nums[i];
            }         
            st.push(i);
        }
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                ans[st.pop()] = nums[i];
            }    
        }
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MIN_VALUE)
                ans[i] = -1;
        }

        return ans;
        
    }
}