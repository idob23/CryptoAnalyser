package ru.javarush.cryptoanalyser.dobrov;

import ru.javarush.cryptoanalyser.dobrov.toplevel.Application;
import ru.javarush.cryptoanalyser.dobrov.controller.MainController;
import ru.javarush.cryptoanalyser.dobrov.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        //encode text.txt encoded.txt 45
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);

    }
}
