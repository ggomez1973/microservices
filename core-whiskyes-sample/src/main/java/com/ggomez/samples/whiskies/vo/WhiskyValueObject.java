package com.ggomez.samples.whiskies.vo;

public class WhiskyValueObject {
    private String name;
    private boolean peated;

    public WhiskyValueObject(String name, boolean peated) {
        this.name = name;
        this.peated = peated;
    }

    public String getName() {
        return name;
    }

    public boolean isPeated() {
        return peated;
    }
}
