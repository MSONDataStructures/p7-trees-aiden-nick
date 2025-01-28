package structures;

public class BinaryTreeNodeImpl<T> implements BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    // Constructor to initialize the node with data, left and right children as null
    public BinaryTreeNodeImpl(T data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        if (data == null) {
            throw new NullPointerException("Data cannot be null");
        }
        this.data = data;
    }

    @Override
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    @Override
    public boolean hasRightChild() {
        return rightChild != null;
    }

    @Override
    public BinaryTreeNode<T> getLeftChild() {
        if (!hasLeftChild()) {
            throw new IllegalStateException("This node does not have a left child");
        }
        return leftChild;
    }

    @Override
    public BinaryTreeNode<T> getRightChild() {
        if (!hasRightChild()) {
            throw new IllegalStateException("This node does not have a right child");
        }
        return rightChild;
    }

    @Override
    public void setLeftChild(BinaryTreeNode<T> left) {
        this.leftChild = left;
    }

    @Override
    public void setRightChild(BinaryTreeNode<T> right) {
        this.rightChild = right;
    }
}