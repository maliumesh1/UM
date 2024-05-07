import java.util.*;

class Main {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    // Depth First Search (DFS) Preorder Traversal
    public static void DFS_Preorder(Node root) {
        if (root == null) {
            return;
        }
        // Visit current node
        System.out.print(root.data + " ");
        // Traverse left subtree
        DFS_Preorder(root.left);
        // Traverse right subtree
        DFS_Preorder(root.right);
    }

    // Depth First Search (DFS) Inorder Traversal
    public static void DFS_Inorder(Node root) {
        if (root == null) {
            return;
        }
        // Traverse left subtree
        DFS_Inorder(root.left);
        // Visit current node
        System.out.print(root.data + " ");
        // Traverse right subtree
        DFS_Inorder(root.right);
    }

    // Depth First Search (DFS) Postorder Traversal
    public static void DFS_Postorder(Node root) {
        if (root == null) {
            return;
        }
        // Traverse left subtree
        DFS_Postorder(root.left);
        // Traverse right subtree
        DFS_Postorder(root.right);
        // Visit current node
        System.out.print(root.data + " ");
    }

    // Breadth First Search (BFS) Level Order Traversal
    public static void BFS_levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            // Visit current node
            System.out.print(temp.data + " ");
            // Enqueue left child
            if (temp.left != null) {
                q.add(temp.left);
            }
            // Enqueue right child
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input root data
        System.out.print("Enter the data for the root node: ");
        int rootData = scanner.nextInt();
        Node root = new Node(rootData);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Construct the binary tree
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Input left child data
            System.out.print("Enter the left child data of " + current.data + " : ");
            int leftData = scanner.nextInt();
            if (leftData != -1) {
                current.left = new Node(leftData);
                queue.add(current.left);
            }

            // Input right child data
            System.out.print("Enter the right child data of " + current.data + " : ");
            int rightData = scanner.nextInt();
            if (rightData != -1) {
                current.right = new Node(rightData);
                queue.add(current.right);
            }
        }

        // Perform DFS Preorder traversal
        System.out.print("DFS_Preorder: ");
        DFS_Preorder(root);
        System.out.println();

        // Perform DFS Inorder traversal
        System.out.print("DFS_Inorder: ");
        DFS_Inorder(root);
        System.out.println();

        // Perform DFS Postorder traversal
        System.out.print("DFS_Postorder: ");
        DFS_Postorder(root);
        System.out.println();

        // Perform BFS Level Order traversal
        System.out.print("BFS_levelOrder: ");
        BFS_levelOrder(root);
    }
}

/* PS C:\Users\SHUBHAM\Desktop\AI PR> javac Main.java
PS C:\Users\SHUBHAM\Desktop\AI PR> java Main.java 
Enter the data for the root node: 1
Enter the left child data of 1 : 2
Enter the right child data of 1 : 3
Enter the left child data of 2 : -1
Enter the right child data of 2 : -1
Enter the left child data of 3 : -1
Enter the right child data of 3 : -1
DFS_Preorder: 1 2 3 
DFS_Inorder: 2 1 3
DFS_Postorder: 2 3 1
BFS_levelOrder: 1 2 3 */
