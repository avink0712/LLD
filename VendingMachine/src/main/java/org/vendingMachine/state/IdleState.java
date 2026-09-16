package org.vendingMachine.state;

import org.vendingMachine.Product;
import org.vendingMachine.VendingMachine;

public class IdleState implements VendingMachineState{
    VendingMachine machine;
    public IdleState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productId) {
        Product product = machine.getInventory().getProduct(productId);
        if(product == null){
            throw new IllegalStateException("Product unavailable");
        }
        if(!machine.getInventory().isAvailable(productId)){
            throw new IllegalStateException("Product out of stock");
        }
        machine.setSelectedProduct(product);
        System.out.println(product.getProductName() + " selected");
        machine.setCurrentState(machine.getProductSelectState());

    }

    @Override
    public void insertCoin(int amount) {
        throw new IllegalStateException("Select Product first");

    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Select Product first");
    }

    @Override
    public void cancel() {
        //nothing..
    }


}
