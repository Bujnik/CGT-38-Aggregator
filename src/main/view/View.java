package main.view;

import main.Controller;
import main.vo.JobPosting;

import java.util.List;

public interface View {
    void update(List<JobPosting> jobPostings);
    void setController(Controller controller);
}
