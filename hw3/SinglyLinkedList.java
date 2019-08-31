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
        if (isEmpty())System.out.println("ERROR");//Error
        else{
            if(head.next == null)head = null;//Check if there is only 1 element then delete head
            else{
                Node curr = head;//Create temp node
                while(curr.next.next != null)curr = curr.next;//Loop and find elements before last node
                curr.next = null;//Delete last node
            }
        }
    }
    
    public void popFront(){
        if (isEmpty())System.out.println("ERROR");
        else head = head.next;//Delete first node by changing head node
    }
    
    public Node topFront(){
        if (isEmpty()){//Check if list is empty
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else return head;//Return first node
    }
    
    public Node topBack(){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else{
            Node curr = head;//Create temp node
            while(curr.next != null)curr = curr.next;//Loop and find last element
            return curr;//Return last node
        }
    }
    
    public void pushFront(Node node){
        if (isEmpty())head = node;
        else{
            node.next = head;//Add node to first node
            head = node;//Change head node
        }
    }
    
    public void pushBack(Node node) {
        if (isEmpty())head = node;
        else{
            Node curr = head;//Create temp node
            while(curr.next != null)curr = curr.next;///Loop and find last node
            curr.next = node;//Add node after last nope
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
            return new Node("Student Not Found!");//Return that node
        }
    }
    
    public Node eraseNode(int id){
        if (isEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        }
        else{
            Node curr = head;//Create temp node
            if(curr.student_id == id){//If there is only one element in list then just change head node
                head = head.next;
                return curr;//Return head node
            }
            while(curr.next != null){//Loop and find node that has its id equal to id
                if(curr.next.student_id == id){
                    Node temp = curr.next;//Create temp node
                    curr.next = curr.next.next;
                    return temp;//Return that node
                }
                else curr = curr.next;
            }
            return new Node("Student Not Found!");//Node does'nt exist in the list
        }
    }
    
    public void addNodeAfter(Node node1, Node node2){
        if(head != null){
            Node curr = head;//Create temp node
            while(curr != null){//Loop and find node1
                if(curr == node1){
                    node2.next = curr.next;
                    curr.next = node2;//Add node2 after node1
                    break;
                }
                else curr = curr.next;
            }
        }
    }
    
    public void addNodeBefore(Node node1, Node node2){
        if(head != null){
            Node curr = head;
            if(curr == node1){//Check if head is node1
                node2.next = node1;//Add node2 before head
                head = node2;//Change head
            }
            else{
                while(curr.next != null){//Loop ans find node1
                    if(curr.next == node1){
                        node2.next = curr.next;//Add node2 before node1
                        curr.next = node2;
                        break;
                    }
                    else curr = curr.next;
                }
            }
        }
    }
    
    public boolean isEmpty(){
        if(head == null)return true;//Check id head is null
        return false;
    }
    public void merge(SinglyLinkedList list){
        if(head != null){
            Node curr = head;//Create temp node
            while(curr.next != null)curr = curr.next;//Loop and find last element
            curr.next = list.head;//Merge list
        }
    }
    
    public void printStructure(){//Traverse from head and print all element in the list
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
