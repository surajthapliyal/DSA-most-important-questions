package recursion;

import java.util.Scanner;

public class sumTillN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Sum till " + n + " = " + sum(n));
        sc.close();
    }
    static int sum(int n){
        if(n == 1)  return 1;
        return sum(n - 1) + n;
    }
}
