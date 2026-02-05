class Solution {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int zero = 0;
        int one = 0;
        int two = n-1;

        while(one<=two){
            if(nums[one]==0){
                swap(nums,zero,one);
                zero++;
                one++;
            }
            else if(nums[one]==1){
                one++;
            }
            else{
                swap(nums,one,two);
                two--;
            }
        }
    }

    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}