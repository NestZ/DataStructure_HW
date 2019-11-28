/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/ 
package hw9;



/**
 *
 * @author Patiwet
 */
public class Node {
    
    int vertexIndex; // This variable represents index of the the adjacencyList array that contains a vertex
    Node next; // Point to the next node in the list
    
    public Node(int index){
        this.vertexIndex = index;
    }
}
