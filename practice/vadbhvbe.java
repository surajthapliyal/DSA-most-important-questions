import java.util.Arrays;
import java.util.Scanner;

public class vadbhvbe {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int b[] = new int[m];
        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }
        findUnion(a,b);
        sc.close();
    }
    static void findUnion(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);

        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i] < b[j]){
                System.out.print(a[i] + " ");
                i++;
            }else if(b[j] < a[i]){
                System.out.print(b[j] + " ");
                j++;
            }else if(a[i] == b[j]){
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }


        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
        while(j<b.length){
            System.out.print(b[j] + " ");
            j++;
        }
    }
}
