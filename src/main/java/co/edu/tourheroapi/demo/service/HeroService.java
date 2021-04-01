package co.edu.tourheroapi.demo.service;

import co.edu.tourheroapi.demo.model.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> getHeroes();

    Hero getHeroeById(Integer id);

    Hero save(Hero hero);

    Integer update(Hero hero);

    Integer delete(Integer id);

    List<Hero> getHeroeByName(String name);
}
