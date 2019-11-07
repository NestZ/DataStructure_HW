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
        this.arr = new Node[size+1];
        this.heapSize = size;
        this.back = 1;
        this.isMinHeap = isMinHeap;
        this.timeCounter = 0;
    }
    public Node top(){
        return this.arr[1];//Return top of heap
    }
    
    public void push(Node node){
        // Increase timestamp each time you push something
        this.timeCounter++;
        node.timestamp = this.timeCounter; // Stamp the time number to the node
        
        // Push new node at the end of the array then sift (percolate) up
        this.arr[back] = node;//Push new node
        if(back > 1){//If there are more than one node in this heap
            int b = this.back;//Declare temp variable
            while(b > 1){//Loop if priority isn't satisfy
                if(this.arr[b].compare(this.arr[b / 2])){//If parent is not at satisfy index
                    swap(b, b / 2);//Swap with parent node
                    b = b / 2;//Update value
                }
                else break;
            }
        }
        this.back++;//Right shift the back pointer
    }
    public Node pop(){
        // DO SOMETHING
        // 1. mark the root for return
        // 2. Replace the last node with the root
        // 3. Sift (percolate) down
        Node root = this.arr[1];//Declare temp Node to mark root for return
        this.arr[1] = this.arr[back - 1];//Swap last node and root
        this.arr[back - 1] = null;//Delete last node
        if(this.back > 1){//If there are more than one node in this heap
            int n = 1;//Set current index
            while((n * 2 < this.back - 1) || (n * 2 + 1 < this.back - 1)){//Loop if priority isn't satisfy
                if((n * 2 < this.back - 1) && (n * 2 + 1 < this.back - 1)){//If left and right child isn't null
                    if(this.arr[n * 2].compare(this.arr[n * 2 + 1])){
                        if(!this.arr[n].compare(this.arr[n * 2])){//If left node is not at satisfy index
                            swap(n, n * 2);//Swap with child node
                            n = n * 2;//Update value
                        }
                    }
                    else if(!this.arr[n].compare(this.arr[n * 2 + 1])){//Else if right node is not at satisfy index
                        swap(n, n * 2 + 1);//Swap with child node
                        n = n * 2 + 1;//Update value
                    }
                    else break;
                }
                else if(n * 2 < this.back - 1){//If left child isn't null
                    if(!this.arr[n].compare(this.arr[n * 2])){//If left node is not at satisfy index
                        swap(n, n * 2);//Swap with child node
                        n = n * 2;//Update value
                    }
                    else break;
                }
                else if(n * 2 + 1 < this.back - 1){//If right child isn't null
                    if(!this.arr[n].compare(this.arr[n * 2 + 1])){//Else if right node is not at satisfy index
                        swap(n, n * 2 + 1);//Swap with child node
                        n = n * 2 + 1;//Update value
                    }
                    else break;
                }
            }
        }
        this.back--;//Left shift the back pointer
        return root;//Pop root
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
        for (int i = 1;i < back;i++){
            System.out.print(arr[i].price);
            if (i < back - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

}
