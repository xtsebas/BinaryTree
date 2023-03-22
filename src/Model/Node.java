package Model;

public class Node {
    Word value;
    Node left, right;

    public Node(Word value){
        this.value=value;
        left=null;
        right=null;
    }
}
