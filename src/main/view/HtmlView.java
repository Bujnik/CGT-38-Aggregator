package main.view;

import main.Controller;
import main.vo.JobPosting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath = "./src/" +
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
            updateFile(newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContents(List<JobPosting> list){
        return null;
    }


    private void updateFile(String s){
        try (FileOutputStream fos = new FileOutputStream(filePath)){
            fos.write(s.getBytes(StandardCharsets.UTF_8));
        }
        catch (IOException ignored){
        }
    }


    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void emulateCitySelection(){
        controller.onCitySelected("Odessa");
    }
}
