package recursion;

import java.util.HashSet;
import java.util.Set;

public class permutationsOfAString {

    static Set<String> hs = new HashSet<>();
    public static void main(String[] args) {
        String s = "abcc";
        permutations(s, 0 , s.length()-1);
    }
    static void permutations(String s , int l , int r){
        // if string is having only one char:
        if(l==r){
            if(hs.contains(s)) return;
            hs.add(s);
            System.out.println(s);
            return;
        }
        for(int i=l; i<=r; i++){
            // interchanging ith char with leftmost char :
            s = interchangeChars(s, l, i);
            // doing permutation on the string remaining next to left char :
            permutations(s, l+1, r);
            // backtracking in the string to get the unmodfied back :
            s = interchangeChars(s, l, i); 
        }
    }
    static String interchangeChars(String s , int a , int b){
        char strArr[] = s.toCharArray();
        char temp = strArr[a];
        strArr[a] = strArr[b];
        strArr[b] = temp;
        return String.valueOf(strArr);
    }
}
