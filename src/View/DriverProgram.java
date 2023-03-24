package View;

import Controller.Dictionary;
import Controller.ReadFile;
import Model.BinaryTree;
import Model.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int op= 1;
        Scanner in= new Scanner(System.in);
        Dictionary dic= new Dictionary();
        while (op==1){
            System.out.println("Que desea hacer: \n1. Cargar diccionario \n2. Ingresar palabra \n3. Cargar texto \n4. Traducir palabra \n5. Recorrer diccionario");
            int choose= in.nextInt();
            in.nextLine();
            switch (choose){
                case 1:
                    try {
                        dic.FiletoTree("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\BinaryTree\\dictionary.txt");
                        System.out.println("Importado correctamente");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    dic.insertWord();
                    break;
                case 3:
                    dic.translateSentence("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\BinaryTree\\texto.txt");
                    break;
                case 4:
                    dic.translate();
                    break;
                case 5:
                    dic.showTree();
                    break;
                default:
                    System.out.println("No elegiste una de nuestras opciones");
                    break;
            }


            System.out.println("Desea seguir? \n1. Si \n2. No");
            op=in.nextInt();
            in.nextLine();
        }
    }
}
