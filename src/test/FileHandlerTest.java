package test;

import main.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin_Styczen on 2016-11-28.
 */
public class FileHandlerTest {
    @Test()
    public void isFileFound(){
        Boolean expected = true;
        FileHandler fileHandler = new FileHandler();
        Boolean result = fileHandler.findFile();

        Assert.assertEquals(result,expected);
    }

    @Test()
    public void isFileNotEmpty() throws IOException {
        Boolean expected = true;
        FileHandler fileHandler = new FileHandler();
        Boolean result = fileHandler.checkIfNotEmpty();

        Assert.assertEquals(result,expected);

    }

    @Test
    public void ifFirstLineCanBePrinted() throws IOException {
        String expected = "black green red blue";
        FileHandler fileHandler = new FileHandler();
        String result = fileHandler.readFirstLine();
        Assert.assertEquals(result,expected);
    }

    @Test
    public void ifAllOfTheLinesCanBeRead() {
        List testArrayList = new ArrayList();
        testArrayList.add("black green red blue");
        testArrayList.add("one two three four five six");
        testArrayList.add("Marek Krzysztof Agnieszka");

        FileHandler fileHandler = new FileHandler();
        List result = fileHandler.readWholeFile();
        Assert.assertEquals(result,testArrayList);
    }

    @Test
    public void areFilesNotTheSame() {
        List testArrayList = new ArrayList();
        testArrayList.add("black green red blue");
        testArrayList.add("one two three four five six");
        testArrayList.add("Marek Krzysztof Agnieszkaas");

        FileHandler fileHandler = new FileHandler();
        List result = fileHandler.readWholeFile();
        Assert.assertNotEquals(result,testArrayList);
    }

    @Test
    public void ifDifferentFileReturnsTheSameResults(){
        List testArrayList = new ArrayList();
        testArrayList.add("Przeszły dżdże wiosny, zbiegło skwarne lato");
        testArrayList.add("I przykre miastu jesienne potopy,");
        testArrayList.add("Już bruk ziębiącą obleczony szatą,");
        testArrayList.add("Od stalnej Fryzów nie krzesany stopy.");

        FileHandler fileHandler = new FileHandler();
        BufferedReader file = fileHandler.openFile("src/main/nextTestFile.txt");
        List result = fileHandler.readWholeParticularFile(file);

        Assert.assertEquals(result,testArrayList);

    }
}
