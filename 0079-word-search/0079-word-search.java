class Solution {
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(board,word,i,j,0))
                    return true;
            }
        }
        return false;

    }

    boolean helper(char[][] board,String word,int i, int j,int k){
         if(k==word.length()){
            return true;
        }
		if(i>=board.length || j>=board[0].length || i<0 || j<0)
			return false;

       
        char temp;
        if (board[i][j] == word.charAt(k)) {
            temp = board[i][j];
            board[i][j] = '#';
            k++;
        } else {
            return false;
        }


        boolean result = helper(board,word,i+1,j,k) || helper(board,word,i-1,j,k) || helper(board,word,i,j+1,k) || helper(board,word,i,j-1,k);
    

        board[i][j]=temp;
        
        return result;

}
}