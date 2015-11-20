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
public class PersonController {
  private List<Person> persons = new ArrayList<Person>();

  PersonController() {
    Person p1 = new Person(1, "John");
    Person p2 = new Person(2, "Paul");
    Person p3 = new Person(3, "Paul");

    persons.add(p1);
    persons.add(p2);
    persons.add(p3);
  }

  @RequestMapping(value="/person", method = RequestMethod.GET)
  public List<Person> index() {
    return this.persons;
  }

  @RequestMapping(value="/person/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Person p : this.persons) {
      if(p.getId() == id) {
        return new ResponseEntity<Person>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }




@RequestMapping(value="/person/", method = RequestMethod.POST)
  public ResponseEntity create() {

Person p = new Person(10,"John");
  this.persons.add(p);
        return new ResponseEntity<Person>(p, new HttpHeaders(), HttpStatus.OK);
    

  }



 

  @RequestMapping(value="/person/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Person p : this.persons) { 
      if(p.getId() == id) { p.setName("John");
        return new ResponseEntity<Person>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/person/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Person p : this.persons) {
      if(p.getId() == id) {
        this.persons.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


}