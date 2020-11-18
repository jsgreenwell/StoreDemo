package inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ElectronicInventory extends InventoryControl {

  // Here we need to load our food inventory options from "foodstuff"

  // load basic constructor (inherited from parent)
  public ElectronicInventory() throws IOException {
    super();
  }

  /**
   * Overrides the loadInventory method such that we are loading an electronic inventory with qty
   */
  @Override
  protected void loadInventory() {
    try {
      FileReader reader = new FileReader("src/electronics.txt");
      BufferedReader bReader = new BufferedReader(reader);

      String line = "";
      while ((line = bReader.readLine()) != null) {
        // line is a String so we need to split on a string array then convert
        // also its a Map so change "add" to "put"
        String[] itemQty = line.split(",");

        /* If I also want to add it to a List for easy printing later (using our original print)
                that's where super comes in:
         */
        itemsQty.put(itemQty[0].toLowerCase(), Integer.parseInt(itemQty[1])); // no super vs. super
        super.items.add(line.toLowerCase()); // original superclass List (don't actually need super)
      }

      reader.close();
    } catch (FileNotFoundException ex) {
      log.FAILURE("File does not exist: " + ex.getStackTrace());
    } catch (IOException e) {
      log.FAILURE("Problem reading file: " + e.getStackTrace());
    }
  }

  // And change this to containsKey so need to Override - don't need both
  // Why the override? try it through super and see what happens
  @Override
  public boolean findItem(String itemToFind) {
    return itemsQty.containsKey(itemToFind);
  }

  /**
   * Returns a string representation of the map of items in inventory with quantities.
   * Cannot have this in the super class cause we don't know if a map or not
   *
   * @return a string representation of the map of items in inventory.
   */
  @Override
  public String toString() {
    String mapAsString = "Items and qtys are:\n";

    for (String k : itemsQty.keySet()) {
      mapAsString += "\t" + k + " with " + itemsQty.get(k) + "in stock\n";
    }
    return mapAsString;
  }
}
