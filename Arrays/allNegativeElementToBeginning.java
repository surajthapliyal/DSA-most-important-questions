// all negative element to the beginning :
// sol : through partition process of quickSort

import java.util.Scanner;

public class allNegativeElementToBeginning {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        System.out.print("Enter size =");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter elements for array : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Entered array = ");
        printArray(arr);
        partition(arr);
        System.out.print("\nRearranged array = ");
        printArray(arr);
        sc.close();
    }
    static void printArray(int arr[]){
        for(int each : arr){
            System.out.print(each+"  ");
        }
    }
    static void partition(int arr[]){
        int pIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){     //if element is negative
                if(i != pIndex){    //if both element are not same
                    int temp = arr[pIndex];
                    arr[pIndex] = arr[i];
                    arr[i] = temp;
                }
                pIndex++;      
            }
        }
    }
}
