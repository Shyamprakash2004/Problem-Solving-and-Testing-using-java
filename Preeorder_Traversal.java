class Node {
    int data;
    Node left;
    Node right;
}

public class PreorderTraversal {
    
    // Function to be completed
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        
        // Print the data of the current node
        System.out.print(root.data + " ");
        
        // Traverse left subtree
        preOrder(root.left);
        
        // Traverse right subtree
        preOrder(root.right);
    }
}
