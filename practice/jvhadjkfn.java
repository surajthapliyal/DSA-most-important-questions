import java.util.Arrays;
import java.util.Scanner;

public class jvhadjkfn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int b[] = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        findIntersection(a,b);
        sc.close();
    }
    // static void findIntersection(int a[],int b[]){
    //     for(int i=0;i<a.length;i++){
    //         for(int j=0;j<b.length;j++){
    //             if(a[i] == b[j])
    //             System.out.print(a[i]+" ");
    //         }
    //     }
    // }
    static void findIntersection(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);

        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i] < b[j]) i++;
            if(b[j] < a[i]) j++;
            else if(a[i] == b[j]){
                System.out.print(a[i]+" ");
                i++; j++;
            }
        }
    }
}
