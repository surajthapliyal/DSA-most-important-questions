public class generateAllSubsetsOfASet {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        subsets(arr);
    }
    static void subsets(int arr[]){
        int n = arr.length;
        for(int i=0;i<(1<<n);i++){
            System.out.print("{ ");
            for(int j=0;j<n;j++){
                // performing getBit:
                if((i & (1<<j))>0) System.out.print(arr[j] + " ");
            }
            System.out.println("}");
        }
    }
}
