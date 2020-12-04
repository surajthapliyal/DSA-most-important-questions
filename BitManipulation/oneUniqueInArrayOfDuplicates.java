public class oneUniqueInArrayOfDuplicates {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,3,2,1};
        System.out.println(unique(a));
    }
    static int unique(int a[]){
        int xorSum = 0;
        for(int i=0;i<a.length;i++){
            xorSum = xorSum^a[i];
        }
        return xorSum;
    }
}
