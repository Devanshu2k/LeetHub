class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    void quickSort(int[] nums,int lo,int hi){
        if(lo<hi){
            int correctPivotIndex = partition(nums,lo,hi);

            quickSort(nums,lo,correctPivotIndex-1);
            quickSort(nums,correctPivotIndex+1,hi);
        }
    }

    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    int partition(int[] nums,int lo, int hi){
        int pivotIndex = lo + new Random().nextInt(hi - lo + 1);
        swap(nums, pivotIndex, hi);
        int pivot = nums[hi];
        int i = lo;
        for(int j=lo;j<hi;j++){
            if(nums[j]<pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,hi);
        return i;
    }
}