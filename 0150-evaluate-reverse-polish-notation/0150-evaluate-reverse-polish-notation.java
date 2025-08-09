class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String ch : tokens){
            if(!ch.equals("+") && !ch.equals("-") && !ch.equals("*") && !ch.equals("/")){
                stack.push(Integer.parseInt(ch));
            }

            if(ch.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                int result = a + b;
                stack.push(result);
            }
            if(ch.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                int result = a - b;
                stack.push(result);
            }
            if(ch.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                int result = a * b;
                stack.push(result);
            }
            if(ch.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int result = a / b;
                stack.push(result);
            }
        }
        return stack.peek();
    }
}