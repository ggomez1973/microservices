package com.ggomez.samples.whiskies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Whisky {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean peated;

    public Whisky() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPeated() {
        return peated;
    }

    public void setPeated(boolean peated) {
        this.peated = peated;
    }
}
