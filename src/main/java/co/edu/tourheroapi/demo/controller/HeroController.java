package co.edu.tourheroapi.demo.controller;

import co.edu.tourheroapi.demo.model.Hero;
import co.edu.tourheroapi.demo.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hero>> getHeroes(){
        List<Hero> heroes = new ArrayList<>();

        try {
         heroes = heroService.getHeroes();
        }catch (Exception ex){
            return  new ResponseEntity<>(heroes, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> getHeroById(@PathVariable("id") Integer id){
      Hero hero = null;
      try {
        hero = heroService.getHeroeById(id);
      }catch (Exception ex){
          return  new ResponseEntity<>(hero, HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return  new ResponseEntity<>(hero, HttpStatus.OK);
    }
    @GetMapping(value = "/buscar/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Hero>> getHeroById(@PathVariable("name") String name){
        List<Hero> hero = null;
        System.out.println("buscar "+name);
        try {

            hero = heroService.getHeroeByName(name);
            System.out.println(hero.size());
        }catch (Exception ex){
            return  new ResponseEntity<>(hero, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @PostMapping(value = "/crear/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hero> save(@RequestBody Hero hero){
        Hero resultado = null;
        try{
            resultado = heroService.save(hero);
        }catch (Exception ex){
            return new ResponseEntity<>(resultado,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(resultado,HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateHeroe(@RequestBody Hero hero){
        Integer resultado = 0;
        try {
            resultado = heroService.update(hero);
        }catch (Exception ex){
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado,HttpStatus.OK);
    }

    @DeleteMapping(value = "/borrar/{id}")
    public ResponseEntity<Integer> deleteHero(@PathVariable("id") Integer id){
        Integer resultado = 0;
        try{
            resultado = heroService.delete(id);
        }catch (Exception ex){
            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado,HttpStatus.OK);
    }
}
