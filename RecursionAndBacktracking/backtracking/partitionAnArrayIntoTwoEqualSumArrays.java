package backtracking;

import java.util.ArrayList;

public class partitionAnArrayIntoTwoEqualSumArrays {
    public static void main(String[] args) {
        int a[] = {2,1,2,3,4,8};
        int sum = 0;
        for(int item : a){
            sum += item;
        }
        System.out.println("Sum = " + sum);
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean isPossible = sum%2==0 && partition(a, sum/2, 0, ans);          //or (sum&1)==0; to check even
        
        if(isPossible)
        for(int item : ans) System.out.print(item + " ");

        else System.out.println("Not possible!!");

    }
    static boolean partition(int a[], int sum, int i, ArrayList<Integer> ans){

        // if i reaches the length of the array : (base condition)
        // or if the sum given is less than 0:
        if(i>=a.length || sum < 0) return false;
        if(sum==0) return true;

        ans.add(a[i]);

        boolean leftPossible = partition(a, sum-a[i], ++i, ans);
        if(leftPossible) return true;

        // if adding it to the one half wont work for the solution then remove it 
        // from that half and removing it from the half is means that it will be the
        // solution for the another half :(backtrack)
        ans.remove(ans.size()-1);
        return partition(a, sum, ++i, ans);
    }
}
