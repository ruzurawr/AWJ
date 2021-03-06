package hello.controllers;

import hello.models.Film;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class FilmController {
  private List<Film> filme = new ArrayList<Film>();

  FilmController() {
    Film f1 = new Film(1, "Matrix", 1998);
    Film f2 = new Film(2, "Titanic", 2000);
    Film f3 = new Film(3, "The Hobbit", 2012);

    filme.add(f1);
    filme.add(f2);
    filme.add(f3);
  }

  @RequestMapping(value="/film", method = RequestMethod.GET)
  public List<Film> index() {
    return this.filme;
  }

  @RequestMapping(value="/film/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Film f : this.filme) {
      if(f.getId() == id) {
        return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/film/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Film f : this.filme) {
      if(f.getId() == id) {
        this.filme.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  @RequestMapping(value="/film/{id}", method = RequestMethod.PUT)
  public ResponseEntity put(@PathVariable("id") int id) {
    for(Film f : this.filme) {
      if(f.getId() == id) {
        f.setId(10);
        f.setName("Amelie");
		f.setYear(2005);
        return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/film/{id}/{nume}/{an}", method = RequestMethod.POST)
   public ResponseEntity post(@PathVariable("id") int id, @PathVariable("nume") String nume, @PathVariable("an") int an) {
    Film f = new Film(id, nume, an);
    filme.add(f);
    return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
  }

  @RequestMapping(value="/film", method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody Film f4) {
    filme.add(f4);
    return new ResponseEntity<Film>(f4, new HttpHeaders(), HttpStatus.OK);
  }
  @RequestMapping(value="/film/{initialId}/{id}/{name}/{year}", method = RequestMethod.PUT)
  public ResponseEntity modify(@PathVariable("initialId") int initialId, @PathVariable("id") int id, @PathVariable("name") String name,
  @PathVariable("year") int year) {
    for(Film f : this.filme) {
      if(f.getId() == initialId) {
        f.setId(id);
        f.setName(name);
        f.setYear(year);
        return new ResponseEntity<Film>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
}

