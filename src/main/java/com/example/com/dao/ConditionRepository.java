package com.example.com.dao;


import com.example.com.entities.Conditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ConditionRepository extends JpaRepository<Conditions,Long> {
}
