/* HW6
 * Due: 20 October 2019
 * Problem Header Hash Code: 80ccb30754443710a07db3a4c52d1212
*/ 
package hw6;

/**
 *
 * @author Patiwet
 */
public class List {
    Node [] arr;
    int capacity;
    int size;
    
    public List(int cap){
        arr = new Node[cap];
        capacity = cap;
    }
    
    public void append(Node node){
        if (size<capacity){
            arr[size] = node;
            size++;
        }
    }
    
    public void printList(){
        System.out.print("[Head] ");
        for (int i=0; i<size; i++){
            System.out.print(arr[i].key + " ");
        }
        System.out.print("[Tail] ");
    }
}
