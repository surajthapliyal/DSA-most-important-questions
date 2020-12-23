package recursion;

public class checkIfArrayIsSorted {
    public static void main(String[] args) {
        int a[] = {1,2,5,6};
        System.out.println(check(a, a.length));
    }
    static boolean check(int a[] , int n){
        // if size becomes 1 or 0 so array of size 1 or 0 is already sorted
        if(n==0 || n==1) return true;
        // otherwise check prev element of array is greater than prev of it
        // and rest part is sorted or not:
        return a[n-1] >= a[n-2] && check(a,n-1);
    }
}
