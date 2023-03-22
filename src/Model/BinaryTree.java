package Model;

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
            return node.getValue().getEnglish();
        } else if (key.equals(node.getValue().getSpanish())) {
            return node.getValue().getSpanish();
        } else if (key.equals(node.getValue().getFrance())) {
            return node.getValue().getFrance();
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
}
