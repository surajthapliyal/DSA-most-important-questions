public class rotateByK {
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
    void rotate(node head,int k){
        if (k == 0 || head == null) {
            return ;
        }
        // finding position to rotate from :
        node temp = head;
        node breakNode = null;
        node newHead = null;
        for (int i = 1; temp.next != null; i++) {
            if (i == k) {
                breakNode = temp;
                newHead = temp.next;
            }
            temp = temp.next;
        }
        breakNode.next = null;
        temp.next = head;
        display(newHead);
    }
    public static void main(String[] args) {
        rotateByK l = new rotateByK();
        l.add(2);
        l.add(4);
        l.add(7);
        l.add(8);
        l.add(9);

        l.display(l.head);
        System.out.println();
        int k = 3;
        l.rotate(l.head , k);

    }
}
