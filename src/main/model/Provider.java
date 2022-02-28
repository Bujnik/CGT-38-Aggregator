package main.model;

/**
 * This class represents a generalization of how job posting data is retrieved.
 */
public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
