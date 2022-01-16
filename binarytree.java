import java.util.LinkedList;

import java.util.Queue;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// A Java program to introduce Binary Tree
public class binarytree {

    static int levelSoFar = 0;

    public static void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.key + ",");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + ",");
        inorder(root.right);

    }

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key + ",");

    }

    static int getHeight(Node node) {
        if (node == null)
            return -1;
        else {

            int lheight = getHeight(node.left);
            int rheight = getHeight(node.right);

            if (lheight >= rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    static void print_leafNodes(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            System.out.println("LeafNode:" + root.key);
        }
        print_leafNodes(root.left);
        print_leafNodes(root.right);
    }

    static int get_count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = get_count(root.left);
        int rightCount = get_count(root.right);
        return 1 + leftCount + rightCount;
    }

    static int get_sum(Node root) {
        int sum = 0, sumright = 0, sumleft = 0;

        if (root == null) {
            return 0;
        } else {
            if (root != null)
                sumleft = get_sum(root.left);
            if (root != null)
                sumright = get_sum(root.right);
            sum = root.key + sumleft + sumright;
            return sum;
        }

    }

    static void leftView(Node root, int currlevel) {
        if (root == null)
            return;

        if (currlevel >= levelSoFar) {

            System.out.println(root.key);
            levelSoFar++;
        }

        leftView(root.left, currlevel + 1);
        leftView(root.right, currlevel + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        print_leafNodes(root);
        leftView(root, 0);
        System.out.println("The Preorder is");
        preorder(root);
        System.out.println();
        System.out.println("The Postorder is");
        postOrder(root);
        System.out.println();
        System.out.println("The inorder is");
        inorder(root);
        System.out.println();
        System.out.println("The count of nodes  is");
        System.out.println(get_count(root));
        System.out.println("The Height of tree is");
        System.out.println(getHeight(root));
        System.out.println(get_sum(root));
    }

}