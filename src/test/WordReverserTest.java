package test;

import main.FileHandler;
import main.WordReverser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Marcin_Styczen on 2016-11-28.
 */
public class WordReverserTest {

    @Test
    public void ifTwoWordCanBeReversed (){
        String test = "kotek młotek";
        List testArrayList = new ArrayList();
        testArrayList.add("młotek");
        testArrayList.add("kotek");
        WordReverser wordReverser = new WordReverser();
        String result = wordReverser.reverseWords(test);

        Assert.assertEquals(result,testArrayList.toString());
    }
    @Test
    public void ifWholeLineCanBeReversed() {
        String test = "I przykre miastu jesienne potopy,";
        List testArrayList = new ArrayList();
        testArrayList.add("potopy,");
        testArrayList.add("jesienne");
        testArrayList.add("miastu");
        testArrayList.add("przykre");
        testArrayList.add("I");
        WordReverser wordReverser = new WordReverser();
        String result = wordReverser.reverseWords(test);

        Assert.assertEquals(result,testArrayList.toString());
    }

    @Test
    public void ifFirstLineFromFileCanBeReversed() {
        FileHandler fileHandler = new FileHandler();
        List testArrayList = new ArrayList();
        testArrayList.add("blue");
        testArrayList.add("red");
        testArrayList.add("green");
        testArrayList.add("black");

        WordReverser wordReverser = new WordReverser();
        String result = wordReverser.reverseWords(fileHandler.readFirstLine());
        Assert.assertEquals(result,testArrayList.toString());
    }

    @Test
    public void ifEachLineFromFileCanBeReversed(){
        FileHandler fileHandler = new FileHandler();
        List testArrayList = new ArrayList();
        testArrayList.add("blue red green black");
        testArrayList.add("six five four three two one");
        testArrayList.add("Agnieszka Krzysztof Marek");

        WordReverser wordReverser = new WordReverser();
        String result = wordReverser.reverseWordsFromFile(fileHandler.readWholeFile());

        Assert.assertEquals(result,testArrayList.toString());

    }

}
