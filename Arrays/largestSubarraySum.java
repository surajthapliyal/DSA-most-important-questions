// find Largest sum contiguous Subarray [V. IMP]
// sol 1 = BruteForce o(n^2)
// sol 2 = Kadane's Algorithm o(n)
import java.util.Scanner;

public class largestSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        Kadane(arr);
        sc.close();
    }
    static void bruteForce(int arr[]){
        int sum = 0;
        int maxSum = -1999999;
        for(int i=0;i<arr.length;i++){
            sum = 0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Max subarray sum = " + maxSum);
    }
    static void Kadane(int a[]){
        int currSum = 0;
        int maxSum = -1999999;
        for(int i=0;i<a.length;i++){
            currSum += a[i];
            if(currSum < 0){
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("Max subarray sum = "+ maxSum);
    }
}
