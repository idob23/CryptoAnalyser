package ru.javarush.cryptoanalyser.dobrov.commands;

import ru.javarush.cryptoanalyser.dobrov.constants.Strings;
import ru.javarush.cryptoanalyser.dobrov.entity.Result;
import ru.javarush.cryptoanalyser.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyser.dobrov.exception.ApplicationException;
import ru.javarush.cryptoanalyser.dobrov.util.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Encoder implements Action {
    @Override
    public Result execute(int key) {
        //TODO need dev logic encrypt

        String alphabet = Strings.ALPHABET;

        String path = PathFinder.getRoot() + "text.txt";
        String encryptPath = PathFinder.getRoot() + "encrypt.txt";

        try (Reader reader = new FileReader(path);
             Writer writer = new FileWriter(encryptPath)

        ) {

            while (reader.ready()) {
                int originalChar = reader.read();
                char origChar = (char) originalChar;
                if (alphabet.indexOf(originalChar) != -1) {
                    if (origChar == '\n') {
                        writer.write("\n");
                    } else {
                        int oc = origChar - 'а';
//                        return cipher(message, 26 - (offset % 26));
                        int encryptedChar = oc + key;
                        char newCharacter = (char) ('а' + encryptedChar);
                        writer.write(newCharacter);
                    }

                }
            }

        } catch (IOException e) {
            throw new ArithmeticException(e.getMessage());
        }


        return new Result(ResultCode.OK, "read all bytes " + path);

    }
}
