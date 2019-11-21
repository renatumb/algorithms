//https://www.interviewcake.com/question/java/second-largest-item-in-bst?course=fc1&section=trees-graphs

import java.util.LinkedList;

public class SecondLargestBinaryTree {

    public static void main(String[] args) {


        BinaryTreeNode head = createTree();
        //BST( head );
        System.out.println(Biggest2nd(head));
    }

    public static BinaryTreeNode Biggest(BinaryTreeNode node) {
        BinaryTreeNode answer = null;

        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            BinaryTreeNode current = queue.pollFirst();
            answer = current;

            if (current.right != null)
                if (current.right.right != null)
                    queue.add(current.right);


        }
        return answer;
    }


    public static BinaryTreeNode Biggest2nd(BinaryTreeNode node) {

        if (node.right != null) {
            if (node.right.right != null)
                return Biggest2nd(node.right);
            if (node.right.left != null)
                return BiggestHelp(node.right.left);
        }
        return node;
    }

    public static BinaryTreeNode BiggestHelp(BinaryTreeNode node) {
        BinaryTreeNode current = node;
        BinaryTreeNode biggest = null;
        while (current != null) {
            if (current.right == null)
                biggest = current;
            current = current.right;
        }
        return biggest;
    }

    /// ##################################################################
    public static BinaryTreeNode createTree() {
/*
        BinaryTreeNode head = new BinaryTreeNode(50);


        BinaryTreeNode node_17 = new BinaryTreeNode(17);
        BinaryTreeNode node_72 = new BinaryTreeNode(72);
        BinaryTreeNode node_12 = new BinaryTreeNode(12);
        BinaryTreeNode node_23 = new BinaryTreeNode(23);
        BinaryTreeNode node_9 = new BinaryTreeNode(9);
        BinaryTreeNode node_14 = new BinaryTreeNode(14);
        BinaryTreeNode node_19 = new BinaryTreeNode(19);
        BinaryTreeNode node_25 = new BinaryTreeNode(25);
        BinaryTreeNode node_54 = new BinaryTreeNode(54);
        BinaryTreeNode node_76 = new BinaryTreeNode(76);
        BinaryTreeNode node_67 = new BinaryTreeNode(67);


        head.left = node_17;
        head.right = node_72;

        head.left.left = node_12;
        head.left.left.left = node_9;
        head.left.left.right = node_14;

        head.left.right = node_23;
        head.left.right.left = node_19;
        head.left.right.right = node_25;

        head.right.left = node_54;
        head.right.left.right = node_67;

        head.right.right = node_76;
        return head;
*/
        ///

        BinaryTreeNode head2 = new BinaryTreeNode(5);
        BinaryTreeNode node_3 = new BinaryTreeNode(3);
        BinaryTreeNode node_8 = new BinaryTreeNode(8);
        BinaryTreeNode node_1 = new BinaryTreeNode(1);
        BinaryTreeNode node_4 = new BinaryTreeNode(4);
        BinaryTreeNode node_7 = new BinaryTreeNode(7);
        BinaryTreeNode node_12 = new BinaryTreeNode(12);
        BinaryTreeNode node_10 = new BinaryTreeNode(10);
        BinaryTreeNode node_9 = new BinaryTreeNode(9);
        BinaryTreeNode node_11 = new BinaryTreeNode(11);
        head2.left = node_3;
        head2.right = node_8;
        head2.left.left = node_1;
        head2.left.right = node_4;
        head2.right.left = node_7;
        head2.right.right = node_12;
        head2.right.right.left = node_10;
        head2.right.right.left.left = node_9;
        head2.right.right.left.right = node_11;
        return head2;
    }

    public static void BST(BinaryTreeNode node) {

        LinkedList<BinaryTreeNode> queue = new LinkedList<>();

        queue.push(node);

        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.pop();

            System.out.println(current);
            if (current.left != null) queue.addLast(current.left);
            if (current.right != null) queue.addLast(current.right);
        }
    }
}


// ------------------------------------------------------------------------------------------------------
class BinaryTreeNode {

    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertRight(BinaryTreeNode node) {
        this.right = node;
        return node;
    }

    public BinaryTreeNode insertLeft(BinaryTreeNode node) {
        this.left = node;
        return node;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
