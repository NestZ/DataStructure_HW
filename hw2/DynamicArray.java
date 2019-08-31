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
        if(size == capacity){//Expand Space of Array
            capacity *= 2;
            int [] newArr = new int[capacity];//Create temp array
            for(int i = 0;i < size;i++){//Copy elements to new array
                newArr[i] = arr[i];
            }
            arr = newArr;//Change reference to new array
        }
        arr[size] = data;//Set data
        size++;//Increase size's value
    }
    public int popBack(){
        if(size > 0)return arr[--size];//Check if size in range and return last element and decrease size's value
        else System.out.println("ERROR");//Error
        return 0;
    }

    public int get(int i){
        if(i < size && i >= 0)return arr[i];//Return element at index i
        else System.out.println("ERROR");//Error
        return 0;
    }
    public void set(int i, int value){
        if(i < size && i >= 0)arr[i] = value;//Set element at index i
        else System.out.println("ERROR");
    }
    
    public void remove(int i){
        if(i < size && i >= 0){
            for(int j = i;j < size - 1;j++)arr[j] = arr[j + 1];//Delete element at index i and shift elements in array
            size--;
        }
        else System.out.println("ERROR");
    }
    
    public boolean isEmpty(){
        if(size == 0)return true;//Check array's size
        return false;
    }
    
    public int getSize(){
        return size;//return array's size
    }
    
    public void printStructure(){//Just print :)
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
        for(int i = 0;i < size;i++){
            if(i != 0)System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.print(" ]\n");
    }
}
