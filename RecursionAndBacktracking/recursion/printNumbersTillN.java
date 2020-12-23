package recursion;

public class printNumbersTillN {
    public static void main(String[] args) {
        int n = 10;
        increasing(n);
        System.out.println();
        decreasing(n);
    }
    static void increasing(int n){
        if(n==0) return;
        increasing(n-1);
        System.out.print(n + " ");
    }
    static void decreasing(int n){
        if(n==0) return;
        System.out.print(n+" ");
        decreasing(n-1);
    }
}
