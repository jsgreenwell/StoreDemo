package inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodInventory extends InventoryControl {
  // Here we need to load our food inventory options from "foodstuff"

  // Uses List from parent class (items)

  // load basic constructor (inherited from parent)
  public FoodInventory() throws IOException {
    super();
  }

  /**
   * Overrides the loadInventory method such that we are loading a food inventory
   */
  @Override
  protected void loadInventory() {
    try {
      FileReader reader = new FileReader("src/foodstuff.txt");
      BufferedReader bReader = new BufferedReader(reader);

      String line = "";
      while ((line = bReader.readLine()) != null) {
        items.add(line.toLowerCase());
      }

      reader.close();
    } catch (FileNotFoundException ex) {

      System.out.println("File does not exist: " + ex.getStackTrace());
    } catch (IOException e) {
      System.out.println("Problem reading file: " + e.getStackTrace());
    }
  }
}