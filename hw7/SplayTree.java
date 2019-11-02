/* HW7
 * Due: 3 November 2019
 * Problem Header Hash Code: a506ef1e3156d3e04f7dce9c9533d8d6
*/ 

package hw7;

public class SplayTree extends BTreePrinter{
    Node root;
    
    public SplayTree(){
        
    }
    
    public SplayTree(Node root){
        
        if (root.parent!=null){ // To make sure the root has no parent
            if (root.key < root.parent.key){
                root.parent.left = null;
            }else{
                root.parent.right = null;
            }
            root.parent = null;
        }
        this.root = root;
    }
    
    public void printTree(){
        super.printTree(root);
    }
    
    public Node find(int search_key){
        Node temp = SplayTree.find(this.root, search_key);//Find node recursivly
        this.splay(temp);//Splay found node
        return temp;//Return node
    }

    // This function is already complete, no need to modify
    public Node findWithoutSplaying(int search_key) {
        return find(root, search_key);
    }
    
    // This function is already complete, no need to modify
    private static Node find(Node node, int search_key) {
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
    
    // This function is already complete, no need to modify
    private Node findMin() {
        return findMin(root);
    }

    // This function is already complete, no need to modify
    private static Node findMin(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }
    
    // This function is already complete, no need to modify
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }

    // Fix this function to have splaying feature
    private static void insert(SplayTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        } else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
                tree.splay(node.left);//Splay inserted node
            } else {
                insert(tree, node.left, key);
            }
        } else{ // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
                tree.splay(node.right);//Splay inserted node
            } else {
                insert(tree, node.right, key);
            }
        }
    }
    
    
    public void delete(int key) {
        Node temp = this.find(key);//Find node to delete
        this.splay(temp);//Splay to the root
        SplayTree tempTree = new SplayTree(temp.right);//Create another tree using the node of the right-subtree
        Node min = tempTree.findMin();//Find min of the right-subtree
        tempTree.splay(min);//Splay to the root
        tempTree.root.left = this.root.left;//Take left-subtree of the tree1 and hang as the left subtree of the tree2
        this.root = tempTree.root;//Reassign a new root
    }
    
    // Use this function to call zigzig or zigzag
    public void splay(Node node){
        if (node != null && node != root){//Check if this node isn't root
            if (node.parent == root){//Check if this node is child of root node
                this.zig(node);//Zig this node
            }
            else{//Else if this node is descendant
                if (node.key < node.parent.key){//Left case
                    if (node.parent.key < node.parent.parent.key)this.zigzig(node);//Zigzig this node (outer case)
                    else this.zigzag(node);//Zigzag this node (inner case)
                }
                else{//Right case
                    if (node.parent.key > node.parent.parent.key)this.zigzig(node);//Zigzig this node (outer case)
                    else this.zigzag(node);//Zigzag this node (inner case)
                }
                this.splay(node);//Splay this node
            }
        }
    }
    
    // Use this function to call zig
    public void zigzig(Node node){ // Move two nodes up along the Outer path
        this.zig(node.parent);//Zig this parent node
        this.zig(node);//Zig this node
    }
    
    // Use this funciton to call zig
    public void zigzag(Node node){ // Move two nodes up along the Inner path
        this.zig(node);//Zig this node
        this.zig(node);//Zig this node
    }
    
    // This function should be called by zigzig or zigzag
    public void zig(Node node){// Move up one step
        if(node.parent == null){
            System.out.println("Cannot perform Zig operation on the root node");
        }
        else if(node.parent == root){ // If the node is a child of the root
            if(node.key < node.parent.key){// Zig from left
                if(node.right != null){//Check if this node has right child
                    node.right.parent = node.parent;//Swap child
                    node.parent.left = node.right;
                }
                else node.parent.left = null;
                node.right = node.parent;
                node.right.parent = node;//Set parent node
                node.parent = null;//Node has no parent
                this.root = node;//Set new root
            }
            else{ // Zig from right
                if(node.left != null){//Check if this node has left child
                    node.left.parent = node.parent;//Swap child
                    node.parent.right = node.left;
                }
                else node.parent.right = null;
                node.left = node.parent;
                node.left.parent = node;//Set parent node
                node.parent = null;//Node has no parent
                this.root = node;//Set new root
            }
        }
        else{// if the node is not a child of the root
            if(node.key < node.parent.key){// Zig from left
                if(node.right != null){//Check if this node has right child
                    node.right.parent = node.parent;//Swap child
                    node.parent.left = node.right;
                }
                else node.parent.left = null;//Else if this node has no right child
                node.right = node.parent;
                node.parent = node.parent.parent;
                node.right.parent = node;
                if(node.key < node.parent.key)node.parent.left = node;//Set child of parent node
                else node.parent.right = node;
            }
            else{
                if(node.left != null){//Check if this node has left child
                    node.left.parent = node.parent;//Swap child
                    node.parent.right = node.left;
                }
                else node.parent.right = null;//Else if this node has no left child
                node.left = node.parent;
                node.parent = node.parent.parent;
                node.left.parent = node;
                if(node.key < node.parent.key)node.parent.left = node;//Set child of parent node
                else node.parent.right = node;
            }
        }
    }
}
