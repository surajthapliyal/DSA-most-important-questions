public class reverseLinkedList {
    class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    node head = null;
    void reverseIterative(){
        if(head==null){
            display(head);
            return;
        }
        node curr = head;
        node prev = null;
        node nextAdd;
        while(curr!=null){
            nextAdd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextAdd;
        }  
        //now last node is prev which is head node after reversal and curr is null
        head = prev;
        display(head);   
    }
    void reverseRecursive(node temp){
        if(temp.next==null){    
            head = temp;
            return;
        }
        reverseRecursive(temp.next);
        // after base condition execution temp will point to the second last node
        temp.next.next = temp;
        temp.next = null;
    }   
    void display(node head){
        if(head == null){
            System.out.println("list is Empty");
            return;
        }
        node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    void add(int data){
        node newNode = new node(data);
        if(head==null){
            head = newNode;
            return;
        }
        node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = newNode;
    }
    public static void main(String[] args) {
        reverseLinkedList l1 = new reverseLinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.display(l1.head);
        System.out.println();
        l1.reverseIterative();
        System.out.println();
        l1.reverseRecursive(l1.head);
        l1.display(l1.head);
    }
}
