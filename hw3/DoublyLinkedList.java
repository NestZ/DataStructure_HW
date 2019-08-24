/* HW3
 * Due: 8 September 2019
 * Problem Header Hash Code: 2ff097005a3c2152adc9b09f1a1ff3da
*/ 
package hw3;

public class DoublyLinkedList {
    Node head;
    Node tail;
    String listName;
    
    public DoublyLinkedList(String name){
        this.listName = name;
    }
    
    public void popBack() {
      if (isEmpty())System.out.println("ERROR");
        else{
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                tail = tail.previous;
                tail.next = null;
            }
        }
    }
    
    public void popFront(){
        if (isEmpty())System.out.println("ERROR");
        else{
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                head = head.next;
                head.previous = null;
            }
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else return head;
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else return tail;
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node;
            tail = node;
        }
        else{
            head.previous = node;
            node.next = head;
            head = node;    
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else{
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        }
        else{
            Node curr = head;
            while(curr != null){
                if(curr.student_id == id)return curr;
                else curr = curr.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else{
            Node curr = head;
            Node temp = curr;
            if(curr.student_id == id){
                head = curr.next;
                head.previous = null;
                return temp;
            }
            while(curr != null){
                if(curr.student_id == id){
                    temp = curr;
                    curr = curr.previous;
                    curr.next = curr.next.next;
                    return temp;
                }
                else curr = curr.next;
            }
            return new Node("Student Not Found!");
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(head != null){
            Node curr = tail;
            while(curr != null){
                if(curr == node1){
                    node2.previous = curr;
                    node2.next = curr.next;
                    curr.next = node2;
                    if(node2.next != null)node2.next.previous = node2;
                    else tail = node2;
                    break;
                }
                else curr = curr.previous;
            }
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(head != null){
            Node curr = head;
            while(curr != null){
                if(curr == node1){
                    node2.next = curr;
                    node2.previous = curr.previous;
                    curr.previous = node2;
                    if(node2.previous != null)node2.previous.next = node2;
                    else head = node2;
                    break;
                }
                else curr = curr.next;
            }
        }
    }
    
    public boolean isEmpty(){
        if(head == null)return true;
        return false;
    }
    public void merge(DoublyLinkedList list){
        tail.next = list.head;
        list.head.previous = tail;
    }
    
    public void printStructure(){
        Node curr = head;
        System.out.print(this.listName + ": head <-> ");
        while(curr != null){
            System.out.print("{" + curr.student_id + "} <-> ");
            curr = curr.next;
        }
        System.out.print("tail\n");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){ 
        Node current=tail;
        System.out.print(listName + ": tail <-> ");
        while(current!=null){
            System.out.print("{" + current.student_id + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
    }
    
    public Node whoGotHighestGPA(){
        if (isEmpty())return new Node("Empty List!");
        else{
            double temp = 0;
            Node max = null;
            Node curr = head;
            while(curr != null){
                if(curr.gpa >= temp){
                    temp = curr.gpa;
                    max = curr;
                }
                curr = curr.next;
            }
            return max;
        }
    }
}
