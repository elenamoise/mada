package hello.controllers;

import hello.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class AnimalController {
  private List<Animal> animals = new ArrayList<Animal>();

  AnimalController() {
    Animal p1 = new Animal(1, 12,"Giraffe");
    Animal p2 = new Animal(2,13, "Elephant");
    Animal p3 = new Animal(3,11, "Tiger");

    animals.add(p1);
    animals.add(p2);
    animals.add(p3);
  }

  @RequestMapping(value="/animal", method = RequestMethod.GET)
  public List<Animal> index() {
    return this.animals;
  }

  @RequestMapping(value="/animal/{number}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("number") int number) {
    for(Animal p : this.animals) {
      if(p.getNumber() == number) {
        return new ResponseEntity<Animal>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }




@RequestMapping(value="/animal/", method = RequestMethod.POST)
  public ResponseEntity create() {

Animal p = new Animal(10,12,"Lion");
  this.animals.add(p);
        return new ResponseEntity<Animal>(p, new HttpHeaders(), HttpStatus.OK);
    

  }


  @RequestMapping(value="/animal/{number}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("number") int number) {
    for(Animal p : this.animals) { 
      if(p.getNumber() == number) { p.setName("Zebra");
        return new ResponseEntity<Animal>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/animal/{number}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("number") int number) {
    for(Animal p : this.animals) {
      if(p.getNumber() == number) {
        this.animals.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



}