package com.example.celikoor_RESTful.service;

import com.example.celikoor_RESTful.entity.Actor;
import com.example.celikoor_RESTful.exception.ActorNotFoundException;
import com.example.celikoor_RESTful.repository.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
    public Actor getActorById(int id) {
        Optional<Actor> tempActor = actorRepository.findById(id);
        if(tempActor.isEmpty()){throw new ActorNotFoundException("Player with id "+ id + " not found.");}
        return tempActor.get();
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(int id, Actor actor) {
        Optional<Actor> tempActor = actorRepository.findById(id);
        if(tempActor.isPresent()) {
            tempActor.get().setName(actor.getName());
            tempActor.get().setBirthDate(actor.getBirthDate());
            tempActor.get().setGender(actor.getGender());
            tempActor.get().setNationality(actor.getNationality());
            return actorRepository.save(tempActor.get());
        }
        throw new ActorNotFoundException("Player with id "+ id + " not found.");
    }


    public Actor patchActor(int id, Map<String, Object> pActor) {
        Optional<Actor> actor = actorRepository.findById(id);

        if(actor.isEmpty()){throw new ActorNotFoundException("Player with id "+ id + " not found.");}

        pActor.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Actor.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, actor.get(), value);
        });
        return actorRepository.save(actor.get());

    }
    @Transactional
    public void updateName(int id, String name) {
        Optional<Actor> tempActor = actorRepository.findById(id);
        if(tempActor.isEmpty()){throw new ActorNotFoundException("Player with id "+ id + " not found.");}
        actorRepository.updateTitles(id, name);
    }

    public String deleteActor(int id) {
        Optional<Actor> tempActor = actorRepository.findById(id);
        if(tempActor.isEmpty()){throw new ActorNotFoundException("Actor with id "+ id + " not found.");}
        actorRepository.deleteById(id);
        return "Actor with id " + id + " deleted";
    }
}
