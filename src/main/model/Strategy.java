package main.model;

import main.vo.JobPosting;

import java.util.List;

public interface Strategy {
    List<JobPosting> getJobPostings(String searchString);
}
