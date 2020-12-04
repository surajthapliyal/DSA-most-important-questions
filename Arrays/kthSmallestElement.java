// kth smallest element : 
import java.util.Arrays;
import java.util.Scanner;

public class kthSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int i=0;i<tests;i++){
            int size = sc.nextInt();
            int arr[] = new int[size];
            for(int j=0;j<size;j++){
                arr[j] = sc.nextInt();
            }
            System.out.println("Array entered : ");
            for(int each : arr){
                System.out.print(each + " ");
            }
            int k = sc.nextInt();
            int min = findSmallest(arr,k);
            System.out.println("\n" + k + " smallest element in the array = " + min);
            sc.close();
        }
    }
    static int findSmallest(int arr[],int k){
        Arrays.sort(arr);
        return arr[k-1];
    }
}
