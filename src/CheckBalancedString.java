import java.util.Scanner;
import java.util.Stack;

public class CheckBalancedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt(); // user input no of test cases
        while(noOfTestCases>0){
            String s = sc.next(); // user input string of rackets
            CheckBalancedString checkBalancedString = new CheckBalancedString();
            // calling the function to check string is balanced or not
            boolean isBalanced = checkBalancedString.checkIfStringIsBalanced(s);
            if(isBalanced)
                System.out.println("YES");
            else
                System.out.println("NO");
            noOfTestCases = noOfTestCases - 1;
        }

    }

    private boolean checkIfStringIsBalanced(String s) {
        Stack<Character> stack = new Stack<>(); // using stack to store the rackets

        /*
        traverse the whole string, one character at a time and then
        pushing the opening bracket to the stack and pop the stack if any closing bracket come
        then check the bracket at the top of the stack, if it is other then the current closing bracket pair,
        then string is not balanced, otherwise pop the opening bracket and do this until
        we reach at the end of the stirng.
         */
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // pushing the open brackets in the stack from the string one by one until closing bracket come
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
                continue;
            }

            // if a close bracket appear and there is no any open bracket in the stack
            if(stack.isEmpty())
                return false;

            // checking for different types of closing bracket
            switch (ch){
                case ')':
                    ch = stack.pop();
                    // if closing bracket is ) and the bracket at the top is not (
                    if(ch=='{' || ch=='[')
                        return false;
                    break;

                case '}':
                    ch = stack.pop();
                    // if closing bracket is } and the bracket at the top is not {
                    if(ch=='(' || ch=='[')
                        return false;
                    break;

                case ']':
                    ch = stack.pop();
                    // if closing bracket is ] and the bracket at the top is not [
                    if(ch=='(' || ch=='{')
                        return false;
                    break;
            }
        }
        // if reached at the end of the string
        return stack.isEmpty();
    }
}
