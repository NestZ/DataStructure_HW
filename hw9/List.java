/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/ 
package hw9;

public class List { // Singly Linked-List with Tail
    Node head;
    Node tail;
    
    // Only one function is used in this homework
    public void pushBack(Node node){
        if (tail!=null){
            tail.next = node;
            tail = tail.next;
        }else{
            tail = node;
            head = tail;
        }
    }
}
