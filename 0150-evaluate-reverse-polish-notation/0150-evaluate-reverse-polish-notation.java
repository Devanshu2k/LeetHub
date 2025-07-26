class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s:tokens){
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }
            else if(s.equals("-")){
                int temp = stack.pop();
                stack.push(stack.pop()-temp);
            }
            else if(s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(s.equals("/")){
                int temp = stack.pop();
                stack.push(stack.pop()/temp);
            }
            else
            stack.push(Integer.parseInt(s));
        }

        return stack.pop();
    }
}