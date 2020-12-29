import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class btnode {
    int data;
    btnode left;
    btnode right;

    btnode() { // default constructor:

    }

    // function to create a new node :
    btnode newNode(int data) {
        // new node :
        btnode newNode = new btnode();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }
}
public class rightView {
    public static void main(String[] args) {
        
        btnode n = new btnode();
        btnode root;
        root = n.newNode(1);
        root.left = n.newNode(2);
        root.right = n.newNode(3);
        root.left.left = n.newNode(4);
        root.left.right = n.newNode(5);
        root.right.left = n.newNode(6);
        root.right.right = n.newNode(7);
        root.left.left.left = n.newNode(8);
        root.left.left.right = n.newNode(9);
        root.left.right.left = n.newNode(10);
        root.left.right.right = n.newNode(11);
        root.right.left.left = n.newNode(12);
        root.right.left.right = n.newNode(13);
        root.right.right.left = n.newNode(14);
        root.right.right.right = n.newNode(15);
        ArrayList<Integer> ans = getRightView(root);
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
    }
    static ArrayList<Integer> getRightView(btnode root){
        ArrayList<Integer> a = new ArrayList<>();
        if(root==null) return a;

        Queue<btnode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                btnode ex = q.remove();
                if(i==size-1){
                    a.add(ex.data);
                }
                if(ex.left != null){
                    q.add(ex.left);
                }
                if(ex.right != null){
                    q.add(ex.right);
                }
            }
        }
        return a;
    }
}
