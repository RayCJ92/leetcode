// #20. Valid Parentheses
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

// Easy to solve with a stack 
public class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (stack.size() == 0 || stack.peek() == null) {
                stack.push(c);
            } else if ( c == '[' || c == '{' || c == '('){
                stack.push(c);
            } else if (c == ']'){
                if (stack.peek() == '[')
                    stack.pop();
                else return false;
            } else if (c == '}'){
                if (stack.peek() == '{')
                    stack.pop();
                else return false;    
            } else if (c == ')'){
                if (stack.peek() == '(')
                    stack.pop();
                else return false;    
            }
        }
        return stack.size() == 0? true:false;
    }
}

// a short way
public boolean isValid(String s) {
	Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}