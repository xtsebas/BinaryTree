package Controller;

import Model.BinaryTree;
import Model.Word;

import java.util.ArrayList;
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
            Word word = new Word(en, es, fr);
            tree.insert(word);
        }
    }

    public void showTree(){
        tree.show(tree.root);
    }

    public void insertWord(){
        System.out.println("Palabra en ingles: ");
        String en= in.nextLine();
        System.out.println("Palabra en español: ");
        String es= in.nextLine();
        System.out.println("Palabra en frances: ");
        String fr= in.nextLine();
        Word word= new Word(en, es, fr);
        tree.insert(word);
    }

    public void translate(){
        System.out.println("Cual palabra desea traducir? ");
        String expression=in.nextLine();
        String result = tree.search(expression);
        System.out.println("Su palabra: " + expression + result);
    }
}
