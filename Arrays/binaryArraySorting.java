public class binaryArraySorting {
    public static void main(String[] args) {
        int a[] = {1 ,0 ,1 ,1, 0};
        int l = 0;
        int m = 0;
        int h = a.length-1;

        while(m<h){
            if(a[m] == 0){
                int temp = a[m];
                a[m] = a[l];
                a[l] = temp;
                m++; l++;
            }else if(a[m] == 1){
                int temp = a[m];
                a[m] = a[h];
                a[h] = temp;
                h--;
            }
        }
        for(int each : a){
            System.out.print(each + " ");
        }
    }
}
