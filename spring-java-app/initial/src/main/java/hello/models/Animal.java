package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Animal {
  private String name;
  private int age;
  private int number;

  public Animal() {}

  public Animal(int number,int age, String name) {
      this.name = name;
      this.age = age;
      this.number=number;
  }

  public String getName() {
      return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public  int getNumber(){
    return this.number;
  }

public void setName(String Name) {
	this.name=Name;
    
  }
}