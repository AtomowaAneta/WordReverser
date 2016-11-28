package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Marcin_Styczen on 2016-11-28.
 */
public class FileHandler {

    public BufferedReader openFile(String filePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return br;
    }

    public Boolean findFile() {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("src/main/input.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }


    public Boolean checkIfNotEmpty() throws IOException {
        Boolean isNotEmpty;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!(br.readLine() == null)) {
            System.out.println("file is not empty");
            isNotEmpty = true;
        } else {
            System.out.print("File is empty");
            isNotEmpty = false;
        }

        return isNotEmpty;
    }


    public String readFirstLine() {
        BufferedReader br = null;
        String text = null;
        try {
            br = new BufferedReader(new FileReader("src/main/input.txt"));
            text = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


    public List readWholeFile() {
        List linesList = new ArrayList();
        BufferedReader br = null;
        String strLine = " ";
        try {
            br = new BufferedReader(new FileReader("src/main/input.txt"));
            while((strLine = br.readLine()) != null){
                if(strLine.isEmpty() || strLine.trim().equals("") || strLine.trim().equals("\n")){
                    System.out.print("Empty line");
                }
                linesList.add(strLine);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesList;
    }

    public List readWholeParticularFile(BufferedReader content) {
        List linesList = new ArrayList();
        BufferedReader br = null;
        String strLine = " ";
        try {
            br = content;
            while((strLine = br.readLine()) != null){
                if(strLine.isEmpty() || strLine.trim().equals("") || strLine.trim().equals("\n")){
                    System.out.print("Empty line");
                }
                else {
                    linesList.add(strLine);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return linesList;
    }

    public List readFromFileName(String filename) {
        List linesList = new ArrayList();
        BufferedReader br = null;
        String strLine = " ";
        try {
            br = new BufferedReader(new FileReader(filename));;
            while((strLine = br.readLine()) != null){
                if(strLine.isEmpty() || strLine.trim().equals("") || strLine.trim().equals("\n")){
                    System.out.print("Empty line");
                }
                else {
                    linesList.add(strLine);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linesList;
    }

    public void saveOutputToFile(String content) {
        Writer writer = null;
        try {
          File output = new File("src/main/output.txt");

            FileWriter fw = new FileWriter(output.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content.replaceAll("\\[", "").replaceAll("\\]",""));
            bw.close();


        }  catch (IOException e) {
            e.printStackTrace();
        }

    }
    }


