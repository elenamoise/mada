package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ProductController {
  private List<Product> products = new ArrayList<Product>();

  ProductController() {
    Product p1 = new Product(1,12, "milk");
    Product p2 = new Product(2,23, "water");
    Product p3 = new Product(3,44, "chocolate");

    products.add(p1);
    products.add(p2);
    products.add(p3);
  }

  @RequestMapping(value="/product", method = RequestMethod.GET)
  public List<Product> index(){
    return this.products;
  }

  @RequestMapping(value="/product/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {

    for(Product p : this.products) {
      if(p.getId() == id) {
        return new ResponseEntity<Product>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


@RequestMapping(value="/product/", method = RequestMethod.POST)
  public ResponseEntity create() {

Product p = new Product(8,12,"Bread");
  this.products.add(p);
        return new ResponseEntity<Product>(p, new HttpHeaders(), HttpStatus.OK);
    

  }



  @RequestMapping(value="/product/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable("id") int id) {
    for(Product p : this.products) { 
      if(p.getId() == id) { p.setName("VelPitar");
        return new ResponseEntity<Product>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }



  @RequestMapping(value="/product/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Product p : this.products) {
      if(p.getId() == id) {
        this.products.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  
}





