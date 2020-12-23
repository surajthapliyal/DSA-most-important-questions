package recursion;

import java.util.Scanner;

public class replacePIinString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        replacePI(s);
        sc.close();
    }
    static void replacePI(String s){
        // if length is 0 then return:
        if(s.length()==0) {
            return;
        }
        // if 0th char is P and 1st char is i then print 3.14 and do recursion on rest string
        // which is substring of the original string with start index 2 because we have checked
        // first two chars already :
        if(s.charAt(0)=='p' && s.charAt(1)=='i'){
            System.out.print("3.14");
            replacePI(s.substring(2));
        }
        // else if first char is not p or both the chars is not p and i respectively so print 
        // print first char and do recursion on rest string that is substring with start index 1:
        else{
        System.out.print(s.charAt(0)); 
        replacePI(s.substring(1));
        }
    }
}
