package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Animal {
  private String name;
  private int age;
  private int id;

  public Animal() {}

  public Animal(int id,int age, String name) {
      this.name = name;
      this.age = age;
      this.id=id;
  }

  public String getName() {
      return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public  int getId(){
    return this.id;
  }

public void setName(String Name) {
	this.name=Name;
    
  }
}