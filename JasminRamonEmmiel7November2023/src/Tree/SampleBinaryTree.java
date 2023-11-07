/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 7 November 2023
 */
package Tree;

public class SampleBinaryTree {
    public static void main(String[] args) {
        try {
            SampleBinaryTree program = new SampleBinaryTree();
            program.run();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * The run method creates a tree with 9 nodes and displays the preorder, inorder, and postorder traversal for the generated tree
     */
    public void run(){
        Tree<Integer> tree = new Tree<Integer>();
        Node<Integer> leaf1 = new Node<Integer>(21, null, null);
        Node<Integer> leaf2 = new Node<Integer>(28, null, null);
        Node<Integer> leaf3 = new Node<Integer>(5, null, null);
        Node<Integer> leaf4 = new Node<Integer>(27, null, null);
        Node<Integer> leaf5 = new Node<Integer>(3, null, null);
        Node<Integer> node3 = new Node<Integer>(53,leaf1,leaf2);
        Node<Integer> node2 = new Node<Integer>(66, node3,leaf3);
        Node<Integer> node4 = new Node<Integer>(55, leaf4, leaf5);
        tree.setRoot(new Node<Integer>(83, node2, node4));

        System.out.println("PREORDER: ");
        preorder(tree.getRoot());
        System.out.println("\n\n\nINORDER: ");
        inorder(tree.getRoot());
        System.out.println("\n\n\nPOSTORDER: ");
        postorder(tree.getRoot());
    }

    /**
     * The preorder method facilitates the traversal of the tree in the preorder form and prints the sequence of nodes visited
     * @param node
     */
    public void preorder(Node<Integer> node){
        if (node != null){
            System.out.print(node.getValue() + " ");
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    /**
     * The inorder method facilitates the traversal of the tree in the inorder form and prints the sequence of nodes visited
     * @param node
     */
    public void inorder(Node<Integer> node){
        if (node != null){
            inorder(node.getLeft());
            System.out.print(node.getValue() + " ");
            inorder(node.getRight());
        }
    }

    /**
     * The postorder method facilitates the traversal of the tree in the postorder form and prints the sequence of nodes visited
     * @param node
     */
    public void postorder(Node<Integer> node){
        if (node != null){
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
}
