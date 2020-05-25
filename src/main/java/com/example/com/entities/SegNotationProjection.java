package com.example.com.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="segNot", types= {Segment.class})
public interface SegNotationProjection {
    Long getId();
    double getDebut();
    double getFin();
    Notation getNotation();

}
