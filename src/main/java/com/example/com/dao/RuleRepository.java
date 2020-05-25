package com.example.com.dao;

import com.example.com.entities.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface RuleRepository extends JpaRepository<Rule, Long> {
}


