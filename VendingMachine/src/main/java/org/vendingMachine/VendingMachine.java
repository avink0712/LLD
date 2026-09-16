package org.vendingMachine;

import org.vendingMachine.state.DispensingState;
import org.vendingMachine.state.IdleState;
import org.vendingMachine.state.ProductSelectedState;
import org.vendingMachine.state.VendingMachineState;

public class VendingMachine {
    private final Inventory inventory;
    private Product selectedProduct;
    private  int insertedAmount;

    //private  VendingMachineState state;
    private  VendingMachineState idleState;
    private  VendingMachineState productSelectState;
    private  VendingMachineState dispensingState;
    private VendingMachineState currentState;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.selectedProduct = null;
        this.insertedAmount = 0;

        this.idleState = new IdleState(this);
        this.productSelectState = new ProductSelectedState(this);
        this.dispensingState = new DispensingState(this);
        this.currentState = idleState;
    }


    public Inventory getInventory() {
        return inventory;
    }


    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }


    public void setSelectedProduct(Product selectedProductId) {
        this.selectedProduct = selectedProductId;
    }

    public void setInsertedAmount(int insertedAmount) {
        this.insertedAmount = insertedAmount;
    }

    public void selectProduct(String productId){
        currentState.selectProduct(productId);
    }
    public void insertAmount(int amount){
        currentState.insertCoin(amount);
    }
    public void dispense(){
        currentState.dispense();
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getProductSelectState() {
        return productSelectState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public void addMoney(int amt){
        this.insertedAmount+=amt;
    }
    public int refund(){
        int refundAmt = insertedAmount;
        this.insertedAmount = 0;
        return refundAmt;
    }
    public void clearSelection(){
        selectedProduct = null;
    }

    public void cancel(){
        this.currentState.cancel();
    }
}
