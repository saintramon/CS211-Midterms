/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 7 November 2023
 */
package Tree;

public class Tree<T> {
    private Node<T> root;

    public Tree(){
        this.root = null;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }
}
