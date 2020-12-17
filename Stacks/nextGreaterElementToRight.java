import java.util.Scanner;
class stack{
    int size;
    int top;
    int s[];
    stack(int size){
        this.size = size;
        top = -1;
        s = new int[size];
    }
    void push(int x){
        if(top == size-1) return;
        s[++top] = x;
    }
    void pop(){
        if(top == -1) return;
        top--;
    }
    int peek(){
        if(top==-1) return -1;
        return s[top];
    }
    int size(){
        if(top==-1) return 0;
        return top+1;
    }
}
public class nextGreaterElementToRight {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int a[] = new int[size];
        for(int i=0;i<size;i++){
            a[i] = sc.nextInt();
        }
        int ans[] = leftSideApproach(a);
        for(int each : ans){
            System.out.print(each + " ");
        }
        // bruteForce(a);
        sc.close();
    }
    static int[] solution(int a[]){
        int nge[] = new int[a.length];
        stack s = new stack(a.length);
        // pushing last element to stack.
        s.push(a[a.length - 1]);
        // adding -1 to nge as next greater element to right for last is no one.
        nge[a.length - 1] = -1;
        for (int i = a.length - 2; i >= 0; i--) {

            // now loop till peek < ele and stack is not empty
            while (a[i] >= s.peek() && s.size() > 0) {
                s.pop();
            }
            // if stack become empty it means no one was greater than that element .
            if (s.size() == 0) {
                nge[i] = -1;
            // else peek will be the answer as it is not popped .
            }else{
                nge[i] = s.peek();
            }
            // now push that element in the stack.
            s.push(a[i]);
            
        }
        return nge;
    }
    static void bruteForce(int a[]){
        for(int i=0;i<a.length;i++){
            boolean negative = true;
            for(int j=i;j<a.length;j++){
                if(a[j] > a[i]){
                    System.out.print(a[j] + " ");
                    negative = false;
                    break;
                }
            }
            if(negative) System.out.print("-1" + " ");
        }
    }
    static int[] leftSideApproach(int a[]){
//  for this approach we have to play with the indexes of the elements :
        int nge[] = new int[a.length];
        stack s = new stack(a.length);

        // add first element's index to stack:
        s.push(0);

        // now loop for rest till last:
        for(int i=1;i<a.length;i++){
            // if stack is not empty and peek is smaller then pop:
            while(s.size() > 0 && a[i] > a[s.peek()]){
                // now the element which is popping whom , will be the answer of that :
                // (jo jisko pop kr raha hai wo usi ka answer hai)
                
                // getting position:
                int pos = s.peek();
                // adding the element for which respect we are popping:
                nge[pos] = a[i];
                // now pop:
                s.pop();
            }

            // now push that element's index to the stack :
            s.push(i);
        }

        // now the elements which are remaining in the stack 
        // the answer for all will be -1 as there is no element which is greater than them

        // loop till stack not become empty and add -1 to the answer with respect to that element's index:
        while(s.size() > 0){
            int pos = s.peek();
            nge[pos] = -1;
            s.pop();
        }

        return nge;
    }
}
