// runner algorithm to find kth element from the end : 

public class kthELementFromTail {
    
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
    
    void findElement(int positionFromTail) {
        if (head == null)
            return;
        // create two pointer runner and curr and initialize both of them with head :
        node runner = head;
        node curr = head;

        // now move runner to the kth position from start :
        for (int i = 0; i < positionFromTail; i++) {
            runner = runner.next;
        }
        // now runner will be pointing to the element one prev to the position given
        // ex-if position is 2 then runner will be pointing to the 1 position as the
        // condition says i<positionFromTail.

        // now more both pointer runner and current simultaneously
        // till runner.next != null :
        while (runner.next != null) {
            runner = runner.next;
            curr = curr.next;
        }
        // now the curr will be pointing to the positionFromTailLocation
        System.out.println(curr.data);
    }
    
    public static void main(String[] args) {
        kthELementFromTail ll = new kthELementFromTail();
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.add(0);
        ll.display(ll.head);
        System.out.println();
        ll.findElement(2);

    }
}
