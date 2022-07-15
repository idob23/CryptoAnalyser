package ru.javarush.cryptoanalyser.dobrov.view;

import ru.javarush.cryptoanalyser.dobrov.exception.ApplicationException;

import java.util.Scanner;

public class ConsoleRun {

    private String command;
  private int key;
    public void runConsole() {
        Scanner scanner = new Scanner(System.in);
        int firstChoice;

        System.out.println("Выберите один из вариантов : ");
        System.out.println("1. Encode.");
        System.out.println("2. Decode.");
        System.out.println("3. BruteForce.");
        System.out.println("4. Analyse.");

        firstChoice = Integer.parseInt(scanner.nextLine());
        switch (firstChoice) {
            case 1 -> command = "encode";
            case 2 -> command = "decode";
            case 3 -> command = "BruteForce";
            case 4 -> command = "Analyse";
            default ->
                System.out.println("Промахнулись, введите ещё раз: ");

        }

        System.out.println("Введите ключ : ");
        try {
            key = Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException e) {
            throw new ApplicationException("Не число. Введите ещё раз : ");
        }

        }


    public String getCommand() {
        return command;
    }

    public int getKey() {
        return key;
    }
}
