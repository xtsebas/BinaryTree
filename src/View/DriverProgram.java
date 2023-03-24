package View;

import Controller.Dictionary;
import Model.BinaryTree;
import java.util.Scanner;

public class DriverProgram {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int op= 1;
        Scanner in= new Scanner(System.in);
        Dictionary dic= new Dictionary();
        start();
        while (op==1){
            System.out.println("Que desea hacer: \n1. Cargar diccionario \n2. Ingresar palabra \n3. Cargar texto \n4. Traducir palabra \n5. Recorrer diccionario");
            int choose= in.nextInt();
            in.nextLine();
            System.out.println(" ");
            switch (choose){
                case 1:
                    try {
                        //"C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\BinaryTree\\dictionary.txt"
                        dic.FiletoTree();
                        System.out.println("Importado correctamente");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    dic.insertWord();
                    break;
                case 3:
                    //C:\Users\Sebastian\OneDrive - Universidad del Valle de Guatemala\Escritorio\POO\BinaryTree\texto.txt
                    dic.translateSentence();
                    break;
                case 4:
                    dic.translate();
                    break;
                case 5:
                    System.out.println("Ingles   ||   Español   ||   Frances");
                    dic.showTree();
                    break;
                default:
                    System.out.println("No elegiste una de nuestras opciones");
                    break;
            }


            System.out.println("\nDesea seguir? \n1. Si \n2. No");
            op=in.nextInt();
            in.nextLine();
            System.out.println(" ");
        }
    }

    /**
     * Menu
     */
    public static void start(){
        System.out.println("Bienvenido a su programa de busqueda de palabras en ingles\n***** Este programa utiliza arboles binarios*******\n \n/////////////////////////////////// \n");
    }
}
