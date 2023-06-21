import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    private Node root;
    private enum Color{RED,BLACK};
    private class Node{
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;
    }

    public void add(int value){
        Node node = new Node();
        node.value = value;
        node.color = Color.RED;
        if(root == null){
            node.color = Color.BLACK;
            this.root = node;
        } else {
            if(root.value > value){
                Node temp = root;
                root = node;
                root.color = Color.BLACK;
            } else {
            }

        }
    }





}
