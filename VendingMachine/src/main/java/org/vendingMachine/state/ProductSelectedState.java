package org.vendingMachine.state;

import org.vendingMachine.Product;
import org.vendingMachine.VendingMachine;

public class ProductSelectedState implements VendingMachineState{
    VendingMachine machine;
    public ProductSelectedState(VendingMachine machine){
        this.machine = machine;
    }

    @Override
    public void selectProduct(String productId) {
        throw new IllegalStateException("Product already selected");
    }

    @Override
    public void insertCoin(int amount) {
        if(amount <=0){
            throw  new IllegalArgumentException("Invalid Amount");
        }
        machine.addMoney(amount);
        System.out.println(machine.getInsertedAmount() +" is your total amount");
        int cost = machine.getSelectedProduct().getPrice();
        if(this.machine.getInsertedAmount() >= cost){
            machine.setCurrentState(machine.getDispensingState());
            this.machine.dispense();
        }


    }

    @Override
    public void dispense() {
        throw new IllegalStateException("insert Coin first");
    }

    @Override
    public void cancel() {
        int refundMoney = machine.refund();
        System.out.println("Cancelled refunding amount: "+refundMoney);
        machine.clearSelection();
        machine.setCurrentState(machine.getIdleState());
    }
}
