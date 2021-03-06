package store;

import inventory.ElectronicInventory;
import inventory.FoodInventory;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    FoodInventory inv = new FoodInventory();
    inv.printInventory();

    System.out.println();

    ElectronicInventory electricInv = new ElectronicInventory();
    electricInv.printInventory();
    System.out.println("\nOr even better formatting:\n" + electricInv.toString());

    System.out.println("I'm gonna be a store!");
  }

}
