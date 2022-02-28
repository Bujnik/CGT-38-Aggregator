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
        int sum = 0;
        for (Provider provider : providers) {
            if (provider != null) {
                List<JobPosting> tempList = provider.getJavaJobPostings("java");
                list.addAll(tempList);
                sum += tempList.size();
            }
        }
        System.out.println(sum);
    }
}
