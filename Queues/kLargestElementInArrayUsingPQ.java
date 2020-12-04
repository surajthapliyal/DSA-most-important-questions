import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargestElementInArrayUsingPQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<size;i++){
            if(i < k){
                pq.add(a[i]);
            }else{
                if(pq.peek() < a[i]){
                    pq.remove();
                    pq.add(a[i]);
                }
            }
        }
        // now to show the elements of PQ in descending order : 
        
        // passing pq in the constructor to convert it to arrayList :
        ArrayList<Integer> al = new ArrayList<>(pq);
        // Sorting in descending order : 
        Collections.sort(al , Collections.reverseOrder());
        //                      |
        //                      |--> it is a comparator.
        System.out.println(al);
        sc.close();
    }
}
