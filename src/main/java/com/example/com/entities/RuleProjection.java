package com.example.com.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "ruleNotation",types={Rule.class})
public interface RuleProjection {
    Long getId();
    String getName();
    String getAction();
    List<Conditions> getConditions();

}
