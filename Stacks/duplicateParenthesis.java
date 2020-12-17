import java.util.Scanner;
import java.util.Stack;

public class duplicateParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        isDuplicate(str);
        sc.close();
    }
    static void isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')'){
                if(s.peek() == '('){
                    System.out.println(true);
                    return;        
                }else{
                    while(s.peek() != '('){
                        s.pop();
                    }
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        System.out.println(false);
    }
}
