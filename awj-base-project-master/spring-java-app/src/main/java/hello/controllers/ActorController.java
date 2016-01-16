package hello.controllers;

import hello.models.Actor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class ActorController {
  private List<Actor> actori = new ArrayList<Actor>();

  ActorController() {
    Actor a1 = new Actor(1, "Kit");
    Actor a2 = new Actor(2, "Melissa");
    Actor a3 = new Actor(3, "Richard");

    actori.add(a1);
    actori.add(a2);
    actori.add(a3);
  }

  @RequestMapping(value="/actor", method = RequestMethod.GET)
  public List<Actor> index() {
    return this.actori;
  }

  @RequestMapping(value="/actor/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Actor a : this.actori) {
      if(a.getId() == id) {
        return new ResponseEntity<Actor>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/actor/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Actor a : this.actori) {
      if(a.getId() == id) {
        this.actori.remove(a);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/actor/{id}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id) {
    for(Actor a : this.actori) {
      if(a.getId() == id) {
        a.setId(7);
        a.setName("Casey");
        return new ResponseEntity<Actor>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/actor/{id}/{nume}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("id") int id, @PathVariable("nume") String nume) {
    Actor a = new Actor(id, nume);
    actori.add(a);
    return new ResponseEntity<Actor>(a, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/actor", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Actor a4) {
    actori.add(a4);
    return new ResponseEntity<Actor>(a4, new HttpHeaders(), HttpStatus.OK);
  }
  @RequestMapping(value="/actor/{initialId}/{id}/{name}", method = RequestMethod.PUT)
  public ResponseEntity modify(@PathVariable("initialId") int initialId, @PathVariable("id") int id, @PathVariable("name") String name) {
    for(Actor a : this.actori) {
      if(a.getId() == initialId) {
        a.setId(id);
        a.setName(name);
        return new ResponseEntity<Actor>(a, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}