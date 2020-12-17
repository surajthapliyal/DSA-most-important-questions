import java.util.Scanner;
import java.util.Stack;

public class reverseStringUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> s = new Stack<>();
        String str = sc.nextLine();
        char arr[] = new char[str.length()];
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        for(int i=0;i<str.length();i++){
            arr[i] = s.pop();
        }
        String ans = new String(arr);
        System.out.println(ans);
        sc.close();
    }
}
