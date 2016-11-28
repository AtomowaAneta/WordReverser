package main;

import java.io.BufferedReader;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Marcin_Styczen on 2016-11-28.
 */
public class WordReverser {
    FileHandler fileHandler = new FileHandler();
    public String reverseWords(String toReverse) {
        ArrayList wordList = new ArrayList();

           for (String token: toReverse.split(" ")){
               if (token=="\n"){
                   wordList.add("\n");
               }
               else {

                   wordList.add(token);
               }
           }

        Collections.reverse(wordList);
        return wordList.toString();
    }

    public String reverseWordsFromFile(List linesFromFileList) {
        String line1 = " ";
        ArrayList reversedTextArrayList = new ArrayList();


            for (Object line: linesFromFileList){
                line1 = reverseWords((String) line).replace(",","");
                reversedTextArrayList.add(line1.replaceAll("\\[", "").replaceAll("\\]",""));
            }
        fileHandler.saveOutputToFile(reversedTextArrayList.toString());
        return reversedTextArrayList.toString();
    }



}
