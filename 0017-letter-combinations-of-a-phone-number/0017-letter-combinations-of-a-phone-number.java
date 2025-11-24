class Solution {
     Map<Character, String> map;
     List<String> res;

    void init(){
        res = new ArrayList<>();
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        init();
        helper(digits,0,new StringBuilder());
        return res;
    }

    void helper(String digits,int curr,StringBuilder sb){
        if(digits.length()==curr){
            res.add(new String(sb));
            return;
        }

        String s = map.get(digits.charAt(curr));
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            helper(digits,curr+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}