
// { Driver Code Starts
//Initial Template for Java
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class checkIfABinaryIsBSTorNot {

    static TreeNode buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currTreeNode = queue.peek();
            queue.remove();

            // Get the current Treenode's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current Treenode
                currTreeNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currTreeNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current Treenode
                currTreeNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currTreeNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(TreeNode root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Tree g = new Tree();
            if (g.isBST(root))
                System.out.println(1);
            else
                System.out.println(0);
            t--;

        }
    }

}

// } Driver Code Ends

// User function Template for Java

/*
 * Structure of TreeNode: class TreeNode{ int data; TreeNode left; TreeNode right; TreeNode(int
 * data){ this.data = data; left=null; right=null; } }
 */

class Tree {
    // return true if the given tree is a BST, else return false
    boolean isBST(TreeNode root) {
        if (root == null)
            return true; // (base case)

        // if the whole left subtree is lesser than the rootvalue
        // and the whole right subtree is greater than the rootvalue
        // and the rightsubtree is also a BST and the left subtree is also a BST

        if (isSubTreeLesser(root.left, root.data) && isSubTreeGreater(root.right, root.data) && isBST(root.left)
                && isBST(root.right))
            return true;
        else
            return false;
    }

    boolean isSubTreeLesser(TreeNode root, int value) {
        if (root == null)
            return true; // (base case)
        // if the root value is lesser than the given value of the main root and
        // if the left and rigth subtree are also lesser than the main root's value:
        if (root.data < value && isSubTreeLesser(root.left, value) && isSubTreeLesser(root.right, value))
            return true;

        else
            return false;

    }

    boolean isSubTreeGreater(TreeNode root, int value) {
        if (root == null)
            return true; // (base case)
        // if the root value is lesser than the given value of the main root and
        // if the left and rigth subtree are also lesser than the main root's value:
        if (root.data > value && isSubTreeGreater(root.left, value) && isSubTreeGreater(root.right, value))
            return true;

        else
            return false;
    }



    // or we can do this by min max method :
    
    // boolean isBST(Node root) {               <---//this is more efficient
    //     return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // }

    // boolean isBST(Node root, int minval, int maxval) {
    //     if (root == null)
    //         return true;
    //     if (root.data > minval && root.data < maxval && isBST(root.left, minval, root.data)
    //             && isBST(root.right, root.data, maxval))
    //         return true;
    //     else
    //         return false;
    // }
}