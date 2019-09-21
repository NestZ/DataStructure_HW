/* HW5
 * Due: 29 September 2019
 * Problem Header Hash Code: 6d60335d94511791b62d91647e0f8019
*/ 
package hw5;

public class Queue {
    Node[] arr;
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        this.capacity = cap;//Initialize Capacity
        this.arr = new Node[cap];//Initialize Node's Array
    }
    
    public void enqueue(Node node){
        if(!isFull()){
            this.arr[this.back++] = node;//Push to Queue
            if(this.back == capacity)this.back = 0;//Round up Variable
            size++;//Increase Array's Size
        }
        else System.out.println("Queue Overflow!!!");
    }
    
    public Node dequeue(){
        if (!isEmpty()){
            this.size--;//Decease Array's Size
            if(this.front == this.capacity - 1){
                this.front = 0;//Keep front Variable in range
                return this.arr[capacity - 1];
            }
            else return this.arr[front++];
        }
        else{
            System.out.println("Queue Underflow!!!");
            return null;
        }
    }
    
    public boolean isEmpty(){
        if(this.size == 0)return true;//Check if Queue is empty
        return false;
    }
    
    public boolean isFull(){
        if(this.size == this.capacity)return true;//Check if Queue is full
        return false;
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if(!isEmpty()){
            System.out.print("[Front] ");
            for(int i = 0,n = this.front;i < this.size;i++,n++){//Circular Array Traversal
                if(n == this.capacity)n = 0;//Round up Variable
                System.out.print(this.arr[n].data + " ");//Print Node's data
            }
            System.out.println("[Back]");
        }
        else System.out.println("Empty Queue!!!");
    }
}
