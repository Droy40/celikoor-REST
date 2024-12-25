package com.example.celikoor_RESTful.repository;


import com.example.celikoor_RESTful.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Modifying
    @Query("update actors a set a.name = :name where a.id = :id")
    void updateTitles(@Param("id") int id, @Param("name") String name);
}
