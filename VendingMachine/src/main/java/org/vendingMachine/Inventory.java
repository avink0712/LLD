package org.vendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products;
    private final Map<String, Integer> quantity;

   public  Inventory(){
       this.products = new HashMap<>();
       this.quantity = new HashMap<>();
   }

   public Product getProduct(String id){
       return products.get(id);
   }

   public void addProduct(Product product, int qty){
       products.put(product.getProductId(), product);
       quantity.merge(product.getProductId(),qty,Integer::sum);
   }

   public boolean isAvailable(String id){
       return quantity.getOrDefault(id,0)>0;
   }

   public boolean remove(String id){
       if(!products.containsKey(id)){
           throw new IllegalArgumentException("Product doesn't exist");
       }
       if(isAvailable(id)){
           quantity.compute(id, (k, currQty) -> currQty - 1);
           return true;
       }
       return false;
   }

}
