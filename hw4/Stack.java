/* HW4
 * Due: 22 September 2019
 * Problem Header Hash Code: 2a97a54351021e684c6ed55619e8aa6a
*/ 
package hw4;

public class Stack implements List{
    Node head;
    
    public void push(Node node){
        if (head == null)head = node;//Check if stack is empty
        else{
            node.next = head;//Push to stack
            head = node;
        }
    }
    
    public void pop(){
        if (head != null)head = head.next;//Check stack underflow
        else{
            System.out.println("Error: Stack Underflow");
        }
    }
    
    public Node top(){
        return head;
    }
}
