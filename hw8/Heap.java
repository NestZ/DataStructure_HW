/* HW8
 * Due: 16 November 2019
 * Problem Header Hash Code: ea64505d681ad8787ebab0e493c19d8b
*/ 
package hw8;

public class Heap {
    boolean isMinHeap; // true if minHeap, false if maxHeap
    int heapSize; // similar to Array's cap variable
    Node[] arr;//Array as a complete binary tree
    int back; // similar to Array's size variable
    
    // For each push, the timeCounter will increase by 1
    int timeCounter;
    
    public Heap(boolean isMinHeap, int size){
        arr = new Node[size+1];
        heapSize = size;
        back = 1;
        this.isMinHeap = isMinHeap;
        timeCounter = 0;
    }
    public Node top(){
        return null; // FIX THIS
    }
    
    public void push(Node node){
        // Increase timestamp each time you push something
        timeCounter++;
        node.timestamp = timeCounter; // Stamp the time number to the node
        
        // Do something
        // Push new node at the end of the array then sift (percolate) up
        
        
        // Right shift the back pointer
        // back++; // Uncommment this line and put it to the appropriate location
    }
    public Node pop(){
        // DO SOMETHING
        // 1. mark the root for return
        // 2. Replace the last node with the root
        // 3. Sift (percolate) down
        
        // Left shift the back pointer
        // back--; // Uncommment this line and put it to the appropriate location
        
        return arr[1]; // You may have to fix this line

    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void swap(int index1, int index2){
        Node temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Optional: If you do not know what this function does, you do not have to use it
    public void printArray(){
        System.out.print("[");
        for (int i=1; i<back; i++){
            System.out.print(arr[i].price);
            if (i<back-1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

}
