package org.vendingMachine.state;

import org.vendingMachine.Product;

public interface VendingMachineState {

     void selectProduct(String productId);
     void insertCoin(int amount);
     void dispense();
     void cancel();
}
