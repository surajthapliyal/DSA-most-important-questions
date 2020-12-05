import java.util.*;

public class zeroSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        bruteForce(a);
        sc.close();
    }
    static void bruteForce(int a[]){
        boolean ans = false;
        for(int i=0;i<a.length;i++){
            int sum = 0;
            for(int j=i;j<a.length;j++){
                sum += a[j];
                if(sum == 0) ans = true;
            }
            if(ans) break;
        }
        System.out.println(ans);
    }
    static void usingSets(int a[]){
        Set<Integer> s = new HashSet<>();
        int sum = 0;
        boolean ans = false;
        for(int each : s){
            s.add(sum);
            sum += each;
            if(s.contains(sum)){
                ans = true;
                break;
            }
        }
        System.out.println(ans);
    }
}

