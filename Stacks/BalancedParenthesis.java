import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean isBalanced = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
                continue;
            }
            if(ch == ')'){
                if(stack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }else{
                    isBalanced = false;
                    break;
                }
            }
            if (ch == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
            if (ch == ']') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if(!stack.isEmpty()) isBalanced = false;
        if(isBalanced) System.out.println("Balanced");
        else System.out.println("Not Balanced");

        sc.close();
    }
}
