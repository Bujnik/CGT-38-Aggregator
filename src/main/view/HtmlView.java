package main.view;

import main.Controller;
import main.vo.JobPosting;

import java.util.List;

public class HtmlView implements View{
    private Controller controller;

    @Override
    public void update(List<JobPosting> jobPostings) {

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
