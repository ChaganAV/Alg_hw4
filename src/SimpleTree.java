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

        @Override
        public String toString() {
            System.out.println(value);
            return null;
        }
    }

    @Override
    public String toString() {
        return "SimpleTree{" +
                "root=" + root +
                '}';
    }

    private void print(Node root){
        Node node = root;
        while(node != null) {
            System.out.println(node);
            if (node.leftChild != null) {
                print(node.leftChild);
            }
            if(node.rightChild != null){
                print(node.rightChild);
            }
        }
    }

    public void add(int value){
        Node node = new Node();
        node.value = value;
        node.color = Color.RED;
        if(root == null){
            node.color = Color.BLACK;
            this.root = node;
        } else {
            if(root.value > node.value){
                root.leftChild = addLeftNode(node,value);
            }else{
                root.rightChild = addRightNode(node,value);
            }
        }
    }
    private Node addLeftNode(Node node, int value){
        if(node.value > value){
            if (node.leftChild == null){
                Node newNode = new Node();
                newNode.value = value;
                newNode.color = Color.RED;
                node.leftChild = newNode;
                return node;
            }else{
                if(node.leftChild.value > value){
                    return addLeftNode(node.leftChild,value);
                }else{
                    Node temp = node.leftChild;
                    Node newNode = new Node();
                    newNode.value = value;
                    newNode.color = Color.RED;
                    newNode.leftChild = temp;
                    node.leftChild = newNode;
                    return node;
                }
            }
        }else{
            return addRightNode(node,value);
        }
    }

    private Node addRightNode(Node node, int value) {
        if(node.value < value){
            if (node.rightChild == null){
                Node newNode = new Node();
                newNode.value = value;
                newNode.color = Color.BLACK;
                node.rightChild = newNode;
                return node;
            }else{
                if(node.leftChild.value > value){
                    return addLeftNode(node.leftChild,value);
                }else{
                    Node temp = node.leftChild;
                    Node newNode = new Node();
                    newNode.value = value;
                    newNode.color = Color.RED;
                    newNode.leftChild = temp;
                    node.leftChild = newNode;
                    return node;
                }
            }
        }else{
            return addLeftNode(node,value);
        }
    }
}
