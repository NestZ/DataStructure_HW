/* HW3
 * Due: 8 September 2019
 * Problem Header Hash Code: 2ff097005a3c2152adc9b09f1a1ff3da
*/ 
package hw3;

public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        this.listName = name;
    }
    
    public void popBack() {
        if (isEmpty())System.out.println("ERROR");
        else{
            if(head.next == null)head = null;
            else{
                Node curr = head;
                while(curr.next.next != null)curr = curr.next;
                curr.next = null;
            }
        }
    }
    
    public void popFront(){
        if (isEmpty())System.out.println("ERROR");
        else head = head.next;
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
        else{
            Node curr = head;
            while(curr.next != null)curr = curr.next;
            return curr;
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty())head = node;
        else{
            node.next = head;
            head = node;
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty())head = node;
        else{
            Node curr = head;
            while(curr.next != null)curr = curr.next;
            curr.next = node;
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
            if(curr.student_id == id){
                head = head.next;
                return curr;
            }
            while(curr.next != null){
                if(curr.next.student_id == id){
                    Node temp = curr.next;
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
            Node curr = head;
            while(curr != null){
                if(curr == node1){
                    node2.next = curr.next;
                    curr.next = node2;
                    break;
                }
                else curr = curr.next;
            }
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(head != null){
            Node curr = head;
            if(curr == node1){
                node2.next = node1;
                head = node2;
            }
            else{
                while(curr.next != null){
                    if(curr.next == node1){
                        node2.next = curr.next;
                        curr.next = node2;
                        break;
                    }
                    else curr = curr.next;
                }
            }
        }
    }
    
    public boolean isEmpty(){
        if(head == null)return true;
        return false;
    }
    public void merge(SinglyLinkedList list){
        if(head != null){
            Node curr = head;
            while(curr.next != null)curr = curr.next;
            curr.next = list.head;
        }
    }
    
    public void printStructure(){
        Node curr = head;
        System.out.print(this.listName + ": head -> ");
        while(curr != null){
            System.out.print("{" + curr.student_id + "} -> ");
            curr = curr.next;
        }
        System.out.print("null\n");
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
