package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFile {
    /**
     *Lee la ruta del archivo donde se encuentra el texto
     * @param fpath
     * @return word
     */
    public static ArrayList<ArrayList<String>> text(String fpath){
        ArrayList<ArrayList<String>> word = new ArrayList<>();
        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ArrayList<String> words = new ArrayList<>(Arrays.asList(data.split(",")));
                word.add(words);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return word;
    }
}
//CODIGO TOMADO DE LA HOJA DE TRABAJO 2
//EQUIPO NUMERO 4
//INTEGRANTES SEBASTIAN HUERTAS, XAVIER LOPEZ, GERSON RAMIREZ
