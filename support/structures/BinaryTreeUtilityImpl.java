package structures;

public class BinaryTreeUtilityImpl implements BinaryTreeUtility {
    private BinaryTreeNode<Object> node;


    /**
     * Write a description of class BinaryTreeUtilityCode here.
     *
     * @author Nick Wong
     */


        public <T> int getDepth(BinaryTreeNode<T> root) {
            if (root == null) {
                throw new NullPointerException("Root cannot be null");
            }
            return getDepthHelper(root);
        }

        public <T> int getDepthHelper(BinaryTreeNode<T> node) {
            if (node == null) {
                return -1;
            }
            int leftDepth = getDepthHelper(node.getLeftChild());
            int rightDepth = getDepthHelper(node.getRightChild());
            return Math.max(leftDepth, rightDepth) + 1;
        }

        public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
            if (root == null) {
                throw new NullPointerException("Root cannot be null");
            }
            if (tolerance < 0) {
                throw new IllegalArgumentException("Tolerance cannot be negative");
            }
            return isBalancedHelper(root, tolerance) != -1;
        }

        public <T> int isBalancedHelper(BinaryTreeNode<T> node, int tolerance) {
            return 0;
        }

        public <T extends Comparable<? super T>> boolean isBST(BinaryTreeNode<T> root) {
            if (root == null) {
                throw new NullPointerException("Root cannot be null");
            }
            return isBSTHelper(root, null, null);
        }

public <T extends Comparable<? super T>> boolean isBSTHelper(BinaryTreeNode<T> node, T min, T max) {
    return false;
}
}



