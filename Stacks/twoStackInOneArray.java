import java.util.Scanner;

class twoStack{
    int size;
    int stack[];
    int top1 , top2;
    twoStack(int size){
        this.size = size;
        stack = new int[size];
        top1 = -1;
        top2 = size;
    }
    void push1(int x){
        if(top2 == top1+1){
            System.out.println("Stack is Full");
            return;
        }
        stack[++top1] = x;
    }
    void push2(int x){
        if(top2 == top1 + 1){
            System.out.println("Stack is Full!!");
            return;
        }
        stack[--top2] = x;
    }
    int pop1(){
        if(size1() == 0){
            System.out.println("Stack is Empty!!");
            return -1;
        }  
        return stack[top1--];
    }
    int pop2(){
        if (size2() == 0) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return stack[top2++];
    }
    int size1(){
        return top1+1;
    }
    int size2(){
        return stack.length - top2;
    }
    void display1(){
        if (size1() == 0) {
            System.out.println("Stack is Empty!!");
            return;
        }
        for(int i=0;i <= top1;i++){
            System.out.print(stack[i] + " ");
        }
    }
    void display2(){
        if (size2() == 0) {
            System.out.println("Stack is Empty!!");
            return;
        }
        for(int i=size-1;i>=top2;i--){
            System.out.println(stack[i] + " ");
        }
    }
}

public class twoStackInOneArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        twoStack ts = new twoStack(sc.nextInt());
        int choice;
        do{
            System.out.println("\n1.Push1");
            System.out.println("2.Push2");
            System.out.println("3.Pop1");
            System.out.println("4.Pop2");
            System.out.println("5.Size1");
            System.out.println("6.Size2");
            System.out.println("7.Display1");
            System.out.println("8.Display2");
            System.out.println("9.Exit\n");

            System.out.print("Enter your choice = ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ts.push1(sc.nextInt());
                    break;
                case 2:
                    ts.push2(sc.nextInt());
                    break;
                case 3:
                    System.out.println(ts.pop1() + " is pop");
                    break;
                case 4:
                    System.out.println(ts.pop2() + " is pop");
                    break;
                case 5:
                    System.out.println(ts.size1() + " is size1");
                    break;
                case 6:
                    System.out.println(ts.size2() + " is size2");
                    break;
                case 7:
                    ts.display1();
                    break;
                case 8:
                    ts.display2();
                    break;
                case 9:
                    System.exit(1);
                default:
                    break;
            }
        }while(choice != 9);

        sc.close();
    }
}
