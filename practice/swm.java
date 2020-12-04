import java.util.ArrayList;
import java.util.Scanner;

public class swm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        System.out.print("Enter size of the window = ");
        int k = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<=a.length-k;i++){
            int mx = 0;
            for(int j=i;j<=i+k-1;j++){
                mx = Math.max(mx,a[j]);
            }
            al.add(mx);
        }
        System.out.println(al);
        sc.close();
    }   
}
