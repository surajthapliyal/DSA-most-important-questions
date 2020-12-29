import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class node3{
    int data;
    node3 left;
    node3 right;

    node3(){    //default constructor:

    }
    // function to create a new node :
    node3 newNode(int data){
        // new node :
        node3 newNode = new node3();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return newNode;
    }
}
class qObj{
    // as every node will have its hd and node itself : 
    int hd;
    node3 node;
    qObj(int hd , node3 node){
        this.hd = hd;
        this.node = node;
    }
}

public class verticalOrderTraversal {
    public static void main(String[] args) {

        node3 n = new node3();
        node3 root;
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

        printVerticalOrder(root);
        
    }
    static void printVerticalOrder(node3 root){
        if(root==null) return;

        // creating a map to store the list of all node's data adn their hd:
        TreeMap<Integer,ArrayList<Integer>> m = new TreeMap<>();
        int hd = 0;
        
        // creating queue for level order traversal :
        Queue<qObj> q = new LinkedList<>();
        // adding the root node and 0 hd in the queue : 
        q.add(new qObj(hd, root));

        while(!q.isEmpty()){
            // extracting the first element in the queue :
            qObj extracted = q.remove();
            hd = extracted.hd;
            node3 exNode = extracted.node;
            
            // now , if the map already contains hd as key then add
            // the exNode's key in that place :
            if(m.containsKey(hd)){
                // this get method for map returns the arrayList as value
                // in which we are adding through arrayList's add method :  
                m.get(hd).add(exNode.data);
            }
            else{
                // if map contains the hd as key in it :
                // then create a new arrayList and add exNode's data in it:
                ArrayList<Integer> a = new ArrayList<>();
                a.add(exNode.data);
                // now put this key/value pair in the map:
                m.put(hd,a);
            }

            if(exNode.left != null){
                // if the left of exNode's exist then add it in the queue
                // with hd-1 :
                q.add(new qObj(hd-1, exNode.left));
            }
            if(exNode.right != null){
                // if the right of exNode's exist then add it in the queue
                // with hd+1 :
                q.add(new qObj(hd+1, exNode.right));
            }
        }


        // now traverse the map and print the nodes of every same hd
        // as the node's with same hd lies in the same vertical line : 
        
        // this will return the all entry set present in the map one by one
        // and store it in the Entry type variable entry
        for(Map.Entry<Integer,ArrayList<Integer>> entry : m.entrySet()){
            //now extracting the value(arrayList) from entry :
            ArrayList<Integer> ans = entry.getValue();
            for(Integer item : ans){
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
