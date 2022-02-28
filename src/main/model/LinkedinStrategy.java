package main.model;

import main.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy{
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";

    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> list = new ArrayList<>();
        try {

            //Do this until we get empty page
            for(int page = 0;;page += 25) {
                //Get document
                Document doc = getDocument(searchString, page);
                //Get elements of class jobs-search-result-item
                Elements elements = doc.getElementsByClass("jobs-search-result-item");
                if (!elements.isEmpty()) {
                    for (Element e : elements) {
                        JobPosting job = new JobPosting();
                        job.setTitle(e.getElementsByClass("listed-job-posting__title").text());
                        job.setCity(e.getElementsByClass("listed-job-posting__location").text());
                        job.setCompanyName(e.getElementsByClass("listed-job-posting__company").text());
                        job.setWebsiteName(URL_FORMAT);
                        job.setUrl(e.select("meta[itemprop=url]").first().attr("content"));
                        list.add(job);
                    }
                }
                else break;
            }


        } catch (IOException ignored) {
        }
        return list;
    }

    protected Document getDocument (String searchString, int page) throws IOException{
        //Connect using Jsoup, agent is taken from my browser, and referrer is linkedin website

        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36")
                //.referrer("https://www.linkedin.com")
                .get();
    }


}
