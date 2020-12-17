import java.util.HashMap;
import java.util.Scanner;

public class highestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Character , Integer> h = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // if hashmap contains key already then update value with 1.
            if(h.containsKey(ch)){
                int oldFreq = h.get(ch);
                // now update and put.
                int newFreq = oldFreq + 1;
                h.put(ch, newFreq);
            }else{
                // put normally with freq=1:
                h.put(ch, 1);
            }
        }

        System.out.println(h);

        // let max frequency character be the first character in the string:
        char maxFreqChar = s.charAt(0);
        // now loop for keyset and check if any key's value is greater than the
        // maxFreqChar then update maxFreqChar:
        
        for(Character key : h.keySet()){
            if(h.get(key) > h.get(maxFreqChar)){
                maxFreqChar = key;
            }
        }
        // now maxFreqChar is storing the character with maximum frequency
        System.out.println("Max Freq Character in the String = " + maxFreqChar + "-" + h.get(maxFreqChar)); 
        sc.close();
    }
}
