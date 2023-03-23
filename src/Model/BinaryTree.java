package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree{
    public Node root;
    public BinaryTree(){
        root = null;
    }
    public void insert (Word word){
        root = insertNode(root, word);
    }

    private Node insertNode (Node node, Word word){
        if (node==null){
            return new Node(word);
        }
        if (word.getEnglish().compareTo((node.getValue().getEnglish())) < 0){
            node.setLeft(insertNode(node.getLeft(), word));
        }else if (word.getEnglish().compareTo((node.getValue().getEnglish())) > 0){
            node.setRight(insertNode(node.getRight(), word));
        }else {
            return  node;
        }
        return node;
    }

    public String search(String key){
        return searchNode(root, key);
    }

    private String searchNode(Node node, String key){
        if (node == null){
            return null;
        }
        if (key.equals(node.getValue().getEnglish())){
            return "\nEspañol: " + node.getValue().getSpanish() + "\nFrances: " + node.getValue().getFrance();
        } else if (key.equals(node.getValue().getSpanish())) {
            return "\nIngles: " + node.getValue().getEnglish() + "\nFrances: " + node.getValue().getFrance();
        } else if (key.equals(node.getValue().getFrance())) {
            return "\nIngles: " + node.getValue().getEnglish() + "\nEspañol: " + node.getValue().getSpanish();
        }
        if (key.compareTo(node.getValue().getEnglish()) < 0 || key.compareTo(node.getValue().getSpanish()) < 0 || key.compareTo(node.getValue().getFrance()) < 0){
            return searchNode(node.getLeft(), key);
        } else {
            return searchNode(node.getRight(), key);
        }
    }

    public void show(Node root){
        if (root != null){
            if (root.getLeft() != null) {
                show(root.getLeft());
            }
            System.out.println("//////////////////////////////////////////////////////");
            System.out.println(root.getValue().getEnglish() + " " + root.getValue().getSpanish() + " " + root.getValue().getFrance());
            if (root.getRight() != null) {
                show(root.getRight());
            }
        }
    }
    public ArrayList change(Node root, String key){
        ArrayList translate= new ArrayList<>();
        if (root.getLeft() != null) {
            return change(root.getLeft(), key);
        }
        if (root.getValue().getEnglish().equals(key)){
            translate.add(root.getValue().getEnglish()); translate.add(root.getValue().getSpanish()); translate.add(root.getValue().getFrance());
            return translate;
        } else if (root.getValue().getSpanish().equals(key)) {
            translate.add(root.getValue().getSpanish()); translate.add(root.getValue().getEnglish()); translate.add(root.getValue().getFrance());
            return translate;
        } else if (root.getValue().getFrance().equals(key)) {
            translate.add(root.getValue().getFrance()); translate.add(root.getValue().getEnglish()); translate.add(root.getValue().getSpanish());
            return translate;
        }
        if (root.getRight() != null) {
            return change(root.getRight(), key);
        }
        return translate;
    }

    public boolean Changebool(String key){
        return SearchandChange(root, key);
    }
    private boolean SearchandChange(Node node, String key){
        if (node == null){
            return false;
        }
        if (key.equals(node.getValue().getEnglish()) || key.equals(node.getValue().getSpanish()) || key.equals(node.getValue().getFrance())){
            return true;
        }
        if (key.compareTo(node.getValue().getEnglish()) < 0 || key.compareTo(node.getValue().getSpanish()) < 0 || key.compareTo(node.getValue().getFrance()) < 0){
            return SearchandChange(node.getLeft(), key);
        } else {
            return SearchandChange(node.getRight(), key);
        }
    }
}
