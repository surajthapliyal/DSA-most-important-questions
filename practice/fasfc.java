import java.util.Arrays;
import java.util.Scanner;

public class fasfc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }

        final int N =(int) 1e6+2;
        int idx[] = new int[N];
        Arrays.fill(idx, -1);
        int minidx = Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            idx[a[i]] = i;
            if(idx[a[i]]!=-1){
                minidx = Math.min(minidx,idx[a[i]]);
            }
        }
        //If no repeating element :
        if(minidx == Integer.MAX_VALUE){
            System.out.println("-1");
        }else{
            System.out.println(minidx+1);
        }
        sc.close();
    }
}
