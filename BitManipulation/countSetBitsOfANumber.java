import java.util.Scanner;

public class countSetBitsOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Total Set Bits in " + num + " is = " + countSetBits(num));
        sc.close();
    }
    static int countSetBits(int n){
        int i=0;
        while(n!=0){
            n = n & (n-1);
            i++;
        }
        return i;
    }
}
