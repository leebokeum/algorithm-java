package tree;

public class TestTree {
    public static void main(String[] args) {
        /**
         * Inorder 방식으로 저장하고 출력하기
         *    5
         *   / \
         *  /   \
         *  3   10
         * / \ / \
         * 1 4 6 23
         */
        TreeNode inorderTree = new TreeNode(5);
        inorderTree.insertInOrder(10);
        inorderTree.insertInOrder(3);
        inorderTree.insertInOrder(4);
        inorderTree.insertInOrder(6);
        inorderTree.insertInOrder(23);
        inorderTree.insertInOrder(1);

        inorderTree.print();

        // left, root, right
        inorderTree.printInOrder();
        System.out.println();

        // root, left, right
        inorderTree.printPreOrder();
        System.out.println();

        // left, right, root
        inorderTree.printPostOrder();
    }
}
