import java.util.Arrays;
import java.util.Scanner;

public class firstRepeatingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        // another array to keep track of index of a[i]:
        final int N = (int)1e6+2; //10^6+2 = 1000006
        int idx[] = new int[N];
        //filling index track array with -1
        Arrays.fill(idx, -1);
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            //if element is repeating :
            if(idx[a[i]] != -1){
                minIndex = Math.min(minIndex,idx[a[i]]);
            }
            //is element is not repeating :
                idx[a[i]] = i;
        }

        // if no repeating element found : 
        if(minIndex == Integer.MAX_VALUE){
            System.out.println("-1");
        }
        //if repeating element found with minIndex : 
        else {
            System.out.println(minIndex+1);     //for one based index 
        }
    }
}
