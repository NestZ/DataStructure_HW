/* HW7
 * Due: 3 November 2019
 * Problem Header Hash Code: a506ef1e3156d3e04f7dce9c9533d8d6
*/ 

package hw7;

public class AVLTree extends BTreePrinter {

    Node root;

    public AVLTree() {

    }

    public AVLTree(Node root) {
        this.root = root;
        this.root.parent = null; // To make sure the root has no parent
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }

    public Node find(int search_key) {
        return find(root, search_key);
    }

    public static Node find(Node node, int search_key) {
        if (search_key == node.key) {
            return node;
        } else if ((search_key < node.key) && (node.left != null)) {
            return find(node.left, search_key);
        } else if ((search_key > node.key) && (node.right != null)) {
            return find(node.right, search_key);
        } else {
            return null;
        }
    }

    public Node findMin() {
        return findMin(root);
    }

    public static Node findMin(Node node) {
        if (node==null || node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public Node findMax() {
        return findMax(root);
    }

    public static Node findMax(Node node) {
        if (node==null || node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
            return;//Return void
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            } else {
                insert(tree, node.left, key);
            }
        } else{ // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            } else {
                insert(tree, node.right, key);
            }
        }
        AVLTree.rebalance(tree, node);//Rebalance tree
    }
    
    // Fix this
    // If you do not understant my code, feel free to implement your own code
    public static void rebalance(AVLTree tree, Node node){
        if (node.isImbalance()){
            
            /////////////////////////////////////////////////////////////////////////////
            // This code segment is make sure that we rebalance the first imbalance node closest to the leaves
            if (Node.height(node)>2){
                if (Node.height(node.left) > Node.height(node.right)){
                    rebalance(tree, node.left);
                }else{
                    rebalance(tree, node.right);
                }
            }
            /////////////////////////////////////////////////////////////////////////////
            
            if (Node.height(node.left) > Node.height(node.right)) { // Left heavy?
                if (Node.height(node.left.left) > Node.height(node.left.right)) { // Outer?
                    System.out.println("Perform SingleRotationFromLeft (Node " + node.key +")"); // fix ???
                    tree.singleRotateFromLeft(node);//Single rotaion from left
                }else{ // Inner?
                    System.out.println("Perform DoubleRotationFromLeft (Node " + node.key +")"); // fix ???
                    tree.doubleRotateFromLeft(node);//Double rotaion from left
                }
            }else{ // Right heavy?
                if (Node.height(node.right.right) > Node.height(node.right.left)) { //Outer?
                    System.out.println("Perform SingleRotationFromRight (Node " + node.key +")"); // fix ???
                    tree.singleRotateFromRight(node);//Single rotation from right
                } else { // Inner?
                    System.out.println("Perform DoubleRotationFromRight (Node " + node.key +")"); // fix ???
                    tree.doubleRotateFromRight(node);//Double rotation from right
                }
            }
        }
    }
    
    public void singleRotateFromLeft(Node y) {
        if(y.left != null){//Check if left child is null
            if(y.parent != null)y.left.parent = y.parent;//Check if this node has parent node
            else{//Else set new root
                this.root = y.left;
                y.left.parent = null;
            }
            y.parent = y.left;
            if(y.left.right != null){//Check if left child has right child
                y.left = y.left.right;//Swap child
                y.parent.right = null;
                y.left.parent = y;
            }
            else y.left = null;//Else left child is null
            y.parent.right = y;
            if(y.parent.parent != null){//Check if y has parent
                if(y.parent.key < y.parent.parent.key)y.parent.parent.left = y.parent;//Set parent
                else y.parent.parent.right = y.parent;
            }
            else y.parent.parent = null;//Else set parent to null
        }
    }

    public void singleRotateFromRight(Node y) {
        if(y.right != null){//Check if right child is null
            if(y.parent != null)y.right.parent = y.parent;//Check if this node has parent node
            else{//Else set new root
                this.root = y.right;
                y.right.parent = null;
            }
            y.parent = y.right;
            if(y.right.left != null){//Check if right child has left child
                y.right = y.right.left;//Swap child
                y.parent.left = null;
                y.right.parent = y;
            }
            else y.right = null;//Else right child is null
            y.parent.left = y;
            if(y.parent.parent != null){//Check if y has parent
                if(y.parent.key < y.parent.parent.key)y.parent.parent.left = y.parent;//Set parent
                else y.parent.parent.right = y.parent;
            }
            else y.parent.parent = null;//Else set parent to null
        }
    }

    public void doubleRotateFromLeft(Node y) {
        if(y.left.right != null){//Check if right child of left child is null
            this.singleRotateFromRight(y.left);//Rotate left child
            this.singleRotateFromLeft(y);//Rotate y
        }
    }

    public void doubleRotateFromRight(Node y) {
        if(y.right.left != null){//Check if left child of right child is null
            this.singleRotateFromLeft(y.right);//Rotate right child
            this.singleRotateFromRight(y);//Rotate y
        }
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    // This function will delete root or call the recursive delete function
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            if ((root.left == null) && (root.right == null)) { // Case 1 (leaf node)
                root = null;
            } else if ((root.left != null) && (root.right != null)) { // Case 3 (full node)
                Node minRightSubTree = findMin(root.right);
                Node temp = new Node(minRightSubTree.key);
                replace(root, temp);
                root = temp;
                // recursively delete the node
                delete(this, root.right, minRightSubTree.key);
            } else if (root.left != null) { // Case 2 (single child, left child)
                root.left.parent = null; // make left child the root
                root = root.left;
            } else { // Case 2 (single child, right child)
                root.right.parent = null; // make right child the root
                root = root.right; 
            }
            AVLTree.rebalance(this, this.root);//Rebalance tree
        } else { // Delete non-root node
            delete(this, root, key);
        }
    }

    // Fix this function to have the rebalancing feature
    // There should be rebalance function calling somewhere in the code
    // This function will delete non-root nodes
    public static void delete(AVLTree tree, Node node, int key) {
        if (node==null)
        {
            System.out.println("Key not found!!!");
            return;//Return void
        }else if (node.key > key){ // Go left
            delete(tree, node.left, key);
        }else if (node.key < key){ // Go right
            delete(tree, node.right, key);
        }else if (node.key == key){ // Node to be deleted is found
            if ((node.left == null) && (node.right == null)) { // Case 1(leaf node)
                if (node.key < node.parent.key) {
                    node.parent.left = null; // disown the left child
                } else {
                    node.parent.right = null; // disown the right child
                }
            } else if ((node.left != null) && (node.right != null)) { // Case 3 (full nodes)
                Node minRightSubTree = findMin(node.right);
                Node temp = new Node(minRightSubTree.key);
                replace(node, temp);
                // recursively delete the node
                delete(tree, node.right, minRightSubTree.key);
            } else {// Case 2 (single child)
                Node childNode;
                if (node.left != null) {  // only the left child
                    childNode = node.left;
                } else { // only the right child
                    childNode = node.right;
                }
                childNode.parent = node.parent;
                if (node.parent.key > node.key) {
                    node.parent.left = childNode;
                } else {
                    node.parent.right = childNode;
                }
            }
        }
        rebalance(tree, node);//Rebalance tree
    }
    
    // Replace node1 with a new node2
    // node2 must be created using "new Node(key)" before calling this function
    // This function is optional, you do not have to use it
    public static void replace(Node node1, Node node2) {
        if ((node1.left != null) && (node1.left != node2)) {
            node2.left = node1.left;
            node1.left.parent = node2;
        }
        if ((node1.right != null) && (node1.right != node2)) {
            node2.right = node1.right;
            node1.right.parent = node2;
        }
        if ((node1.parent != null) && (node1.parent != node2)) {
            node2.parent = node1.parent;
            if (node1.parent.key > node1.key) {
                node1.parent.left = node2;
            } else {
                node1.parent.right = node2;
            }
        }
    }

    public static boolean isMergeable(Node r1, Node r2){
        if(r1 != null && r2 != null){//Check if node if null
            if(AVLTree.findMax(r1).key < AVLTree.findMin(r2).key)return true;//Check if left sub-tree is less than right sub-tree
        }
        return false;//Else return false
    }
    
    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if (isMergeable(r1, r2)){
            if(Math.abs(Node.height(r1) - Node.height(r2)) <= 1){//Check node's height
                Node temp = BSTree.mergeWithRoot(r1, r2, t);//Just merge
                return temp;//Return root node
            }
            else if(Node.height(r1) > Node.height(r2)){//Check if left is higher
                Node temp = AVLTree.mergeWithRoot(r1.right, r2, t);//Recursive on right side
                r1.right = temp;
                temp.parent = r1;
                return r1;//Return root node
            }
            else{//If right is higher
                Node temp = AVLTree.mergeWithRoot(r1, r2.left, t);//Recursive in left side
                r2.left = temp;
                temp.parent = r2;
                return r2;//Return root node
            }
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }
          
    public void merge(AVLTree tree2){
        if (isMergeable(this.root, tree2.root)){
            Node temp = this.findMax();//Declare temp node
            this.delete(temp.key);//Delete min node of right sub-tree
            this.root = AVLTree.mergeWithRoot(this.root, tree2.root, temp);//Merge trees with root
            AVLTree.rebalance(this, this.root);//Rebalance tree
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
    }
    
    public NodeList split(int key){
        return AVLTree.split(this.root, key);//Split tree by calling static method
    }

    public static NodeList split(Node r, int key){
        NodeList list = new NodeList();
        return list; // Fix this
    }
}
