package ru.javarush.cryptoanalyser.dobrov.commands;

import ru.javarush.cryptoanalyser.dobrov.constants.Strings;
import ru.javarush.cryptoanalyser.dobrov.entity.Result;
import ru.javarush.cryptoanalyser.dobrov.entity.ResultCode;
import ru.javarush.cryptoanalyser.dobrov.util.PathFinder;

import java.io.*;

public class Decoder implements Action{
    @Override
    public Result execute(int key) {
        //TODO need dev logic decrypt
        String alphabet = Strings.ALPHABET;

        String path = PathFinder.getRoot() + "encrypt.txt";
        String decryptPath = PathFinder.getRoot() + "decrypt.txt";

        try (Reader reader = new FileReader(path);
             Writer writer = new FileWriter(decryptPath)

        ) {

            while (reader.ready()) {
                int originalChar = reader.read();
                char origChar = (char) originalChar;
                if (alphabet.indexOf(originalChar) != -1) {
                    if (origChar == '\n') {
                        writer.write("\n");
                    } else {
                        int oc = origChar - 'а';
                        int decryptedChar = oc - key;
                        char newCharacter = (char) ('а' + decryptedChar);
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
