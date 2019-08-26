/* HW2
 * Due: 1 September 2019
 * Problem Header Hash Code: 806f953a5cf5e8367532b7cf7f94a463
*/ 
package hw2;

public class DynamicArray {
    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1
    
    public DynamicArray(int cap){ // Class Constructor
        arr = new int[cap];
        capacity = cap;
    }
    
    public void pushBack(int data){
        // FIXED THIS
        if(size == capacity){//Expand Space of Array
            capacity *= 2;
            int [] newArr = new int[capacity];
            for(int i = 0;i < size;i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = data;
        size++;
    }
    public int popBack(){
        // FIXED THIS
        if(size > 0)return arr[--size];
        else System.out.println("ERROR");
        return 0;
    }

    public int get(int i){
        // FIXED THIS
        if(i < size && i >= 0)return arr[i];
        else System.out.println("ERROR");
        return 0;
    }
    public void set(int i, int value){
        // FIXED THIS
        if(i < size && i >= 0)arr[i] = value;
        else System.out.println("ERROR");
    }
    
    public void remove(int i){
        // FIXED THIS
        if(i < size && i >= 0){
            for(int j = i;j < size - 1;j++)arr[j] = arr[j + 1];
            size--;
        }
        else System.out.println("ERROR");
    }
    
    public boolean isEmpty(){
        // FIXED THIS
        if(size == 0)return true;
        return false;
    }
    
    public int getSize(){
        // FIXED THIS
        return size;
    }
    
    public void printStructure(){
        // FIXED THIS
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
        for(int i = 0;i < size;i++){
            if(i != 0)System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.print(" ]\n");
    }
}
