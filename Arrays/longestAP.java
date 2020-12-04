import java.util.Scanner;

public class longestAP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        int max = maxLen(a);
        System.out.println("Max arithmetic subarray length = "+max);
        sc.close();
    }
    static int maxLen(int a[]){
        int pd = a[1]-a[0];     // previous difference
        int curr = 2;           //current length
        int ans = curr  ;            //ans length
        int j = 2;              //to traverse the array with index 2, 
                                // as first two are already done and stored in pd

        while(j<a.length){
            if(pd == a[j]-a[j-1]){
                curr++;
            }else{
                pd = a[j]-a[j-1];
                curr = 2;
            }
            ans = Math.max(ans,curr);
            j++;
        }
        return ans;
    }
}
