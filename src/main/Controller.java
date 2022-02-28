package main;

import main.model.Provider;

import java.util.Arrays;

public class Controller {
    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}