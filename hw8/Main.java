/* HW8
 * Due: 16 November 2019
 * Problem Header Hash Code: ea64505d681ad8787ebab0e493c19d8b
*/ 
package hw8;

public class Main {

    public static void main(String[] args) {
        StockMarket market = new StockMarket(10, 10); // 10 investos, 10 stocks
                // Add 10 investors and the initial balance
        market.addInvestor("Thaneat", 10000); // ID=0
        market.addInvestor("Ronnachai", 10000); // ID=1
        market.addInvestor("Peerawich", 10000); // ID=2
        market.addInvestor("Apichart", 9000); // ID=3
        market.addInvestor("Piampong", 9000); // ID=4
        market.addInvestor("Phitchayarat", 9000); // ID=5
        market.addInvestor("Goravit", 8000); // ID=6
        market.addInvestor("Kittinan", 8000); // ID=7
        market.addInvestor("Waritthon", 8000); // ID=8
        market.addInvestor("Parinya", 8000); // ID=9
        // Add 10 stocks and the initial price
        market.addStock("PTT", 344);
        market.addStock("CPALL", 60.5);
        market.addStock("SCB", 144);
        market.addStock("KBANK", 170);
        market.addStock("CPF", 27.75);
        market.addStock("TRUE", 7.15);
        market.addStock("CPN", 53);
        market.addStock("BTS", 8.35);
        market.addStock("DTAC", 35.50);
        market.addStock("LH", 8.75);
        
        //market.showStockOwnership();
        market.loadSavedIPO(); // load simulatedIPO
        market.showStockOwnership();
        
        market.portfolio("Ronnachai");
        market.portfolio("Thaneat");
        
        
        // To uncomment below, you need to implement Heap
        /*
        
        market.submitSellOrder("Peerawich", "SCB", 5, 200);
        market.submitSellOrder("Goravit", "SCB", 10, 180);
        market.quote("SCB");
        
        market.submitBuyOrder("Apichart", "SCB", 6, 250);
        market.submitBuyOrder("Piampong", "SCB", 6, 250);
        
        market.portfolio("Apichart");
        market.portfolio("Piampong");
        market.portfolio("Peerawich");
        market.portfolio("Goravit");
        
        market.quote("KBANK");
        
        market.submitBuyOrder("Phitchayarat", "KBANK", 2, 90);
        market.quote("KBANK");
        
        market.submitBuyOrder("Goravit", "KBANK", 1, 85);
        market.quote("KBANK");

        market.submitBuyOrder("Kittinan", "KBANK", 3, 90);
        market.quote("KBANK");
        market.submitBuyOrder("Waritthon", "KBANK", 2, 100);
        market.quote("KBANK");
        market.submitBuyOrder("Parinya", "KBANK", 2, 80);
        market.quote("KBANK");
        

        market.submitSellOrder("Apichart", "KBANK", 2, 150);
        market.quote("KBANK");
        
        market.submitSellOrder("Apichart", "KBANK", 6, 85);
        
        market.portfolio("Apichart");
        
        market.showStockOwnership();

        market.submitSellOrder("Thaneat", "PTT", 3, 350);
        market.submitSellOrder("Thaneat", "PTT", 3, 360);
        market.submitSellOrder("Thaneat", "PTT", 4, 370);
        market.submitSellOrder("Peerawich", "PTT", 5, 355);
        market.submitSellOrder("Peerawich", "PTT", 5, 365);
        market.submitSellOrder("Peerawich", "PTT", 5, 375);
        market.submitSellOrder("Piampong", "PTT", 3, 360);
        market.submitSellOrder("Piampong", "PTT", 3, 370);
        market.submitSellOrder("Piampong", "PTT", 4, 380);
        
        market.submitBuyOrder("Ronnachai", "PTT", 6, 370);
        market.submitBuyOrder("Apichart", "PTT", 6, 370);
        market.submitBuyOrder("Phitchayarat", "PTT", 10, 370);
        market.submitBuyOrder("Goravit", "PTT", 10, 370);
        
        market.submitBuyOrder("Kittinan", "PTT", 2, 330);
        market.submitBuyOrder("Kittinan", "PTT", 2, 300);
        market.submitBuyOrder("Kittinan", "PTT", 2, 270);
        
        market.submitBuyOrder("Waritthon", "PTT", 3, 330);
        market.submitBuyOrder("Waritthon", "PTT", 3, 250);
        market.submitBuyOrder("Waritthon", "PTT", 3, 200);
        
        market.submitSellOrder("Parinya", "PTT", 3, 320);
        market.submitSellOrder("Parinya", "PTT", 3, 240);
        market.submitSellOrder("Parinya", "PTT", 4, 220);
        market.submitSellOrder("Ronnachai", "PTT", 3, 320);
        market.submitSellOrder("Ronnachai", "PTT", 3, 240);
        market.submitSellOrder("Ronnachai", "PTT", 4, 220);
        
        market.quote("PTT");
        
        market.showStockOwnership();
        
        market.portfolio("Ronnachai");
        
        market.submitBuyOrder("Thaneat", "PTT", 20, 150);
        market.submitBuyOrder("Thaneat", "PTT", 20, 100);
        market.submitBuyOrder("Thaneat", "PTT", 10, 50);
        
        market.submitSellOrder("Phitchayarat", "PTT", 10, 125);
        market.submitSellOrder("Goravit", "PTT", 10, 75);
        market.submitSellOrder("Kittinan", "PTT", 15, 75);
        market.submitSellOrder("Waritthon", "PTT", 15, 75);
        
        market.quote("PTT");
        
        market.portfolio("Ronnachai");
        */
        
        /*
        // Optinal test cases
        
        Node nodeA = new Node();
        Node nodeB = new Node();
        
        nodeA.price = 30; nodeA.timestamp = 1; nodeA.isMinHeap = true;
        nodeB.price = 20; nodeB.timestamp = 2; nodeB.isMinHeap = true;
        System.out.println("nodeA.compare(nodeB) = " + nodeA.compare(nodeB));
        System.out.println("nodeB.compare(nodeA) = " + nodeB.compare(nodeA));
        
        nodeA.price = 30; nodeA.timestamp = 1; nodeA.isMinHeap = false;
        nodeB.price = 20; nodeB.timestamp = 2; nodeB.isMinHeap = false;
        System.out.println("nodeA.compare(nodeB) = " + nodeA.compare(nodeB));
        System.out.println("nodeB.compare(nodeA) = " + nodeB.compare(nodeA));
        
        nodeA.price = 100; nodeA.timestamp = 1; nodeA.isMinHeap = true;
        nodeB.price = 100; nodeB.timestamp = 2; nodeB.isMinHeap = true;
        System.out.println("nodeA.compare(nodeB) = " + nodeA.compare(nodeB));
        System.out.println("nodeB.compare(nodeA) = " + nodeB.compare(nodeA));
*/
    }
    
}
