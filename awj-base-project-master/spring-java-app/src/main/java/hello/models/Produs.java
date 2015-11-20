package hello;

import java.util.List;
import java.util.ArrayList;

public class Produs {
  private String name;
  private int id;
  private float price;

  public Categorie() {}

  public Categorie(int id, String name, float price) {
      this.name = name;
      this.id = id;
	  this.price = price;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  
  public float getPrice() {
    return this.price;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setPrice(float price) {
    this.price = price;
  }
}
