public class uniqueInArrayOfThriceRepeatingElements {
    public static void main(String[] args) {
        int a[] = {1,1,1,2,2,2,3,3,3,4};
        System.out.println(unique(a));
    }
    
    static int setBit(int n, int pos) {
        return n | (1 << pos);
    }

    static int getBitAt(int n, int pos) {
        return (n & (1 << pos)) == 0 ? 0 : 1;
    }
    
    static int unique(int arr[]){
        int result = 0;
        for(int i=0;i<64;i++){
            int sum = 0;
            for(int j=0;j<arr.length;j++){
                if(getBitAt(arr[j], i)==1){
                    sum++;
                }
            }
            if(sum % 3 != 0){
                result = setBit(result, i);
            }
        }
        return result;
    }
}
