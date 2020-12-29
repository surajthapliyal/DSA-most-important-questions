// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node4 {
    int data;
    Node4 left, right;

    Node4(int d) {
        data = d;
        left = right = null;
    }
}

class topView {

    public static void main(String[] args) throws IOException {
        // Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            Queue<Node4> q = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");

            Node4 root = null;
            int j = 0;
            while (n > 0) {
                int a1 = Integer.parseInt(input[j]);
                int a2 = Integer.parseInt(input[j + 1]);
                char lr = input[j + 2].charAt(0);
                j += 3;

                if (root == null) {
                    root = new Node4(a1);
                    q.add(root);
                }

                Node4 pick = q.peek();

                q.remove();

                if (lr == 'L') {
                    pick.left = new Node4(a2);
                    q.add(pick.left);
                }
                a1 = Integer.parseInt(input[j]);
                a2 = Integer.parseInt(input[j + 1]);
                lr = input[j + 2].charAt(0);
                j += 3;

                if (lr == 'R') {
                    pick.right = new Node4(a2);
                    q.add(pick.right);
                }

                n -= 2;
            }
            View.topView(root);
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends

// User function Template for Java

/*
 * class Node4 { int data; Node4 left, right;
 * 
 * Node4(int item) { data = item; left = right = null; } }
 */
class qObj1 {
    int hd;
    Node4 node4;

    qObj1(int hd, Node4 node4) {
        this.hd = hd;
        this.node4 = node4;
    }
}

class View {
    // function should print the topView of the binary tree
    static void topView(Node4 root) {

        if (root == null)
            return;

        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();

        int hd = 0;

        Queue<qObj1> q = new LinkedList<>();
        q.add(new qObj1(hd, root));

        while (!q.isEmpty()) {
            qObj1 ex = q.remove();
            hd = ex.hd;
            Node4 exNode4 = ex.node4;
            if (m.containsKey(hd)) {
                m.get(hd).add(exNode4.data);
            } else {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(exNode4.data);
                m.put(hd, a);
            }

            if (exNode4.left != null) {
                q.add(new qObj1(hd - 1, exNode4.left));
            }
            if (exNode4.right != null) {
                q.add(new qObj1(hd + 1, exNode4.right));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : m.entrySet()) {
            ArrayList<Integer> ans = entry.getValue();
            System.out.print(ans.get(0) + " ");
        }
    }
}