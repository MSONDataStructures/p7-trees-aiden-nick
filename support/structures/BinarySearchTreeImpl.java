package structures;

/**
 * Implements the BinarySearchTree interface.
 */
public class BinarySearchTreeImpl<T extends Comparable<? super T>> implements BinarySearchTree<T> {

    private BinaryTreeNode<T> root;
    private int size;

    public BinarySearchTreeImpl() {
        root = null;
        size = 0;
    }

    @Override
    public BinarySearchTree<T> add(T toAdd) {
        if (toAdd == null) {
            throw new NullPointerException("Cannot add null value");
        }

        if (root == null) {

            root = new BinaryTreeNodeImpl<>(toAdd);
            size++;
            return this;
        } else {

            root = addRecursive(root, toAdd);
            size++;
            return this;
        }
    }

    private BinaryTreeNode<T> addRecursive(BinaryTreeNode<T> node, T toAdd) {
        if (node == null) {

            return new BinaryTreeNodeImpl<>(toAdd);
        }

        int comparison = toAdd.compareTo(node.getData());
        if (comparison < 0) {

            try {
                node.getLeftChild();
            } catch (Exception e) {
                node.setLeftChild(new BinaryTreeNodeImpl<>(toAdd));
            }
        } else {

            try {
                node.getRightChild();
            } catch (Exception e) {
                node.setRightChild(new BinaryTreeNodeImpl<>(toAdd));
            }
        }
        return node;
    }


    @Override
    public boolean contains(T toFind) {
        if (toFind == null) {
            throw new NullPointerException("Cannot search for null value");
        }
        return containsRecursive(root, toFind);
    }

    private boolean containsRecursive(BinaryTreeNode<T> node, T toFind) {
        if (node == null) {
            return false;
        }

        int comparison = toFind.compareTo(node.getData());
        if (comparison < 0) {
            return containsRecursive(node.getLeftChild(), toFind);
        } else if (comparison > 0) {
            return containsRecursive(node.getRightChild(), toFind);
        } else {
            return true;
        }
    }

    @Override
    public boolean remove(T toRemove) {
        if (toRemove == null) {
            throw new NullPointerException("Cannot remove null value");
        }
        boolean result = false;
        if (contains(toRemove)) {
            root = removeRecursive(root, toRemove);
            size--;
            result = true;
        }
        return result;
    }

    private BinaryTreeNode<T> removeRecursive(BinaryTreeNode<T> node, T toRemove) {
        if (node == null) {
            return null;
        }

        int comparison = toRemove.compareTo(node.getData());
        if (comparison < 0) {
            node.setLeftChild(removeRecursive(node.getLeftChild(), toRemove));
        } else if (comparison > 0) {
            node.setRightChild(removeRecursive(node.getRightChild(), toRemove));
        } else {

            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            } else {

                T minValue = findMin(node.getRightChild());
                node.setData(minValue);
                node.setRightChild(removeRecursive(node.getRightChild(), minValue));
            }
        }
        return node;
    }

    private T findMin(BinaryTreeNode<T> node) {
        T minValue = node.getData();
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
            minValue = node.getData();
        }
        return minValue;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getMinimum() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMin(root);
    }

    @Override
    public T getMaximum() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMax(root);
    }

    private T findMax(BinaryTreeNode<T> node) {
        T maxValue = node.getData();
        while (node.getRightChild() != null) {
            node = node.getRightChild();
            maxValue = node.getData();
        }
        return maxValue;
    }

    @Override
    public BinaryTreeNode<T> getRoot() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return root;
    }
}