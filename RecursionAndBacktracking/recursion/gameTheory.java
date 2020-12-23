package recursion;

public class gameTheory {
    public static void main(String[] args) {
        int a[] = {1,5,700,2};
        System.out.println(coins(a, 0, a.length-1));
    }
    static int coins(int a[], int l, int r){
        // if we have only two coins then obvioulsy we will select the max of both: 
        if(l+1==r) {
            return Math.max(a[l], a[r]);
        }
        // then we will be getting the min because other player is also smart enough:
        return Math.max(a[l] + Math.min(coins(a, l+2, r) , coins(a, l+1, r-1)),
                        a[r] + Math.min(coins(a, l+1, r-1) , coins(a, l, r-2)));
    }
}
