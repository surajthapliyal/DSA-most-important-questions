package recursion;

public class reverseString {
    public static void main(String[] args) {
        String str = "SURAJ";
        rev(str,str.length()-1);
    }
    static void rev(String str,int i){
        // if we get on the first position :
        if(i==0){
            System.out.print(str.charAt(i));
            return;
        }
        // print chat At i index:
        System.out.print(str.charAt(i));
        // call it again with low index:
        rev(str,i-1);
    }
}
