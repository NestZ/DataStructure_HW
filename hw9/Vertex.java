/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/ 
package hw9;

public class Vertex {
    
    // Vertex Information
    String strKey;
    int intKey;
    
    // For BFS and DFS only
    int ccNum;
    boolean visited;
    int dist;
    
    // Vertex previous pointer for constructing shortest-path tree
    // Do not get confused with Node prev pointer
    // Hint: This variable is used only in functions BFS() and getShortestPathList()
    Vertex prev; 
    
    public Vertex(String key){
        this.strKey = key;
    }
    
    public Vertex(int key){
        this.intKey = key;
        this.strKey = Integer.toString(key);
    }

  
}
