class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(0,0,sb,ans, n);
        return ans;
    }

    void helper(int op, int clo, StringBuilder sb, List<String> ans, int n){

        if(op>n || clo>n)
            return;

        if(op==n && clo==n){
            ans.add(new String(sb.toString()));
            return;
        }

        sb.append("(");
        helper(op+1,clo,sb,ans,n);
        sb.setLength(sb.length() - 1);

        if(op>clo){
            sb.append(")");
            helper(op,clo+1,sb,ans,n);
            sb.setLength(sb.length() - 1);
        }
        
    }
}