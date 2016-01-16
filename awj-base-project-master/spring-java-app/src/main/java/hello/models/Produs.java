package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Produs {
  private int id;
  private String name;
  private double price;

  public Produs(int id, String name, double price) {
    this.name = name;
    this.id = id;
    this.price = price;
  }

  public Produs() {
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
    this.name = name;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  

}
