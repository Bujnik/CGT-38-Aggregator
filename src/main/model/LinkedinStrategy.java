package main.model;

import main.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy{
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> list = new ArrayList<>();
        String s;
        try {
            Document doc = Jsoup.connect(URL_FORMAT)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
                    .referrer("https://www.linkedin.com")
                    .get();

            s = doc.html();

        } catch (IOException e) {
            return list;
        }
        return list;
    }


}
