class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // it's an opening bracket, push it onto the stack
                stack.push(c);
            } else {
                // it's a closing bracket — check if stack is empty first
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // if stack is empty, every open bracket was matched
        return stack.isEmpty();
    }
}