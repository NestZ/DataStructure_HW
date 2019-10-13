/* HW6
 * Due: 20 October 2019
 * Problem Header Hash Code: 80ccb30754443710a07db3a4c52d1212
*/ 
package hw6;

public class Node{
    Node left;
    Node right;
    Node parent;
    int key;
    
    public Node(int data){
        this.key = data;//Initialize key's value
    }
    
    public int height(){
        return Node.height(this);//Call recursive static method to find height
    }
    
    public static int height(Node node){
        if(node == null)return -1;//Null node's height is -1
        else return 1 + Math.max(Node.height(node.left), Node.height(node.right));//Return 1 + max height of left or right subtree by recursion
    }

    public int size(){
        return Node.size(this);//Call recursive static method to find size
    }
    
    public static int size(Node node){
        if(node == null)return 0;//Null node's size is 0
        else return 1 + Node.size(node.left) + Node.size(node.right);//Return 1 + left subtree's size + right subtree's size
    }
    
    public Node findNext(){
        if(this.right != null)return Node.leftDescendant(this.right);//If right child node isn't null then return the leftmost node of right child
        else return Node.rightAncestor(this);//Else return first ancestor that is on the right of node
    }
    
    public static Node leftDescendant(Node node){
        Node curr = node;//Declare current node
        while(curr.left != null)curr = curr.left;//Loop until left descendant is null
        return curr;//Return leftmost descendant
    }
    
    public static Node rightAncestor(Node node){
        Node curr = node;//Declare current node
        while(curr.parent.left != curr)curr = curr.parent;//Loop until current node is on the left of it's parent
        return curr.parent;//Return the first right ancestor
    }
    
    public int depth(Tree tree){
        Node curr = tree.root;//Declare current node
        int depth = 0;//Initialize depth vairiable
        while(curr.key != this.key){//Loop until find this node
            if(this.key > curr.key && curr.right != null)curr = curr.right;//If this key > current then go right
            else if(this.key < curr.key && curr.left != null)curr = curr.left;//If this key < current then go left
            else if(this.key == curr.key)break;//If found node then break
            depth++;//Update depth's value
        }
        return depth;//Return this node depth
    }
}
