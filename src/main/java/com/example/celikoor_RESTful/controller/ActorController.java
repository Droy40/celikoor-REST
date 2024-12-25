package com.example.celikoor_RESTful.controller;

import com.example.celikoor_RESTful.entity.Actor;
import com.example.celikoor_RESTful.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/actor")
    public List<Actor> getActor() {
        return actorService.getAllActors();
    }
    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }
    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }
    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable int id ,@RequestBody Actor actor) {
        return actorService.updateActor(id, actor);
    }
    @PatchMapping("/actor/{id}")
    public Actor partialUpdate( @PathVariable int id,
                                 @RequestBody Map<String, Object> actorPatach) {
        return actorService.patchActor(id, actorPatach);
    }
    @PatchMapping("/actor/{id}/name")
    public void updateName( @PathVariable int id,
                                @RequestBody String name) {
        actorService.updateName(id, name);
    }
    @DeleteMapping("/actor/{id}")
    public String deleteActor(@PathVariable int id) {
        return actorService.deleteActor(id);
    }
}
