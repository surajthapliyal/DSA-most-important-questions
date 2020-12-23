package recursion;

public class findOccurenceOfANumberInArray {
    public static void main(String[] args) {
        int a[] = {45,3,32,23,6,32};
        int num = 45;
        System.out.println("first occ of " + num + " = " + first(a,num,0));
        System.out.println("last occ of " + num + " = " + last(a,num,a.length-1));
    }
    static int first(int a[],int num,int i){
    //  if index becomes last and number is not found return -1:
        if(i==a.length) return -1;
    //  if number is found at ith index return i:
        if(a[i]==num) return i;
    //  else check in rest part with i+1 till last:
        return first(a,num,++i);
    }

    static int last(int a[],int num,int i){
        if(i==-1) return -1;
        if(a[i] == num) return i;
        return last(a,num,--i);
    }
}
