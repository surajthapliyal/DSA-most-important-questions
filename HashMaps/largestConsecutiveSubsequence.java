import java.util.HashMap;

public class largestConsecutiveSubsequence {
    public static void main(String[] args) {
        int a[] = {1,10,5,9,11,8,6,15,3,12,2};
        HashMap<Integer,Boolean> h = new HashMap<>();
        
        // fill all values with true , which indicates that the 
        // key is the starting point of its subsequence :
        for(int key : a){
            h.put(key,true);
        }
        // now loop in the array and check whether the element's previous element
        // is present in the map as a key (or element -1) ? if it is then make it's value
        // as false , which indicates that- that element can't be the starting point
        // of its subsequence:
        for(int item : a){
            if(h.containsKey(item - 1)){
                h.put(item, false);
            }
        }
        // now all the element which can be the starting point of its
        // subsequence will have true as its value and rest as false.

        // now loop on array and check whether the element's value is true
        // in the map , if it is then print element+1 if it is in the map
        // and the its value is false.
        int maxLen = 0;
        for(int item : a){
            // if element is the start of sequence:
            if(h.get(item)){
                int len = 0;
                // while map contains element's one large key
                // then print it and increase sequence's length 
                while (h.containsKey(item + len)) {
                    System.out.print((item + len) + " ");
                    len++;
                }
                maxLen = Math.max(maxLen,len);
                System.out.println("Length = " + len);
                System.out.println();
            }
        }
        System.out.println("Max Length subsequence = " + maxLen);
    }
}
