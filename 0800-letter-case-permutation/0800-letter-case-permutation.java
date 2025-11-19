class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> li = new ArrayList<>();
        helper(li,s.toCharArray(),0);
        return li;
    }

    void helper(List<String> li,char[] arr,int i){
        if(i>=arr.length){
            li.add(new String(arr));
            return;
        }

        if(Character.isLetter(arr[i])){
            arr[i] = Character.toUpperCase(arr[i]);
            helper(li,arr,i+1);
            arr[i] = Character.toLowerCase(arr[i]);
            helper(li,arr,i+1);
        } else{
             helper(li,arr,i+1);
        }
    }
}