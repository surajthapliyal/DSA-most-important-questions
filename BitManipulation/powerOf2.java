import java.util.Scanner;

public class powerOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(withBM(num)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.close();
    }
    static boolean withoutBM(int num){
        while(num!=1){
            if(num%2!=0) return false;
            num=num/2;
        }
        return true;
    }
    static boolean withBM(int num){
        // as we know ,if we do AND of any number who is a power of 2(let n)
        // with one number lesser than that(let n-1) , then we will always
        // get 0 in all bits .

        return (num!=0) && ((num & (num-1))==0);
        //       |
        //       |~~~~> this is because for the input 0, the answer will be wrong
        //   so we have to check it,if it is zero then it will false and whole
        // answer will be false.
    }
}
