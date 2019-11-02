/* HW7
 * Due: 3 November 2019
 * Problem Header Hash Code: a506ef1e3156d3e04f7dce9c9533d8d6
*/ 

package hw7;

public class BSTree extends BTreePrinter {

    Node root;

    public BSTree() {

    }

    public BSTree(Node root) {
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
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public Node findMax() {
        return findMax(root);
    }

    public static Node findMax(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(root, key);
        }
    }

    public static void insert(Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key!!!");
        } else if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            } else {
                insert(node.left, key);
            }
        } else if (node.right == null) {
            node.right = new Node(key);
            node.right.parent = node;
        } else {
            insert(node.right, key);
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

    // You should have "root node deletion" in this function
    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
        } else if (root.key == key) { // Delete root node
            if ((root.left == null) && (root.right == null)) { // Case 1 (leaf node)
                root = null;
            } else if ((root.left != null) && (root.right != null)) { // Case 3 (full node)
                Node minRightSubTree = findMin(root.right); // find min from the right subtree
                Node temp = new Node(minRightSubTree.key);
                replace(root, temp);
                root = temp;
                // recursively delete the node from the right subtree
                delete(root.right, minRightSubTree.key);
            } else if (root.left != null) { // Case 2 (single child, left child)
                root.left.parent = null;
                root = root.left; 
            } else { // Case 2 (single child, right child)
                root.right.parent = null;
                root = root.right; // promote the right child to the root
            }
        } else { // Delete non-root node
            delete(root, key);
        }
    }

    // this function should delete only non-root node
    public static void delete(Node node, int key) {
        if (node==null)
        {
            System.out.println("Key not found!!!");
        }else if (node.key > key){
            delete(node.left, key);
        }else if (node.key < key){
            delete(node.right, key);
        }else if (node.key == key){ // Node to be deleted is found
            if ((node.left == null) && (node.right == null)) { // Case 1(leaf node)
                if (node.key < node.parent.key) {
                    node.parent.left = null; // disown the left child
                } else {
                    node.parent.right = null; // disown the right child
                }
            } else if ((node.left != null) && (node.right != null)) { // Case 3 (full nodes)
                Node minRightSubTree = findMin(node.right); // find min from the right subtree
                Node temp = new Node(minRightSubTree.key);
                replace(node, temp);
                // recursively delete the node start from the right subtree
                delete(node.right, minRightSubTree.key);
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
            if(BSTree.findMax(r1).key < BSTree.findMin(r2).key)return true;//Check if left sub-tree is less than right sub-tree
        }
        return false;//Else return false
    }
    
    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if (isMergeable(r1, r2)) {
            t.left = r1;//Set left child
            t.right = r2;//Set right child
            r1.parent = t;//Set r1 parent
            r2.parent = t;//Set r2 parent
            return t;//Return new root
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }
          
    public void merge(BSTree tree2){
        if (isMergeable(this.root, tree2.root)){//Check if trees is mergable
            Node temp = this.findMax();//Declare temp node
            this.delete(temp.key);//Delete max node of right sub-tree
            this.root = BSTree.mergeWithRoot(this.root, tree2.root, temp);//Merge trees with root
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
        
    }
    
    public NodeList split(int key){
        return BSTree.split(this.root, key);//Return Node list from static method
    }

    public static NodeList split(Node r, int key){
        NodeList list = new NodeList();
        if (r == null){
            return list;
        }else if (key < r.key){
            list = BSTree.split(r.left, key);//Recursivly split tree
            list.r2 = BSTree.mergeWithRoot(list.r2, r.right, r);//Merge sub-tree
            return list;//Return list of tree
        }else{
            list = BSTree.split(r.right, key);//Recursivly split tree
            list.r1 = BSTree.mergeWithRoot(r.left, list.r1, r);//Merge sub-tree
            return list;//Return list of tree
        }
    }
}
