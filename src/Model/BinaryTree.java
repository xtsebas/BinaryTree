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

    private String searchNode(Node node, String key) {
        String nodes= null;
        int count = 0;
        if (node != null) {
            if (node.getLeft() != null && nodes ==null) {
                nodes= searchNode(node.getLeft(), key);
            }
            if (key.equals(node.getValue().getEnglish()) && count==0 && nodes ==null) {
                nodes = "\nEspañol: " + node.getValue().getSpanish() + "\nFrances: " + node.getValue().getFrance();
                count=1;
            } else if (key.equals(node.getValue().getSpanish()) && count==0 && nodes ==null) {
                nodes = "\nIngles: " + node.getValue().getEnglish() + "\nFrances: " + node.getValue().getFrance();
                count=1;
            } else if (key.equals(node.getValue().getFrance()) && count==0 && nodes ==null) {
                nodes = "\nIngles: " + node.getValue().getEnglish() + "\nEspañol: " + node.getValue().getSpanish();
                count=1;
            }
            if (node.getRight() != null && nodes ==null) {
                nodes = searchNode(node.getRight(), key);
            }
        }
        return nodes;
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
    public String change(Node node, String key){
        String nodes= null;
        int count = 0;
        if (node != null) {
            if (node.getLeft() != null && nodes ==null) {
                nodes= change(node.getLeft(), key);
            }
            if (key.equals(node.getValue().getEnglish()) && count==0 && nodes ==null) {
                nodes = node.getValue().getEnglish() + " " + node.getValue().getSpanish() + " " + node.getValue().getFrance();
                count=1;
            } else if (key.equals(node.getValue().getSpanish()) && count==0 && nodes ==null) {
                nodes = node.getValue().getSpanish() + " " + node.getValue().getEnglish() + " " + node.getValue().getFrance();
                count=1;
            } else if (key.equals(node.getValue().getFrance()) && count==0 && nodes ==null) {
                nodes = node.getValue().getFrance() + " " + node.getValue().getEnglish() + " " + node.getValue().getEnglish();
                count=1;
            }
            if (node.getRight() != null && nodes ==null) {
                nodes = change(node.getRight(), key);
            }
        }
        return nodes;
    }
}
