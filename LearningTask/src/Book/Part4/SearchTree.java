package Book.Part4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class SearchTree {
    private Node<Integer> root;

    static class Node<Integer> {
        private int data;
        private Node left;
        private Node right;

        public Node() {}

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public SearchTree() {}

    public SearchTree(Node node) {
        this.root = node;
    }

    public boolean checkTree() {
        if (this == null ||
                (this.checkLeft(this.root.getLeft(), this.root.getData()) &&
                        this.checkRight(this.root.getRight(), this.root.getData()))) {
            return true;
        }
        return false;
    }

    private boolean checkLeft(Node node, int limit) {
        if (node == null) {
            return true;
        }
        HashSet<Integer> nums = bfs(node);
        Iterator iter = nums.iterator();
        while (iter.hasNext()) {
            if ((int)iter.next() > limit) {
                return false;
            }
        }
        if (node.getData() > limit ||
                !checkLeft(node.getLeft(), node.getData()) ||
                !checkRight(node.getRight(), node.getData())) {
            return false;
        }
        return true;
    }

    private boolean checkRight(Node node, int limit) {
        if (node == null) {
            return true;
        }
        HashSet<Integer> nums = bfs(node);
        Iterator iter = nums.iterator();
        while (iter.hasNext()) {
            int num = (int)iter.next();
            if (num < limit) {
                return false;
            }
        }
        if (node.getData() < limit ||
                !checkLeft(node.getLeft(), node.getData()) ||
                !checkRight(node.getRight(), node.getData())) {
            return false;
        }
        return true;
    }

    private HashSet<Integer> bfs(Node node) {
        HashSet<Integer> res = new HashSet<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (node.getLeft() != null) {
            queue.add(node.getLeft());
        }
        if (node.getRight() != null) {
            queue.add(node.getRight());
        }
        for(int i = 0; i < queue.size(); i++) {
            Node tmp = queue.get(i);
            if (tmp.getLeft() != null) {
                queue.add(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());
            }
            res.add(tmp.getData());
        }
        return res;
    }

    @Override
    public String toString() {
        String leftData, rightData;
        if (root.left != null) {
            leftData = String.valueOf(root.left.getData());
        } else {leftData = "null";}
        if (root.right != null) {
            rightData = String.valueOf(root.right.getData());
        } else {rightData = "null";}
        System.out.println("node: " + root.getData() +
                "  |left: " + leftData +
                "  |right: " + rightData);
        printKnot(root.getLeft());
        printKnot(root.getRight());
        return ("");
    }

    private void printKnot(Node node) {
        if (node == null) {
            return;
        }
        String leftData, rightData;
        if (node.left != null) {
            leftData = String.valueOf(node.left.getData());
        } else {leftData = "null";}
        if (node.right != null) {
            rightData = String.valueOf(node.right.getData());
        } else {rightData = "null";}
        System.out.println("node: " + node.getData() +
                "  |left: " + leftData +
                "  |right: " + rightData);
        printKnot(node.getLeft());
        printKnot(node.getRight());
    }
}
