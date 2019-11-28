/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/ 
package hw9;

public class Graph {
    
    Vertex[] vertexList; // This list contain vertices
    List[] adjacencyList; // Graph implemented by Adjacency List
    
    int cap;
    int size;
    int cc;
    public static final int INFINITY = -1;
    public Graph(int cap){
        this.cap = cap;
        size = 0;
        vertexList = new Vertex[cap]; // Create a vertex list (array of vertices)
        adjacencyList = new List[cap]; // Create an adjacency list (array of lists)
    }
    
    public void addVertex(int key){
        if (size == cap){
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }
        
        // Add an vertex with the key to the list
	// Beware that Graph has 2 constructors
        //
        this.vertexList[key] = new Vertex(key);//add vertex to vertex list
        // Create an empty list to the appropriate location in the adjacency list
        this.adjacencyList[key] = new List();//add new vertex to adjacencyList
        this.size++;// Increase the vertex counter by one
    }
    
    // Two way edge
    // If you make a path from u to v, you must make a path from v to u
    public void addEdge(int u, int v){
        if (vertexList[u] == null){
            System.out.println("Source node does not exist");
            return;
        } if (vertexList[v] == null){
            System.out.println("Destination node does not exist");
            return;
        }
        
        if (!isConnected(u, v)){// Check if there is already a path from u to v
            // Call a function to connect the source vertex (u) to the destination vertex (v)
            // Hint: Pushback a new Node(v) to the appropriate List(u)
            this.adjacencyList[u].pushBack(new Node(v));//Pushback Node v to list u
            // Call a function to connect the destination vertex (v) to the source vertex (u)
            // Hint: Like above but swicth u and v
            this.adjacencyList[v].pushBack(new Node(u));//Push back Node u to list v
        }else{
            System.out.println("There are already a path conntecting "+u+" and "+v);
        }
    }
    
    // Check if vertex u is connected with vertex v
    // By checking if the adjacency list u contains a node with key (vertexIndex) equals to v
    public boolean isConnected(int u, int v){
        List list = adjacencyList[u];
        Node node = list.head;
        while(node != null){//Traverse list until find node v
            if(node.vertexIndex == v)return true;//if node v is found then return true
            node = node.next;
        }
        return false;//Else return false
    }

    public void showList(int u){
        Vertex v = vertexList[u];
        List list = adjacencyList[u];
        if (list==null)
            return;
        Node node = list.head;
        System.out.print("Vertex " + v.strKey + " connected to the following vertices: ");
        while(node!=null){
            System.out.print(vertexList[node.vertexIndex].strKey + ", ");
            node = node.next;
        }
        System.out.println();
    }  
    
    public void DFS(){
        for(Vertex v : this.vertexList){
            if(v != null)v.visited = false;// Reset all vertex visited parameters
        }
        this.cc = 1;// Set cc to 1
        for(Vertex v : this.vertexList){
            if(v != null){//If vertex is not null
                if(!v.visited){//If node is not visited
                    this.Explore(v);// Explore unvisited vertices
                    this.cc++;// Increase cc by one after each connected component
                }
            }
        }
        System.out.println();// Add a new line after finishing all vertices
    }
    
    public void Explore(Vertex v){
        v.visited = true;// Set the current vertex to be visited
        v.ccNum = this.cc;// Stamp cc to the current vertex
        System.out.print(v.strKey +"/"+v.ccNum+" -> ");// Print out vertex
        int index = v.intKey;
        List list = adjacencyList[index];
        Node node = list.head;
        while(node != null){//Traverse all vertex in adj. List
            if(!this.vertexList[node.vertexIndex].visited){
                this.Explore(this.vertexList[node.vertexIndex]);// Recursively explore every node for a particular list
            }
            node = node.next;//Go to next node
        }
    }
    
}
