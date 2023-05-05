package Week08_Assignment;

public class KeySum {
    // A function that returns the sum of all

    // Node of Binary Tree
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    // Root of Binary Tree
    public Node root;

    public KeySum() {
        root = null;
    }

    // Method to calculate
    public int calculateSum(Node temp) {
        int sum;
        int sumLeft = 0;
        int sumRight = 0;

        if (root == null) {
            return 0;
        } else {
            if (temp.left != null) {
                sumLeft = calculateSum(temp.left);
            }
            if (temp.right != null) {
                sumRight = calculateSum(temp.right);
            }
        }
        sum = temp.value + sumLeft + sumRight;
        return sum;
    }

    public static void main(String[] args) {
        KeySum value = new KeySum();

        value.root = new Node(5);
        value.root.left = new Node(2);
        value.root.right = new Node(8);
        value.root.left.left = new Node(1);
        value.root.right.right = new Node(7);
        value.root.right.left = new Node(6);


        System.out.println(
                "Sum of all elements in the binary tree is: "
                        + value.calculateSum(value.root));
    }
}
