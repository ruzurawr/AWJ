package hello.controllers;

import hello.models.Produs;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ProdusController {
  private List<Produs> produse = new ArrayList<Produs>();

  ProdusController() {
    Produs p1 = new Produs(1, "lapte", 4.99);
    Produs p2 = new Produs(2, "paine", 0.98);
    Produs p3 = new Produs(3, "faina", 2.53);

    produse.add(p1);
    produse.add(p2);
    produse.add(p3);
  }

  @RequestMapping(value="/produs", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.produse;
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        this.produse.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/produs/{id}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id) {
    for(Produs p : this.produse) {
      if(p.getId() == id) {
        p.setId(23);
        p.setName("ciocolata");
		p.setPrice(5.46);
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/produs/{id}/{nume}/{pret}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("id") int id, @PathVariable("nume") String nume, @PathVariable("pret") float pret) {
    Produs p = new Produs(id, nume, pret);
    produse.add(p);
    return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/produs", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Produs p4) {
    produse.add(p4);
    return new ResponseEntity<Produs>(p4, new HttpHeaders(), HttpStatus.OK);
  }
  @RequestMapping(value="/produs/{initialId}/{id}/{name}/{pret}", method = RequestMethod.PUT)
  public ResponseEntity modify(@PathVariable("initialId") int initialId, @PathVariable("id") int id, @PathVariable("name") String name,
                               @PathVariable("pret") double pret) {
    for(Produs p : this.produse) {
      if(p.getId() == initialId) {
        p.setId(id);
        p.setName(name);
        p.setPrice(pret);
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}