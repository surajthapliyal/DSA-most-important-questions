import java.util.Scanner;

public class recordBreaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size+1];  //create 1 extra size of array to compare last element
        a[size] = -1;               //set last element to -1
        System.out.println("Enter elements for not negative array : ");
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        int days = 0;
        int mxday = -1;
        for(int i=0;i<size;++i){
            if(a[i] > mxday && a[i] > a[i+1]){
                System.out.println(a[i]);
                days++;
            }
            mxday = Math.max(a[i],mxday);
        }
        System.out.println("Total record breaker days = " + days);
    }
}
