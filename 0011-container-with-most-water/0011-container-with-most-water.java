class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int temp = (j-i)*Math.min(height[i],height[j]);
            max = Math.max(temp,max);

            if(height[i]>height[j]){
                j--;
            }
            else
            {
                i++;
            }
        }

        return max;
    }
}