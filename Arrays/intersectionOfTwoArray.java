import java.util.Arrays;

public class intersectionOfTwoArray {
    public static void main(String[] args) {
        int a[] = {6,32,8,24,13,46,78};
        int b[] = {32,45,56,76,13,6};
        printIntersection(a,b);
    }
    static void printIntersection(int a[],int b[]){
        int i=0,j=0;
        int l=0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (i<a.length && j<b.length) {
            if(a[i] < b[j]){
                i++;
            }else if(b[j] < a[i]){
                j++;
            }else if(a[i] == b[j]){
                System.out.print(a[i]+"  ");
                i++;
                j++;
                l++;
            }
        }
        System.out.print("Intersection length = " + l);
    }
}
