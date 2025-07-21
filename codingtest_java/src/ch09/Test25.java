package ch09;

public class Test25 {

    private static int NONE = 987654321;

    public static void main(String[] args) {

        // implementing binary tree via array
        // where n = root, n*2 = left, n*2 + 1 = right, starting idx = 1
        int[] nodes = {NONE, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(inorder(nodes, 1));
        System.out.println(postorder(nodes, 1));
        System.out.println(preorder(nodes, 1));
    }

    // left-visit-right
    private static String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * idx)
                + nodes[idx]
                + inorder(nodes, 2 * idx + 1);
    }

    // visit-left-right
    private static String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return nodes[idx]
                + preorder(nodes, 2 * idx)
                + preorder(nodes, 2 * idx + 1);
    }

    // left-right-visit
    private static String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2*idx)
                + postorder(nodes, 2*idx + 1)
                + nodes[idx];
    }

}