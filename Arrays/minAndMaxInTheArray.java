//Max and Min element in the array : 

import java.util.Scanner;

public class minAndMaxInTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array = ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter elements to be entered in the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Entered array = ");
        printArray(arr, size);
        findMaxMin(arr, size);
        sc.close();
    }
    static void printArray(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
    static void findMaxMin(int arr[],int size){
        int max = arr[0];
        int min = arr[0];
        for(int each : arr){
            if(each >= max){
                max = each;
            }
            if(each <= min){
                min = each;
            }
        }
        System.out.print("\nMax in the array = "+max);
        System.out.print("\nMin in the array = " + min);
    }
}
