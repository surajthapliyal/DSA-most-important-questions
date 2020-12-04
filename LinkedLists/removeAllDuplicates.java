// pair check algorithm : 

public class removeAllDuplicates {
    
    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
        }
    }

    node head = null;

    void display(node head) {
        if (head == null) {
            System.out.println("list is Empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    void add(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void removeDup(){
        if(head==null || head.next == null) return;
        // make two pointers curr1 and curr2 and point them to first and second node respectively,
        // if data in both the nodes are equal then make curr1.next link to curr2.next and move 
        // curr2 to the next node of curr1 only.
        // if data in both the nodes are not equal then move curr1 to curr2 and curr2 to the next of it.
        node curr1 = head;
        node curr2 = head.next;

        // looping while curr1 not reaches last node.
        while(curr1.next != null){
            if(curr1.data == curr2.data){
                curr1.next = curr2.next;
                // now curr1.next contains the address of node next to curr2
                // so curr2 will point to the next node of new link.
                curr2 = curr1.next;
            }else{
                // move both forward:
                curr1 = curr2;
                curr2 = curr2.next;
            }
        }
        display(head);
    }
    public static void main(String[] args) {
        removeAllDuplicates ll = new removeAllDuplicates();
        ll.add(1);
        ll.add(2);
        ll.add(2);
        ll.add(3);
        ll.add(3);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.display(ll.head);
        System.out.println();
        ll.removeDup();
    }
}
