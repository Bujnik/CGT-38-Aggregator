package main.model;

import main.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy{
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        return new ArrayList<>();
    }


}
