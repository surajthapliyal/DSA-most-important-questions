import java.util.Scanner;

public class seiveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int last = sc.nextInt();
        primeSeive(last);
        sc.close();
    }
    static void primeSeive(int n){
        int arr[] = new int[n+1];
        for(int i=2;i<=n;i++){
            if (i * i > n)
                break;
            if (arr[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                        arr[j] = 1;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(arr[i]==0) System.out.println(i);
        }
    }
}
