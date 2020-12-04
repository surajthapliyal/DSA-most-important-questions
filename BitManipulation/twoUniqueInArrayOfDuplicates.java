public class twoUniqueInArrayOfDuplicates {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,4,3,2,1};
        findUniques(a);
    }
    static void findUniques(int a[]){
        int xorSum = 0;
        for(int i=0;i<a.length;i++){
            xorSum ^= a[i];
        }
        // now finding the position of right most set bit 
        // and checking all the numbers in the array who contains
        // setBit at the same position and then doing xor of them:

        int tempXor = xorSum;
        int setBit = 0;
        int pos = 0;
        while(setBit != 1){
            // this will give the bit at the 0th position : 
            setBit = xorSum & 1;
            // increasing position:
            pos++;
            // shifting bits right side so that we can check other bits
            // by shifting it to 0th position : 
            xorSum = xorSum >> 1;
        }

        // now checking all elements in array having setBit at same position,
        // and then doing XOR of them so that we can get one non repeating element :  
        int newXor = 0;
        for(int i=0;i<a.length;i++){
            if(setBit(a[i],pos-1)){
                newXor = newXor ^ a[i];
            }
        }
        System.out.println(newXor);
        // now for second non repeating element in the array : 
        // we do xor of newXor and and tempXor(xorSum) which is calculated previously : 
        System.out.println(newXor ^ tempXor);
    }
    static boolean setBit(int n,int pos){
        return (n & (1<<pos))==1;
    }
}
