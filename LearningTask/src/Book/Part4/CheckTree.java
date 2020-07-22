package Book.Part4;

public class CheckTree {
    public static void main(String[] args) {
        SearchTree.Node<Integer> root = new SearchTree.Node<>(5);
        SearchTree st = new SearchTree(root);
        root.setLeft(new SearchTree.Node<>(3));
        root.setRight(new SearchTree.Node<>(7));
        SearchTree.Node<Integer>tmp= root.getLeft();
        tmp.setLeft(new SearchTree.Node<>(1));
        tmp.setRight(new SearchTree.Node<>(4));
        tmp = root.getRight();
        tmp.setLeft(new SearchTree.Node<>(6));
        tmp.setRight(new SearchTree.Node<>(10));
        System.out.println(st);
        System.out.println("Result: " + st.checkTree());
    }
}
