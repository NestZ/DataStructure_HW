/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/ 
package hw9;


/**
 *
 * @author Patiwet
 */
public class Stack {
    Vertex[] arr;
    int cap;
    int size;
    public Stack(int cap){
        arr = new Vertex[cap];
    }
    
    public boolean isEmpty(){
        return size==0;
    }
    
    public void push(Vertex v){
        arr[size] = v;
        size++;
    }
    
    public Vertex pop(){
        Vertex v = arr[size-1];
        size--;
        return v;
    }
}
