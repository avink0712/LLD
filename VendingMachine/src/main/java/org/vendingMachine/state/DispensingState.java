package org.vendingMachine.state;

import org.vendingMachine.Product;
import org.vendingMachine.VendingMachine;

public class DispensingState implements VendingMachineState{
    VendingMachine machine;
    public DispensingState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productId) {
        throw new IllegalStateException("Select Product first");

    }

    @Override
    public void insertCoin(int amount) {
        throw new IllegalArgumentException("Dispensing product");

    }

    @Override
    public void dispense() {
        Product product = machine.getSelectedProduct();
        if(!machine.getInventory().remove(product.getProductId())){
            machine.setCurrentState(machine.getIdleState());
            machine.clearSelection();
            machine.refund();
            throw new IllegalStateException("Product out of stock");
        }
        System.out.println("please collect your product: " + machine.getSelectedProduct().getProductName());
        machine.setInsertedAmount(machine.getInsertedAmount() - product.getPrice());
        if( machine.getInsertedAmount() >0)
        {
            System.out.println(" Refunding amount: "+ machine.getInsertedAmount());
        }
        machine.refund();
        machine.clearSelection();
        machine.setCurrentState(machine.getIdleState());
    }

    @Override
    public void cancel() {
        throw new IllegalStateException(" Cannot cancel, dispensing in progress");
    }
}
