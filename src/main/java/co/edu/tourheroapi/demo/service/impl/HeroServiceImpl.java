package co.edu.tourheroapi.demo.service.impl;

import co.edu.tourheroapi.demo.model.Hero;
import co.edu.tourheroapi.demo.repository.HeroRepository;
import co.edu.tourheroapi.demo.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<Hero> getHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHeroeById(Integer id) {
        return heroRepository.findById(id).orElse(null);
    }

    @Override
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public Integer update(Hero hero) {
        return heroRepository.save(hero).getId();
    }

    @Override
    public Integer delete(Integer id) {
        try {
            heroRepository.deleteById(id);
            return 1;
        }catch (Exception ex){
            return 0;
        }
    }

    @Override
    public List<Hero> getHeroeByName(String name) {
        return heroRepository.findByNameLike("%"+name+"%");
    }
}
