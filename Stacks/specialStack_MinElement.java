import java.util.Scanner;

class specialStack{
    int size;
    int top;
    int minEle;
    int i;
    int stack[];
    int mins[];
    specialStack(int size){
        this.size = size;
        top = -1;
        i = -1;
        minEle = Integer.MAX_VALUE;
        stack = new int[size];
        mins = new int[size];
    }
    boolean isEmpty(){
        return top == -1;
    }
    boolean isFull(){
        return top == size-1;
    }
    void push(int x){
        if(isFull()){
            System.out.println("Stack is Full!");
            return ;
        }
        if(x < minEle) {
            minEle = x;
            mins[++i] = x;
        }
        stack[++top] = x;
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        if(stack[top] == mins[i]) i--;
        return stack[top--];
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stack[top];
    }
    void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return;
        }
        for(int i=0;i<=top;i++){
            System.out.print(stack[i] + " ");
        }
    }
    int getMin(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return -1;
        }
        return mins[i];
    }
}

public class specialStack_MinElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        specialStack s = new specialStack(size);
        int choice;
        do{
            System.out.println("\n1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Peek");
            System.out.println("4.GetMin");
            System.out.println("5.Display");
            System.out.println("6.Exit\n");

            System.out.print("Enter choice = ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    s.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println(s.pop() + " is poped");
                    break;
                case 3:
                    System.out.println(s.peek() + " is peek");
                    break;
                case 4:
                    System.out.println(s.getMin() + " is min");
                    break;
                case 5: 
                    s.display();
                    break;
                case 6:
                    System.exit(1);
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
        }while(choice != 6);

        sc.close();
    }
}
