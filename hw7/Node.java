/* HW7
 * Due: 3 November 2019
 * Problem Header Hash Code: a506ef1e3156d3e04f7dce9c9533d8d6
*/ 

package hw7;

public class Node{
    Node left;
    Node right;
    Node parent;
    int key;
    
    public Node(int data){
        this.key = data;
    }

    // To simplify the problem, Please use 'height(node)' to evaluate height of the node
    public static int height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isImbalance(){
        if(Math.abs(Node.height(this.left) - Node.height(this.right)) > 1)return true;//Check if this node is imbalance
        return false;//Else return false
    }
}
