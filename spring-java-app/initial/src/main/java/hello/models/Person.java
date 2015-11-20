package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Person {
  private String name;
  private int id;

  public Person() {}

  public Person(int id, String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public int getId() {
    return this.id;
  }

public void setName(String Name) {
	this.name=Name;
    
  }
}