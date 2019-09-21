/* HW5
 * Due: 29 September 2019
 * Problem Header Hash Code: 6d60335d94511791b62d91647e0f8019
*/ 
package hw5;

public class Node extends BTreePrinter{
    Node left;
    Node right;
    int data;

    public Node(int data){
        this.data = data;//Initialize data
    }

    public void printTree(){
        super.printTree(this);
    }

    public void printBFT(){
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
        q.enqueue(this);//Push root to Queue
        while(!q.isEmpty()){//Traverse until Queue is empty
            Node temp = q.dequeue();
            if(temp.left != null)q.enqueue(temp.left);//Push left child Node
            if(temp.right != null)q.enqueue(temp.right);//Push right child Node
            System.out.print(temp.data + " ");//Print Node's data
        }
        System.out.println("]");
    }

    public void printDFT(){ //PreOrder
        Stack s = new Stack(50);
        System.out.print("DFT node sequence [ ");
        s.push(this);//Push root to Stack
        while(!s.isEmpty()){//Traverse until Stack is empty
            Node temp = s.pop();
            if(temp.right != null)s.push(temp.right);//Push right child to Stack
            if(temp.left != null)s.push(temp.left);//Push left child to Stack
            System.out.print(temp.data + " ");//Print Node's data
        }
        System.out.println("]");
    }
}
