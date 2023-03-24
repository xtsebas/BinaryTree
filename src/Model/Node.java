package Model;

public class Node {
    private Word value;
    private Node left, right;

    /**
     * Constructor
     * @param value
     */
    public Node(Word value){
        this.value=value;
        left=null;
        right=null;
    }

    /**
     *
     * @return
     */
    public Word getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(Word value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public Node getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public Node getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }
}
