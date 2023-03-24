package Controller;

import Model.BinaryTree;
import Model.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Dictionary {
    private Scanner in = new Scanner(System.in);
    private BinaryTree tree = new BinaryTree();

    public void FiletoTree(String fpath){
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

    public void showTree(){
        tree.show(tree.root);
    }

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

    public void translate(){
        System.out.println("Cual palabra desea traducir? ");
        String expression=in.nextLine();
        String result = tree.search(expression.toLowerCase());
        if (result==null){
            System.out.println("La palabra " + expression.toLowerCase() + " no esta agregada en el diccionario");
        }else {
            System.out.println("Su palabra: " + expression + result);
        }
    }

    public void translateSentence(String fpath) {
        ArrayList list = new ArrayList(Arrays.asList((ReadFile.oration(fpath).split(" "))));
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
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                String word = (String) array.get(i);
                ArrayList provisional = new ArrayList(Arrays.asList(word.split(" ")));
                for (int j = 0; j < provisional.size(); j++) {
                    for (int k = 0; k < language1.size(); k++) {
                        if (language1.get(k).equals(provisional.get(j))) {
                            language1.set(k, provisional.get(j+1));
                            language2.set(k, provisional.get(j+2));
                        }
                    }
                    j=3;
                }
            }
        }
        String sentence= String.join(" ", list) + "\n" + String.join(" ", language1) + "\n" + String.join(" ", language2) ;
        System.out.println(sentence);
    }
}
