// merge sort's merge logic:
public class mergeTwoSortedLinkedList {
    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
        }
    }

    node head = null;

    static void display(node head) {
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

    static void merge(node head1,node head2){
        // create new linked list and append data to it :

        // for new linkedList we need newNode as a head Node to it, let it be :
        node dummy = new node(0);

        // let tail of the new linked list be :
        node tail = dummy;  //as initially dummy node is the only element in the new ll.

        //looping both whole list  :
        while(true){
            // if list 1 is empty then add whole remaining 2list in the new ll and break:
            if(head1==null){
                tail.next= head2;
                break;
            }
            // if list 2 is empty then add whole remaining 1list in the new ll and break:
            if(head2==null){
                tail.next = head1;
                break;
            }

            // else ,
            // compare data of both the list, whichever's data is smaller append it to the tail of the new ll 
            // and move head of that list to the next node :
            
            if(head1.data <= head2.data){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            // and move tail forward in both cases : 
            tail = tail.next; 
        }
        // display new list first node :
        display(dummy.next);
    }
    public static void main(String[] args) {
        mergeTwoSortedLinkedList l1 = new mergeTwoSortedLinkedList();
        mergeTwoSortedLinkedList l2 = new mergeTwoSortedLinkedList();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(14);
        l1.display(l1.head);
        System.out.println();

        l2.add(2);
        l2.add(7);
        l2.add(11);
        l2.add(12);
        l2.add(15);
        l2.add(19);
        l2.add(51);
        l2.display(l2.head);
        System.out.println();

        mergeTwoSortedLinkedList.merge(l1.head, l2.head);
    }
}
