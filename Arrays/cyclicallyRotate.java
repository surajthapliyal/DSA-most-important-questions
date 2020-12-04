// cyclically rotate array by one : 
public class cyclicallyRotate {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        rotate(a);
    }
    static void rotate(int arr[]){
        int temp = arr[arr.length-1];
        for(int i=arr.length-1;i>=1;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        for(int each : arr){
            System.out.print(each + "  ");
        }
    }
}
