// print union of two arrays : 
import java.util.Arrays;

public class unionOfTwoArray {
    public static void main(String[] args) {
        int a[] = {85,25,1,32,56,6};
        int b[] = {85,2};
        printUnion(a,b);
    }
    static void printUnion(int a[],int b[]){
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0,j=0;
        int u=0;
        while(i<a.length && j<b.length){
            if(a[i] < b[j]){
                System.out.print(a[i]+" ");
                i++;
                u++;
            }else if(b[j] < a[i]){
                System.out.print(b[j]+" ");
                j++;
                u++;
            }else if(a[i] == b[j]){
                System.out.print(a[i]+"  ");
                i++;
                j++;
                u++;
            }
        }
        while (i<a.length) {
            System.out.print(a[i]+" ");
            i++;
            u++;
        }
        while(j<b.length){
            System.out.print(b[j]+" ");
            j++;
            u++;
        }
        System.out.println("\nUnion length = "+u);
    }
}
