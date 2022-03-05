package main.view;

import main.Controller;
import main.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" +
            this.getClass()
                    .getPackage()
                    .toString()
                    .split(" ")[1]
                    .replaceAll("\\.", "/")
            + "/"
            + "jobPostings.html";

    @Override
    public void update(List<JobPosting> jobPostings) {
        try {
            String newContent = getUpdatedFileContents(jobPostings);
            assert newContent != null;
            updateFile(newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method I took from codegym as I don't have testing ability for this one
     */
    private String getUpdatedFileContents(List<JobPosting> vacancies) {
        try {
            Document doc = getDocument();
            Elements templateHidden = doc.getElementsByClass("template");
            Element template = templateHidden.clone().removeAttr("style").removeClass("template").get(0);

            //remove all prev vacancies
            Elements prevVacancies = doc.getElementsByClass("vacancy");

            for (Element redundant : prevVacancies) {
                if (!redundant.hasClass("template")) {
                    redundant.remove();
                }
            }

            //add new vacancies
            for (JobPosting vacancy : vacancies) {
                Element vacancyElement = template.clone();

                Element vacancyLink = vacancyElement.getElementsByAttribute("href").get(0);
                vacancyLink.appendText(vacancy.getTitle());
                vacancyLink.attr("href", vacancy.getUrl());
                Element city = vacancyElement.getElementsByClass("city").get(0);
                city.appendText(vacancy.getCity());
                Element companyName = vacancyElement.getElementsByClass("companyName").get(0);
                companyName.appendText(vacancy.getCompanyName());

                templateHidden.before(vacancyElement.outerHtml());
            }
            return doc.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }

    private void updateFile(String s){
        try (FileOutputStream fos = new FileOutputStream(filePath)){
            fos.write(s.getBytes(StandardCharsets.UTF_8));
        }
        catch (IOException ignored){
        }
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }


    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void emulateCitySelection(){
        controller.onCitySelected("Odessa");
    }
}
