import java.util.Scanner;

public class subArray_with_given_sum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }

        int s = sc.nextInt();
        twoPointers(a, s);
        sc.close();
    }

    static void bruteForce(int a[],int s){
        int start = 0;
        int end = 0;
        int sum = 0;
        int i, j;
        boolean isFound = false;
        for (i = 0; i < a.length; i++) {
            sum = 0;
            for (j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == s) {
                    isFound = true;
                    start = i;
                    end = j;
                    break;
                }
            }
            if (isFound)
                break;
        }
        if (isFound)
            System.out.println(start + " " + end);
        else
            System.out.println("Not Found!");
    }

    static void twoPointers(int a[],int sum){
        int i=0,j=0,st=-1,en=-1,currsum=0;
        while(j<a.length && currsum+a[j]<=sum){
            currsum+=a[j];
            j++;
        }
        if(currsum == sum){
            System.out.println((i+1)+" "+j);
            return;
        }
        while(j<a.length){
            currsum +=a[j];
            while(sum > sum){
                sum-=a[i];
                i++;
            }
            if(currsum == sum){
                st = i+1;
                en = j+1;
                break;
            }
            j++;
        }
        System.out.println(st+" "+en);
    }
}
//  int currSum = 0,start = 0;
//         for(int i=0;i<a.length;i++){
//             currSum += a[i];
//             if(currSum > sum){
//                 while (currSum > sum) {
//                     currSum=currSum-a[start];
//                     start++;
//                 }
//                 if(currSum == sum) {
//                     System.out.println(start + " " + (i+1));
//                     return;
//                 }
//             }
//             if(currSum == sum){
//                 System.out.println((start+1)+" "+(i+1));
//                 return;
//             }
//         }
//         System.out.println("Not found");