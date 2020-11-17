package inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryControl {
  // Here we need to load our inventory from our inventory file: How can we do that?
  // By READING it from a file

  // List to hold all my inventory items
  protected List<String> items = new ArrayList<>();
  // Now we still want the list but also need our own Map in some versions so adding
  Map<String, Integer> itemsQty = new HashMap<>();

  // load our Inventory on start
  public InventoryControl() {
    loadInventory();
  }

  protected void loadInventory() { }

  // Leave the standard version for our Foodstuffs and most others
  public boolean findItem(String itemToFind) {
    return items.contains(itemToFind);
  }

  public void printInventory() {
    if (items.size() < 1) {
      System.out.println("Inventory not loaded.");
    } else {
      System.out.println("Inventory contains: ");
      for (String i : items) {
        System.out.println(i);
      }
    }
  }

}