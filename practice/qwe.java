public class qwe {
    static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
        }
    }
    node head = null;
    void add(int data){
        node newNode = new node(data);
        if(head==null){
            head = newNode;
            return;
        }
        node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    static void display(node head){
        if(head==null){
            System.out.println("List is Empty!!");
            return ;
        }
        node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    static void merge(node head1,node head2){
        if(head1==null && head2==null) return;
        // dummy head node for new ll : 
        node dummy = new node(0);
        node tail = dummy;
        while(true){
            if(head1==null){
                tail.next = head2;
                break;
            }if(head2==null){
                tail.next = head1;
                break;
            }

            if(head1.data<=head2.data){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        display(dummy.next);
    }
    public static void main(String[] args) {
        qwe ll = new qwe();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.display(ll.head);

        System.out.println();

        qwe l2 = new qwe();
        l2.add(6);
        l2.add(7);
        l2.add(8);
        l2.add(9);
        l2.add(10);
        l2.display(l2.head);

        System.out.println();

        qwe.merge(ll.head, l2.head);
    }
}
