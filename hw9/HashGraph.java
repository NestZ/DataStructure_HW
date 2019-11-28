/* HW9
 * Due: 30 November 2019
 * Problem Header Hash Code: dc540e1a78521988a2e71b5dc65d7825
*/
package hw9;

public class HashGraph extends Graph{
    
    long p; // Big Prime (for PolyHash())
    long x; // Small number (for PolyHash())
    
    public HashGraph(int cap, long p, long x){
        super(cap);
        this.p = p;
        this.x = x;
    }
    
    public void addVertex(String key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to rehash");
            return;
        }
        
        // The input key will be hashed to an integer using hashCode (with PolyHash) function
        // the index number will be used to identify location of the vertex in the list
        int index = hashCode(key);
        
    // Beware that Graph has 2 constructors
        this.vertexList[index] = new Vertex(key);// Add an vertex with the key to the list 
        this.adjacencyList[index] = new List();// Create an empty list to the appropriate location in the adjacency list
        size++;// Increase the vertex counter by one
    }
    
    public void addEdge(String source, String destination){
        int sourceIndex = hashCode(source);
        int destinationIndex = hashCode(destination);
        super.addEdge(sourceIndex, destinationIndex);
    }

    public void BFS(Vertex s){
        for(Vertex v : this.vertexList){
            if(v != null){//If v is not null
                v.dist = INFINITY;// Set dist variable of all vertices to infinity
                v.prev = null;// Set prev variable of all vertices to null
            }
        }
        s.dist = 0;// Set distance of the source vertex (s) to zero
        Queue q = new Queue(cap);
        q.enqueue(s);// Push vertex s to a queue
        while(!q.isEmpty()){// Perform BFS using Queue
            Vertex v = q.dequeue();//Dequeue vertex from queue
            List list = this.adjacencyList[hashCode(v.strKey)];
            if(list == null)return;
            Node curr = list.head;
            while(curr != null){//Traverse all node in list
                if(this.vertexList[curr.vertexIndex].dist == INFINITY){//If distance is infinity
                    q.enqueue(this.vertexList[curr.vertexIndex]);//Enqueue new node
                    this.vertexList[curr.vertexIndex].dist = v.dist + 1;//Increase distance
                    this.vertexList[curr.vertexIndex].prev = v;//Set prev vertex
                }
                curr = curr.next;
            }
        }
    }
    
    public Stack getShortestPathList(Vertex S, Vertex U){
        Stack stack = new Stack(cap);
        while(U != S){
            stack.push(U);
            U = U.prev;
        }
        stack.push(S);
        return stack;
    }
    
    public void printShortestPart(String s_str, String u_str){
        // Hash the input strings and use them to index the appropriate vertices
        int s_index = this.hashCode(s_str); // Fix this, index 0 is wrong
        int u_index = this.hashCode(u_str); // Fix this, index 0 is wrong
        
        // Perform BFS starting from the source vertex
        BFS(this.vertexList[s_index]); // Fix this, index 0 is wrong
        
        // Call a function to reconstruct the shortest path list (stack)
        // Hint: the function is somewhere in this Class
        Stack stack = getShortestPathList(this.vertexList[s_index], this.vertexList[u_index]); // Fix this, replace new Stack(cap) with calling a function with appropriate parameters
        
        // Given the correct list (stack) the following code should work
        // The following code is good to go
	// Hint: Do not use u.intKey here because it is undefined, instead please use hashCode(u.strKey)
        while(!stack.isEmpty()){
            System.out.print(stack.pop().strKey+ " -> ");
        }
        System.out.println();
    }
    
    public int hashCode(String s){
        int index = (int)(HashGraph.polyHash(s,p,x) % cap);
        // check if there is a collision at this index
        // if no, just return index
        // if yes, use the quadratic probing to find an appropriate location
        // Hint: Use for loop starting from k=1 to k = cap-1
        if(vertexList[index] != null && s != vertexList[index].strKey){//Else use quadratic probing
            for(int k = 1;k < cap - 1;k++){
                index = (index + k * k) % cap;
                if(vertexList[index] == null || s == vertexList[index].strKey)break;//If index is found then break and return
            }
        }
        return index;//Return index
    }

    public static long polyHash(String s, long p, long x){
        long hash = 0;
        // Implement the poly hashing function here
        for(int i = s.length() - 1;i >= 0;i--){//Poly hashing
            hash = (hash * x + s.charAt(i)) % p;
        }
        return hash;
    }
}
