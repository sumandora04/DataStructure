public class BinarySearchTree {

    //Create a LinkedList with key, value, rightNode and leftNode;
    class Node {
        int key;
        String value;
        Node left, right;

        // constructor for Node
        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        // Find the minimum key node:
        // Always go to the left of a node and search for min value.
        public Node min() {
            if (left == null) {
                //if left of the current node is null then the current node is minimum.
                return this;
            } else {
                // If not then recurse
                return left.min();
            }
        }
    }

    //Create a root node:
    Node root;

    // constructor for BinarySearchTree
    public BinarySearchTree() {
        root = null; // Initialise root to null.
    }

    // Searching for a key:
    //Function to find the node of a key:
    private Node findNode(Node node, int key) {
        if (node == null || node.key == key) { // If the key matches the key at this node or the node is null then, this is the node we are searching for.
            return node; // So, return the node.
        } else if (key < node.key) { // The key did not match the key at node and less than the node.key
            return findNode(node.left, key); // Go to left node and search for the key. --> Recursive.
        } else if (key > node.key) { // The key did not match the key at node and more than the node.key
            return findNode(node.right, key); // Go to right node and search for the key. --> Recursive.
        }

        // If the key is not matching with any node: return null;
        return null;
    }


    public String find(int key) {
        // Find the node for this key using findKey().
        Node node = findNode(root, key); // Start searching from root.

        // If node is null, then return null, other-wise return the value in it.
        return node == null ? null : node.value;
    }


    //Inserting nodes into BST:
    private Node insertItems(Node node, int key, String value) {
        // Create a new node with the given key and value:
        Node newNode = new Node(key, value);

        // If the given node is null, set this newNode to the given node and return the node:
        if (node == null) {
            node = newNode;
            return node;
        }

        //If the node is not null then we walk un-till we find a null node and assign the newNode there.
        // 1. when key < node.key
        if (key < node.key) {
            //Go left and insert the key --> Recursive function.
            node.left = insertItems(node.left, key, value);
        }
        // 2. when key > node.key
        else if (key > node.key) { //
            //Go right and insert the key --> Recursive function.
            node.right = insertItems(node.right, key, value);
        }

        //If none of those conditions satisfy, then a same exist in the BST. As duplicate keys are not allowed, we simply ignore them.

        //Return the fully constructed tree:
        return node;
    }

    //Inserting key and value:
    public void insert(int key, String value) {
        //Always start with the root.
        //Assign the return node value from insertItems() to root.
        //If root is not null then insertItems() will handle the rest.
        root = insertItems(root, key, value);
    }


    // Delete a node in BST:
    /*
     *  3 cases:
     *  1. Node with NO child. --> Simply set the reference = null.
     *  2. Node with ONE child. --> Replace the node with its child, which will effectively delete the node.
     *  3. Node with TWO child. --> Go to the right of the node. --> Find the minNode --> Create a duplicate of minNode and replace the node with the duplicate --> delete the minNode. --> Recursively.
     *
     * */

    // findMinNode() for 3rd case:
    public Node findMinNode(Node node) {
        return node.min(); // min() in the Node class.
    }

    // get the minKey():
    public int minKey() {
        return findMinNode(root).key; // Start with root and return the key finally.
    }

    // Delete node:
    private Node deleteNode(Node node, int key) {
        //Find the key in the BST before delete:
        if (node == null) { // When node is empty-- BST is empty.
            return null;
        } else if (key < node.key) { // If key < node.key, go to left of the node.
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) { // if key>node.key, go to right of the node.
            node.right = deleteNode(node.right, key);
        } else {
            //We found the key here. Start the delete procedure:
            //CASE-1: No child:
            if (node.left == null && node.right == null) {
                node = null; // Make that node to null.
            }
            //CASE-2: One child:
            else if (node.left == null) { // The node is having a right child.
                node = node.right; // Replace the node with the right child.
            } else if (node.right == null) { // The node is having a left child.
                node = node.left; // Replace the node with the left child.
            }

            //CASE-3: Two child:
            else {
                // Find the minimum node on the right of this given node (could be the max on left when there is no right child)
                Node minRightNode = findMinNode(node.right);

                // Make a duplicate of the minRightNode by copying it:
                node.key = minRightNode.key;
                node.value = minRightNode.value;

                //Now delete the duplicate node i.e: the minRightNode.
                //We cant do node.right = null; because there may be nodes attached to the minRightNode and we might end-up deleting the nodes attacted to it.
                // So delete it recursively.
                node.right = deleteNode(node.right, node.key);
            }
        }

        // Return the node finally.
        return node;
    }

    //Delete:
    public void delete(int key) {
        root = deleteNode(root, key); // Start with the root always.
    }

    /*
     *  BST traversal:
     *  Two types: 1. Breadth first search, 2. Depth first search
     *  -- Depth first search is of three types:
     *  (A) Inorder traversal - Left --> Root --> Right.
     *  (B) Pre-order traversal - Root --> Left --> Right.
     *  (C) Post-order traversal - Left --> Right --> Root.
     * */

    // Inorder traversal - Left --> Root --> Right.
    private void inOrderTraversal(Node node) {
        if (node != null) { // Recurse till the node is not null
            inOrderTraversal(node.left); // Left
            System.out.println(node.key); // Root
            inOrderTraversal(node.right); // Right
        }
    }

    public void printInOrder() {
        inOrderTraversal(root);
    }

    // Pre-order traversal - Root --> Left --> Right.
    private void preOrderTraversal(Node node) {
        if (node != null) { // Recurse till the node is not null
            System.out.println(node.key); // Root
            preOrderTraversal(node.left); // Left
            preOrderTraversal(node.right); // Right
        }
    }

    public void printPreOrder() {
        preOrderTraversal(root);
    }

    // Post-order traversal - Left --> Right --> Root.
    private void postOrderTraversal(Node node) {
        if (node != null) { // Recurse till the node is not null
            preOrderTraversal(node.left); // Left
            preOrderTraversal(node.right); // Right
            System.out.println(node.key); // Root
        }
    }

    public void printPostOrder() {
        postOrderTraversal(root);
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

       /* bst.insert(6,"Suman");
        bst.insert(2,"Pooja");
        bst.insert(11,"Manish");
        bst.insert(1,"Divya");
        bst.insert(8,"Nikhil");
        bst.insert(15,"Himatej");
        bst.insert(9,"Supriya");
        bst.insert(10,"Shilpa");

        System.out.println("Pre-order");
        bst.printPreOrder();
        System.out.println("In-order");
        bst.printInOrder();
        System.out.println("Post-order");
        bst.printPostOrder();

        System.out.println("Minimum key:"+bst.minKey());

        System.out.println(bst.find(2));
        System.out.println(bst.find(6));
        System.out.println(bst.find(8));

        bst.delete(1);
        System.out.println("Pre-order after delete: 1");
        bst.printPreOrder();
        bst.delete(9);
        System.out.println("Pre-order after delete: 9");
        bst.printPreOrder();
        bst.delete(6);
        System.out.println("Pre-order after delete: 6");
        bst.printPreOrder();*/

        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        System.out.println("Pre-order");
        bst.printPreOrder();
        System.out.println("In-order");
        bst.printInOrder();
        System.out.println("Post-order");
        bst.printPostOrder();
    }
}
