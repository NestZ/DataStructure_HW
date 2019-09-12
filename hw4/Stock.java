/* HW4
 * Due: 22 September 2019
 * Problem Header Hash Code: 2a97a54351021e684c6ed55619e8aa6a
*/ 
package hw4;

public class Stock {
    private List list;
    private int totalShares;
    
    public Stock(String costBasis){
        switch(costBasis){
            case "FIFO":
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }
    
    public void buy(int boughtShares, double boughtPrice){
        list.push(new Node(boughtShares,boughtPrice));
        totalShares += boughtShares;
    }
    
    public void sell(int soldShares, double soldPrice){
        if (soldShares <= totalShares){
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;
            
            totalShares -= soldShares;//Delete current shares
            while(soldShares > 0){//Keep selling until all shares sold
                Node temp = list.top();
                if(temp.shares <= soldShares){//Check if you can sell all shares in that node
                    realizedGain += (soldPrice - temp.price) * temp.shares;//Increase realizedGain
                    soldShares -= temp.shares;
                    list.pop();//Pop sold node
                }
                else{
                    realizedGain += (soldPrice - temp.price) * soldShares;//Increase realizedGain
                    temp.shares -= soldShares;//Delete shares that were sold in that node
                    soldShares = 0;//Reset soldShares because all shares were sold
                }
            }
            Node curr = list.top();//Set Node to traverse list
            while(curr != null){//Linked list traversal
                unrealizedGain += (soldPrice - curr.price) * curr.shares;//Increase unrealizedGain
                curr = curr.next;
            }
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
        }
        else{
            System.out.println("Sell command rejected");
        }
    }
    
    public void showList(){
        Node currentNode = list.top();
        System.out.print("head -> ");
        while(currentNode!=null){
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}