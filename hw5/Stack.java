/* HW5
 * Due: 29 September 2019
 * Problem Header Hash Code: 6d60335d94511791b62d91647e0f8019
*/ 
package hw5;

public class Stack {
    Node[] arr;
    int capacity;
    int size;

    public Stack(int cap){
        this.capacity = cap;//Initialize Capacity
        this.arr = new Node[cap];//Initialize Node's Array
    }
    
    public void push(Node node){
        if(!isFull())arr[size++] = node;//Push Node
        else System.out.println("Stack Overflow!!!");
    }
    public Node pop(){
        if(!isEmpty())return arr[--size];//Return top Node
        else{
            System.out.println("Stack Underflow!!!");
            return null;
        }
    }
    public boolean isFull(){
        if(this.size == this.capacity)return true;//Check if Stack is full
        return false;
    }
    public boolean isEmpty(){
        if(this.size == 0)return true;//Check if Stack is empty
        return false;
    }
    
    public void printStack(){
        if(!isEmpty()){
            System.out.print("[Bottom] ");
            for(int i = 0;i < this.size;i++)System.out.print(arr[i].data + " ");//Array traversal
            System.out.print("[Top]\n");
        }
        else System.out.println("Empty Stack!!!");
    }
}
