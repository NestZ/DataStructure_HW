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
      if (isEmpty())System.out.println("ERROR");//Error
        else{
            if(head == tail){//Check if there is only 1 element in the list
                head = null;
                tail = null;
            }
            else{
                tail = tail.previous;//Delete last node
                tail.next = null;//Change tail node
            }
        }
    }
    
    public void popFront(){
        if (isEmpty())System.out.println("ERROR");//Check if list is empty
        else{
            if(head == tail){//Check if there is only 1 element in the list
                head = null;
                tail = null;
            }
            else{
                head = head.next;//Delete first node
                head.previous = null;//Change head node
            }
        }
    }
    
    public Node topFront(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else return head;//Return head node
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else return tail;//Return tail node
    }
    
    public void pushFront(Node node){
        if (isEmpty()){
            head = node;
            tail = node;
        }
        else{
            head.previous = node;//Add node to first element
            node.next = head;
            head = node;//Change head node    
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else{
            node.previous = tail;//Add node to tail
            tail.next = node;
            tail = node;//Change tail node
        }
    }

    public Node findNode(int id){
        if (isEmpty()){
            return new Node("Empty List!");
        }
        else{
            Node curr = head;//Create temp node
            while(curr != null){//Loop and find node that has its id equal to id
                if(curr.student_id == id)return curr;//If found then return that node
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
            Node curr = head;//Create temp node
            Node temp = curr;
            if(curr.student_id == id){//If there is only 1 element in the list
                head = curr.next;
                head.previous = null;
                return temp;//Return head node
            }
            while(curr != null){//Loop and find node that has its id equal to id
                if(curr.student_id == id){
                    temp = curr;
                    curr = curr.previous;
                    curr.next = curr.next.next;
                    return temp;//Return that node
                }
                else curr = curr.next;
            }
            return new Node("Student Not Found!");//If node doesn't exist in the list
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(head != null){
            Node curr = tail;//Start traversing from tail node
            while(curr != null){//Loop and find node1
                if(curr == node1){
                    node2.previous = curr;//Add node2 after node1
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
            Node curr = head;//Start traversing from head
            while(curr != null){//Loop and find node1
                if(curr == node1){
                    node2.next = curr;//Add node2 before node1
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
        if(head == null)return true;//Check if head is null
        return false;
    }
    public void merge(DoublyLinkedList list){
        tail.next = list.head;//Change first list's tail and second list's head
        list.head.previous = tail;
    }
    
    public void printStructure(){//Traverse from head and print all element in the list
        Node curr = head;
        System.out.print(this.listName + ": head <-> ");
        while(curr != null){
            System.out.print("{" + curr.student_id + "} <-> ");
            curr = curr.next;
        }
        System.out.print("tail\n");
    }
    
    // This may be useful for you for implementing printStructure()
    public void printStructureBackward(){//Traverse from tail and print all element in the list
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
            double temp = 0;//Create variable for store GPA
            Node max = null;//Creat node to store max's Node
            Node curr = head;//Create temp node
            while(curr != null){//Loop and find max Node
                if(curr.gpa >= temp){
                    temp = curr.gpa;
                    max = curr;
                }
                curr = curr.next;
            }
            return max;//Return that node
        }
    }
}
