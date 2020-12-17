import java.util.Scanner;
import java.util.Stack;

public class TheCelebrityPorblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        System.out.println("Input " + n*n + " data of 0 and 1:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int a[] : arr){
            for(int each : a){
                System.out.print(each + " ");
            }
            System.out.println();
        }

        findCelebrity(arr);
    }
    static void findCelebrity(int arr[][]){
        Stack<Integer> s = new Stack<>();
        // filling stack with the numbers(0 to N):
        for(int i=0;i<arr.length;i++){
            s.push(i);
        }

        // now loop till stack is containing 2 elements in it as we have 
        // check 2 elements at once:
        while(s.size() >= 2){
            // now take two elements from stack to check:
            int i = s.pop();
            int j = s.pop();

            // now , if i knows j
            if(arr[i][j] == 1){
                // so i is not the celebrity:
                s.push(j);
            }else{
                // if i doesNot know j , so j is not a celebrity:
                s.push(i);
            }
        }

        // now after these steps, only one element will be remaining in the stack:
        // we can assume that as celebrity:
        int potentialCeleb = s.pop();

        // to make it sure , we have to check the row and column in potentialCeleb :
        // in which row should contains all 0 and column should contains all 1(except i==jth box):
        for(int i=0;i<arr.length;i++){
            if(i!=potentialCeleb){
                // now , if any i know pot.. or pot.. know any i so pot.. is not a celeb i.e, noone is celeb
                if(arr[i][potentialCeleb] == 0 || arr[potentialCeleb][i] == 1){
                    System.out.println("no one");
                    return;
                }
            }
        }

        System.out.println(potentialCeleb);
    }
}
