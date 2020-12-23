package recursion;
import java.util.Scanner;

public class Fastpower {

    static int steps = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exp = sc.nextInt();
        System.out.println(findPower(base , exp));
        System.out.println("Total steps = " + steps);
        sc.close();
    }
    static int findPower(int a , int b){
        steps++;
        // if b gets 0:
        if(b == 0) return 1;
        // if b gets even :
        else if(b % 2 == 0) return findPower(a * a, b / 2);
        // if b gets odd:
        else return findPower(a, b - 1) * a;
    }
}
