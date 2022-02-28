package main;

import main.model.Provider;
import main.vo.JobPosting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void scan() {
        ArrayList<JobPosting> list = new ArrayList<>();
        for (Provider provider : providers) {
            if (provider != null) {
                list.addAll(provider.getJavaJobPostings("San+Francisco"));
            }
        }
        System.out.println(list.size());
    }
}
