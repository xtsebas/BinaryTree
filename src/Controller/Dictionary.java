package Controller;

import Model.BinaryTree;
import Model.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    private Scanner in = new Scanner(System.in);
    private BinaryTree tree = new BinaryTree();

    /**
     * Transform the text file into a tree
     */
    public void FiletoTree(){
        System.out.println("Ingrese la direccion txt de su diccionario");
        String fpath= in.nextLine();
        ArrayList<ArrayList<String>> words=ReadFile.text(fpath);
        for (ArrayList language: words){
            String en=null, es=null, fr=null;
            for (int i = 0; i < language.size(); i++) {
                en= (String) language.get(i);
                i+=1;
                es = (String) language.get(i);
                i+=1;
                fr = (String) language.get(i);
            }
            Word word = new Word(en.toLowerCase(), es.toLowerCase(), fr.toLowerCase());
            tree.insert(word);
        }
    }

    /**
     * show the tree
     */
    public void showTree(){
        tree.show(tree.root);
    }

    /**
     * insert a word into the tree
     */
    public void insertWord(){
        System.out.println("Palabra en ingles: ");
        String en= in.nextLine().toLowerCase();
        System.out.println("Palabra en español: ");
        String es= in.nextLine().toLowerCase();
        System.out.println("Palabra en frances: ");
        String fr= in.nextLine().toLowerCase();
        Word word= new Word(en, es, fr);
        tree.insert(word);
    }

    /**
     * translate a word of the tree
     */
    public void translate(){
        System.out.println("Cual palabra desea traducir? ");
        String expression=in.nextLine();
        String result = tree.search(expression.toLowerCase());
        if (result==null){
            System.out.println("La palabra " + expression.toLowerCase() + " no esta agregada en el diccionario");
        }else {
            System.out.println(result);
        }
    }

    /**
     * translate a sentence using the words in the tree
     */
    public void translateSentence() {
        System.out.println("Ingrese la direccion txt de su oracion");
        String fpath= in.nextLine();
        ArrayList list = new ArrayList(Arrays.asList((ReadFile.oration(fpath).split(" "))));
        String lower= (String) list.get(0);
        list.set(0, lower.toLowerCase());
        ArrayList language1 = new ArrayList(list);
        ArrayList language2 = new ArrayList(list);
        ArrayList array = new ArrayList();
        for (Object word : list) {
            for (int i = 0; i < list.size(); i++) {
                if (word == list.get(i)) {
                    array.add(tree.change(tree.root, ((String) list.get(i)).toLowerCase()));
                }
            }
        }
        String sentence="";
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                String word = (String) array.get(i);
                ArrayList provisional = new ArrayList(Arrays.asList(word.split(" ")));
                for (int j = 0; j < provisional.size(); j++) {
                    for (int k = 0; k < language1.size(); k++) {
                        if (language1.get(k).equals(provisional.get(j+1))) {
                            language1.set(k, provisional.get(j+2));
                            language2.set(k, provisional.get(j+3));
                        }
                    }
                    if (provisional.get(0).equals("ingles")){
                        sentence= "La oracion: " + String.join(" ", list) + ", esta en ingles" + "\nEspañol: " + String.join(" ", language1) + "\nFrances: " + String.join(" ", language2) ;
                    } else if (provisional.get(0).equals("espanol")) {
                        sentence= "La oracion: " + String.join(" ", list) + ", esta en español" + "\nIngles: " + String.join(" ", language1) + "\nFrances: " + String.join(" ", language2) ;
                    } else {
                        sentence= "La oracion: " + String.join(" ", list) + ", esta en frances" + "\nIngles: " + String.join(" ", language1) + "\nEspañol: " + String.join(" ", language2) ;
                    }
                    j=4;
                }
            }
        }
        System.out.println(sentence);
    }
}
