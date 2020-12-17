import java.util.Scanner;
import java.util.Stack;

public class largestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(findArea(a));
        sc.close();
    }
    static int findArea(int a[]){
        // for NSE(next smaller element) index on right :
        int rb[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        // adding last element's index on the stack:
        s.push(a.length-1);
        // add array's length in answer whose nse(to right) is no one:
        // as like for last element:
        rb[a.length -1] = a.length;
        // now loop backwards for rest element :
        for(int i = a.length - 2 ; i>=0 ; i--){
            // pop while stack is not empty and peek is not become smaller:
            while(s.size() > 0 && a[i] < a[s.peek()]){
                s.pop();
            }
            if(s.size() == 0) rb[i] = a.length;
            else rb[i] = s.peek();

            s.push(i);
        }


        // for NSE(next smaller element) index on left :
        int lb[] = new int[a.length];
        Stack<Integer>s2 = new Stack<>();
        // add first element index to stack :
        s2.push(0);
        // add -1 to answer whose nse(to left) is no one:
        // as like for first element:
        lb[0] = -1;
        // now loop for rest element :
        for(int i=1;i<a.length;i++){
            // pop while stack is not empty and peek is not become smaller:
            while(s2.size() > 0  && a[i] < a[s2.peek()]){
                s2.pop();
            }
            if(s2.size() == 0) lb[i] = -1;
            else lb[i] = s2.peek();

            s2.push(i);
        }




        int maxArea = 0;
        // now loop for all element and find area of all :
        for(int i=0;i<a.length;i++){
            int width = rb[i] - lb[i] - 1;
            int area = a[i] * width;    //as a[i] is given as height in the ques.

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
