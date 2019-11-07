/* HW8
 * Due: 16 November 2019
 * Problem Header Hash Code: ea64505d681ad8787ebab0e493c19d8b
*/ 
package hw8;

public class Node {
    double price;
    int investorID;
    int amount;
    long timestamp; // Heap.push() is the only function that modify this variable
    boolean isMinHeap;
    public Node(double price, int investorID, int amount, boolean isMinHeap){
        this.price = price;
        this.investorID = investorID;
        this.amount = amount;
        this.isMinHeap = isMinHeap;
    }
    
    public Node(){
        // Dummy constructor; use Java default values for initialization
        // No need to edit anything here
    }

    // return true if Priority(thisNode) > Priority(rightNode)
    // minHeap: the lower the price, the higher the priority
    // maxHeap: the lower the price, the lower the priority
    // Same price; the smaller the timestamp, the higher the priority
    //
    // You may create your own function if you do not understand my code
    public boolean compare(Node rightNode){
        if (this.price == rightNode.price) {
            return this.timestamp < rightNode.timestamp;//True if lower time stamp
        }else{
            if (isMinHeap){
                if(this.price < rightNode.price)return true;//True if price is lower
                else return false; //Else return false
            }else{
                if(this.price > rightNode.price)return true;//True if price is higher
                else return false; //Else return false
            }
        }
    }
}
