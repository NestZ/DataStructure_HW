/* HW4
 * Due: 22 September 2019
 * Problem Header Hash Code: 2a97a54351021e684c6ed55619e8aa6a
*/ 
package hw4;

public class Queue implements List{
    Node head;
    Node tail;
    
    public void push(Node node){
        if (head == null){//Check if queue is empty
            head = node;
            tail = node;
        }
        else{//Push to queue
            tail.next = node;
            tail = node;
        }
    }
    
    public void pop(){
        if (head != null){//Check if queue is empty
            if (head != tail)head = head.next;
            else head = null;
        }
    }
    
    public Node top(){
        return head;
    }
    
}
