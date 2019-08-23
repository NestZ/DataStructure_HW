/* HW2
 * Due: 1 September 2019
 * Problem Header Hash Code: 806f953a5cf5e8367532b7cf7f94a463
*/ 
package hw2;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        DynamicArray var1 = new DynamicArray(2);
        for(int i = 0;i < 10;i++){
            var1.pushBack(i*i + 1);
        }
        var1.printStructure();
        System.out.println(var1.get(10));
        var1.set(10,555);
        var1.remove(10);
        var1.printStructure();
    }
    
}
