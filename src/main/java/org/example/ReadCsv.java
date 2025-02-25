package org.example;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class ReadCsv {
    public static void main(String[] args) {

        String path = "src/main/java/org/example/data.csv";
        try(CSVReader reader = new CSVReader(new FileReader(path))){
            String[] file;
            while ((file = reader.readNext()) != null){
                System.out.println("Id:-" + file[0] + " Name :- " + file[1] + " Age:- " + file[2] + " Marks :- " + file[3]);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
