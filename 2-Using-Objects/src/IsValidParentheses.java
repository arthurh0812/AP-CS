import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;

public class IsValidParentheses {
    private final Stack<Character> stack = new Stack<Character>();

    private final ArrayList<Character> opening = new ArrayList<Character>(Arrays.asList('{', '(', '['));
    private final ArrayList<Character> closing = new ArrayList<Character>(Arrays.asList('}', ')', ']'));

    public boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (opening.contains(curr)) { // an opening parentheses ('(', '{' or '[')
                stack.push(curr);
            } else if (closing.contains(curr)) { // a closing parentheses (')', '}' or ']')
                if (stack.isEmpty() || curr != closing.get(opening.indexOf(stack.pop()))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
