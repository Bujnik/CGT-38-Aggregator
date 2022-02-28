package main;

import main.model.LinkedinStrategy;
import main.model.Model;
import main.model.Provider;
import main.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Model model = new Model(view, new Provider(new LinkedinStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);

        view.emulateCitySelection();

    }
}
