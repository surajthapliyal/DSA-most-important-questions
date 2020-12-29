// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;

class Node2
{
    int data;
    Node2 left;
    Node2 right;
    Node2(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class inorderSuccessor {
    
    static Node2 buildBTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the Btree
        Node2 root = new Node2(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node2> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node2 currNode2 = queue.peek();
            queue.remove();
                
            // Get the current node2's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node2
                currNode2.left = new Node2(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode2.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node2
                currNode2.right = new Node2(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode2.right);
            }
            i++;
        }
        
        return root;
    }

    public static Node2 search(Node2 root,int x){
		if(root==null||root.data==x)
			return root;
		if(root.data>x)
			return search(root.left,x);
		return search(root.right,x);
	}

	public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node2 root = buildBTree(s);
                
                int k=Integer.parseInt(br.readLine());
                Node2 kNode2 = search(root,k);
                
                BTree g = new BTree();
                Node2 x = g.inorderSuccessor(root,kNode2);
                
                if(x==null) System.out.println("-1");
                else System.out.println(x.data);
                t--;
            }
    }
}// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node2 is as follows:
class Node2{
	int data;
	Node2 left,right;
	Node2(int d){
		data=d;
		left=right=null;
	}
}
*/
class BTree
{
    // returns the inorder successor of the Node2 x in BST (rooted at 'root')
	public Node2 inorderSuccessor(Node2 root,Node2 x)
         {
            //  passing data of the node2 whose IOS we want to find :
          return getSuccessor(root,x.data);
         }
    public Node2 getSuccessor(Node2 root,int data){
        // step 1 : search the given data in the Btree : 
        // this will find the node2 in the Btree and return the reffrence of the node2: 
        Node2 current = findNode2(root,data);
        // if node2 not found the the Btree : 
        if(current == null) return null;
        
        // now case 1 - if the node2 has right subBtree : 
        // then the IOS of that node2 will be the deep leftmost node2 in the right subtre :
        // same as the min value to find in the given subBtree as the min value of
        // any subBtree is located in the last leftmost node2 :
        if(current.right != null) {
            return findMin(current.right);
        }
        
        // now case 2 - if the node2 is not having the right subBtree and having only
        // left subBtree then the IOS of that node2 will be the nearest ancestor for 
        // which the given node2 would be in the left subBtree : 
        else{
            Node2 successor = null;
            Node2 ancestor = root;
            // finding current and all the paths which lie b/w ancestor and the 
            // node2 to find(current) will be considered as ancestors and can be the 
            // successor(IOS) of that node2(current) :
            while(ancestor != current){
                if(current.data < ancestor.data){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }else{
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
        
    }
    
    public Node2 findMin(Node2 root){
        // mimimum of the Btree is located in the leftmost leaf of the Btree
        // so we will keep moving until we reach the leftmost leaf :
        if(root==null) return null;
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public Node2 findNode2(Node2 root, int data) {
    	if(root == null) return null;
    	else if(root.data == data) return root;
    	else if(data > root.data) return findNode2(root.right,data);
    	else return findNode2(root.left,data);
    }
}