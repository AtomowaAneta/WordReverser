package main;

import java.util.Scanner;

/**
 * Created by Marcin_Styczen on 2016-11-28.
 */
public class MainClass {


    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        WordReverser wordReverser = new WordReverser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give path to file...");
        String userInput = scanner.nextLine();
        fileHandler.readFromFileName(userInput);
        System.out.println(wordReverser.reverseWordsFromFile(fileHandler.readFromFileName(userInput)));
    }
}
