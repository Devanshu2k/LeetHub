class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m-1;
        int row = -1;

        while(left<=right){
            int mid = (left+right)/2;

            if(matrix[mid][0]<=target && matrix[mid][n-1]>=target){
                row = mid;
                break;
            } else if(matrix[mid][0]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        if(row==-1)
            return false;

        int lo = 0;
        int hi = n-1;
        while(lo<=hi){
            int mid = (hi+lo)/2;

            if(matrix[row][mid]==target){
                return true;
            } else if(matrix[row][mid]>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return false;
    }

}