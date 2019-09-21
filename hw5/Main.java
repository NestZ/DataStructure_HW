/* HW5
 * Due: 29 September 2019
 * Problem Header Hash Code: 6d60335d94511791b62d91647e0f8019
*/ 
package hw5;

public class Main {

    public static Node constructTree1(){
        Node sTree1 = new Node(1);
        Node sTree8 = new Node(8);
        Node sTree4 = new Node(4);

        Node sTree6 = new Node(6);
        sTree6.left = sTree1;
        sTree6.right = sTree8;

        Node sTree9 = new Node(9);
        sTree9.left = sTree4;

        Node sTree2 = new Node(2);

        Node sTree7 = new Node(7);
        sTree7.left = sTree2;
        sTree7.right = sTree6;

        Node sTree5 = new Node(5);
        sTree5.right = sTree9;

        Node root = new Node(3);
        root.left = sTree7;
        root.right = sTree5;

        return root;
    }

    public static Node constructTree2(){
        Node sTree10 = new Node(10);
        Node sTree8 = new Node(8);
        sTree8.right = sTree10;

        Node sTree7 = new Node(7);
        Node sTree9 = new Node(9);

        Node sTree5 = new Node(5);
        sTree5.left = sTree7;
        sTree5.right = sTree8;

        Node sTree6 = new Node(6);
        sTree6.left = sTree9;

        Node sTree4 = new Node(4);

        Node sTree2 = new Node(2);
        sTree2.left = sTree4;
        sTree2.right = sTree5;

        Node sTree3 = new Node(3);
        sTree3.right = sTree6;

        Node root = new Node(1);
        root.left = sTree2;
        root.right = sTree3;

        return root;
    }
    public static void main(String[] args) {
        /*Node tree = constructTree1();
        tree.printBFT();*/

        /*Node tree = constructTree1();
        tree.printBFT();*/

        /*Stack s = new Stack(4);
        s.pop();
        s.push(new Node(5));
        s.push(new Node(6));
        s.push(new Node(7));
        s.push(new Node(8));
        s.printStack();
        s.push(new Node(9));
        System.out.println(s.pop().data);
        System.out.println(s.pop().data);
        System.out.println(s.pop().data);
        s.printStack();*/

        /*Queue q = new Queue(4);
        q.dequeue();
        q.enqueue(new Node(5));
        q.enqueue(new Node(6));
        q.enqueue(new Node(7));
        q.enqueue(new Node(8));
        q.printQueue();
        q.enqueue(new Node(9));
        System.out.println(q.dequeue().data);
        System.out.println(q.dequeue().data);
        System.out.println(q.dequeue().data);
        q.printQueue();*/

        /*Queue q = new Queue(4);
        q.printCircularIndices();
        q.enqueue(new Node(5));
        q.enqueue(new Node(6));
        q.printCircularIndices();
        q.enqueue(new Node(7));
        q.enqueue(new Node(8));
        q.printCircularIndices();
        q.printQueue();
        System.out.println(q.dequeue().data);
        q.printCircularIndices();
        System.out.println(q.dequeue().data);
        q.printCircularIndices();
        System.out.println(q.dequeue().data);
        q.printCircularIndices();
        q.enqueue(new Node(9));
        q.enqueue(new Node(10));
        q.enqueue(new Node(11));
        q.printQueue();*/

        /*Node tree = constructTree1();
        tree.printTree();
        tree.printBFT();
        tree.printDFT();*/
    }
}
