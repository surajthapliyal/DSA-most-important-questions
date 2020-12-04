// sort array of 0's 1's and 2's without using any sorting algorithm

//sol:
//by Dutch national flag algorithm(using three pointers):
// (a[0 to low-1] = 0)
// (a[high+1 to n] = 2)
// (a[low] to a[high] = 1)
import java.util.*;

public class sortArrayOf012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }
            sortArr(arr, size);
            System.out.println();
        }
        sc.close();
    }

    static void sortArr(int a[], int size) {
        int l = 0, m = 0, h = size - 1,temp;
        while (m < h) {
            if (a[m] == 0) {
                temp = a[m];
                a[m] = a[l];
                a[l] = temp;
                l++;
                m++;
            }
            if (a[m] == 1) {
                m++;
            }
            if (a[m] == 2) {
                temp = a[m];
                a[m] = a[h];
                a[h] = temp;
                h--;
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
