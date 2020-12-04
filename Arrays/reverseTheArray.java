//reverse the array:
import java.util.Scanner;

public class reverseTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array = ");
        int size =sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter elements to be entered in the array : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Entered array = ");
        printArray(arr,size);
        reversearray(arr,size);
        sc.close();
    }
    static void printArray(int arr[],int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + "  ");
        }
    }
    static void reversearray(int arr[],int size){
        int start = 0, end = size-1;
        while(start < end){
            int temp;
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.print("\nReversed array = ");
        printArray(arr, size);
    }
}
