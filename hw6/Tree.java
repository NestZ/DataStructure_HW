/* HW6
 * Due: 20 October 2019
 * Problem Header Hash Code: 80ccb30754443710a07db3a4c52d1212
*/ 

package hw6;

public class Tree extends BTreePrinter{
    Node root;
    
    public Tree(){
    
    }
    
    public Tree(Node root){
        this.root = root;//Initialize root node
    }
    
    public void printTree(){
        super.printTree(root);//Call printTree method from super class
    }

    public Node find(int search_key){
        Node curr = root;//Declare current node
        while(curr != null){//Loop until current node is null or found the node
            if(search_key > curr.key)curr = curr.right;//If this key > current then go right
            else if(search_key < curr.key)curr = curr.left;//If this key > current then go left
            else if(search_key == curr.key)break;//If found node then break
        }
        return curr;//Return current node
    }
    
    public static Node find(Node node, int search_key){
        if(node != null){//Check null node
            Node curr = node;//Declare current node
            if(search_key > curr.key)return Tree.find(node.right, search_key);//If this key > current then find right
            else if(search_key < curr.key)return Tree.find(node.left, search_key);//If this key > current then find left
        }
        return node;//If node is null or found the node then return
    }
    
    public Node findClosest(int search_key){
        Node curr = root;//Declare current node
        while(curr.key != search_key){//Loop until found closest node;
            if(search_key > curr.key){//If search_key is greater
                if(curr.right != null)curr = curr.right;//If right child isn't null then go right
                else return curr;//Else return current node
            }
            else if(search_key < curr.key){//If search_key is lower
                if(curr.left != null)curr = curr.left;//If left child isn't null then go left
                else return curr;//Else return current node
            }
        }
        return curr;//If search_key = current node's key then return current node
    }
    
    public static Node findClosest(Node node, int search_key){
        if(search_key > node.key){//If search_key is greater
            if(node.right != null)return Tree.findClosest(node.right, search_key);//If right child isn't null then return closest node by recursion
            else return node;//Else return current node
        }
        else if(search_key < node.key){//If search_key is lower
            if(node.left != null)return Tree.findClosest(node.left, search_key);//If left child isn't null then return closest node by recursion
            else return node;//Else return current node
        }
        return node;//If search_key = current node's key then return this node
    }
    
    public Node findMin(){
        Node curr = root;//Declare current node
        while(curr.left != null)curr = curr.left;//Loop until left child is null
        return curr;//Return current node
    }
    
    public static Node findMin(Node node){
        if(node.left == null)return node;//If left child is null then return this node
        return Tree.findMin(node.left);//Else return min by recursion
    }
    
    public Node findMax(){
        Node curr = root;//Declare current node
        while(curr.right != null)curr = curr.right;//Loop until right child is null
        return curr;//Return current node
    }
    
    public static Node findMax(Node node){
        if(node.right == null)return node;//If right child is null then return this node
        return Tree.findMax(node.right);//Else return max by recursion
    }
    
    public Node findKthSmallest(int k){
        Node curr = this.findMin();//Declare current node as min node of tree
        for(int i = 0;i < k - 1;i++)curr = curr.findNext();//Find next k times to reach Kth smallest node
        return curr;//Return current node
    }
    
    public static Node findKthSmallest(Node node, int k){
        Node curr = Tree.findMin(node);//Declare current node as min node of node
        for(int i = 0;i < k - 1;i++)curr = curr.findNext();//Find next k times to reach Kth smallest node
        return curr;//Return current node

    }
    
    public List rangeSearch(int x, int y){
        List list = new List(100);
        Node curr = this.findClosest(x);//Declare current node and init it's value to x's closest node
        while(curr != null){//Loop until current node is null
            if(curr.key >= x && curr.key <= y)list.append(curr);//If key is in range then add to list
            else if(curr.key > y) break;//Break if out of range
            curr = curr.findNext();//Find next node
        }
        return list;//Return list of node in range
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        Tree.printPreOrderDFT(root);//Call recursive print method
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        if(node == null)return;//Check null node
        System.out.print(node.key + " ");//Print node's key
        Tree.printPreOrderDFT(node.left);//Print left subtree
        Tree.printPreOrderDFT(node.right);//Print right subtree
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        Tree.printInOrderDFT(root);//Call recursive print method
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        if(node == null)return;//Check null node
        Tree.printInOrderDFT(node.left);//Print left subtree
        System.out.print(node.key + " ");//Print node's key
        Tree.printInOrderDFT(node.right);//Print right subtree
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        Tree.printPostOrderDFT(root);//Call recursive print method
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        if(node == null)return;//Check null node
        Tree.printPostOrderDFT(node.left);//Print left subtree
        Tree.printPostOrderDFT(node.right);//Print right subtree
        System.out.print(node.key + " ");//Print node's key
    }
    
    public void insert(int key) {
        if(root == null)root = new Node(key);//If root is null then insert node at root
        else{
            Node curr = Tree.findClosest(root, key);//Else find closest node
            if(curr.key == key)System.out.println("Duplicated key!!!");//If closest node'key = key then it's duplicate key
            else{
                if(key > curr.key){//Else if key is greater then add node at right child
                    curr.right = new Node(key);//Set child node
                    curr.right.parent = curr;//Set parent node
                }
                else{//Else add node at left child
                    curr.left = new Node(key);//Set child node
                    curr.left.parent = curr;//Set parent node
                }
            }
        }
    }
    
    public void delete(int key) {
        if(root == null)System.out.println("Empty Tree!!!");//Check null root
        else if(root.key == key){//If root is key then delete root
            int temp = Tree.findMin(root.right).key;//Store min node of right subtree's key
            Tree.delete(Tree.findMin(root.right));//Delete min node of right subtree
            root.key = temp;//Assign root's key
        }
        else{ 
            Node curr = this.find(key);//Else find key to delete
            if(curr == null)System.out.println("Key not found!!!");//If key not found
            else Tree.delete(curr);//Else delete current node
        }
    }
    
    public static void delete(Node node){
        if(node.left == null && node.right == null){//Case 1
            if(node.key < node.parent.key)node.parent.left = null;//If node is on the left then delete left child
            else if(node.key > node.parent.key)node.parent.right = null;//If node is on the right then delete right child
        }
        else if((node.left == null && node.right != null) || (node.left != null && node.right == null)){//Case 2
            if(node.left != null){//If node is on the left then replace node with it's left child 
                Tree.replace(node, node.left);//Call optional replace method
            }
            else if(node.right != null){//If node is on the right then replace node with it's right child 
                Tree.replace(node, node.right);//Call optional replace method
            }
        }
        else if(node.left != null && node.right != null){//Case 3
            Tree.replace(node, Tree.findMin(node.right));//Replace node with min node of right subtree
        }
    }
    
    public static void replace(Node node1, Node node2){//Optional method
        if(node1.left != null && node1.left != node2){
            node2.left = node1.left;
            node1.left.parent = node2;
        }
        if(node1.right != null && node1.right != node2){
            node2.right = node1.right;
            node1.right.parent = node2;
        }
        if(node1.parent != null && node1.parent != node2){
            node2.parent = node1.parent;
            if(node1.parent.key > node1.key)node1.parent.left = node2;
            else node1.parent.right = node2;
        }
    }
    
    public int height(){
        return this.root.height();//Return height of root node
    }
    
    public int depth(){
        return this.height();//Tree depth is equal to tree height so return height
    }
    
    public int size(){
        return this.root.size();//Return size of root node
    }
}
