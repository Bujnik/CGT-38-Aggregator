package main;

import main.model.LinkedinStrategy;
import main.model.Provider;
import main.model.Strategy;

public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(new LinkedinStrategy());
        Controller controller = new Controller(provider);

        controller.scan();

    }
}
