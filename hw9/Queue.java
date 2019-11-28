/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/ 
package hw9;



/**
 *
 * @author Patiwet
 */
public class Queue {
    Vertex[] arr;
    int cap;
    int size;
    int front;
    int back;
    public Queue(int cap){
        arr = new Vertex[cap];
        this.cap = cap;
    }
    public boolean isEmpty(){
        return size==0;
    }
    
    public void enqueue(Vertex v){
        arr[back] = v;
        back = (back + 1)%cap;
        size++;
    }
    
    public Vertex dequeue(){
        Vertex v = arr[front];
        front = (front + 1)%cap;
        size--;
        return v;
    }
}
