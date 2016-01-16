package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Film {
  private int id;
  private String name;
  private int year;

  public Film() {}

  public Film(int id, String name, int year) {
      this.name = name;
      this.id = id;
	  this.year = year;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }
  
  public int getYear() {
    return this.year;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public void setId(int id) {
      this.id = id;
  }
  
  public void setYear(int year) {
      this.year = year;
  }
}
