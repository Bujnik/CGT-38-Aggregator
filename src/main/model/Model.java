package main.model;

import main.view.View;
import main.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    Provider[] providers;

    public Model(View view, Provider... providers) {
        if (providers == null || providers.length == 0) throw new IllegalArgumentException();
        if (view == null) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<JobPosting> list = new ArrayList<>();
        for (Provider provider : providers) {
            list.addAll(provider.getJavaJobPostings(city));
        }
        view.update(list);
    }
}
