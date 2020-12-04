import java.util.Scanner;

public class primeFactorisationUsingSeive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        primeFactors(num);
        sc.close();
    }
    static void primeFactors(int n){
        int spf[] = new int[n+1];
        // now marking all numbers with itself:
        for(int i=2;i<=n;i++){
            spf[i] = i;
        }
        // now marking all numbers with its SPF :
        for(int i=2;i<=n;i++){
            if(i*i > n) break;
            if(spf[i] == i){
                for(int j=i*i;j<=n;j+=i){
                    spf[j] = i;
                }
            }
        }

        // now loop until we get 1 after dividing : 
        while(n != 1){
            // printing spf of n:
            System.out.print(spf[n] + " ");
            // now making new number after dividing the number with its spf : 
            n = n / spf[n];
        }
    }
}
