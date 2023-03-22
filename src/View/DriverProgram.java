package View;

import Model.BinaryTree;
import Model.Word;

import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int op= 1;
        Scanner in= new Scanner(System.in);
        while (op==1){
            System.out.println("Que desea hacer \n1. Ingresar palabra \n2. Ingresar texto \n3. Traducir palabra \n4. Recorrer diccionario");
            int choose= in.nextInt();
            in.nextLine();
            switch (choose){
                case 1:
                    try {
                        System.out.println("Ingles: ");
                        String en = in.nextLine();
                        System.out.println("Español: ");
                        String es = in.nextLine();
                        System.out.println("Frances: ");
                        String fr = in.nextLine();
                        Word word= new Word(en, es, fr);
                        tree.insert(word);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    tree.show(tree.root);
                    break;
                default:
                    System.out.println("No elegiste una de nuestras opciones");
                    break;
            }


            System.out.println("SALIDA");
            op=in.nextInt();
            in.nextLine();
        }
    }
}
