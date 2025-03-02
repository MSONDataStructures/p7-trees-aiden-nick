package config;

import structures.*;

/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when your assignment is graded.
 * @author jcollard jddevaug
 */
public class Configuration {
	public static <T> BinaryTreeNode<T> createBinaryTreeNode(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right) {
		BinaryTreeNodeImpl<T> node = new BinaryTreeNodeImpl<>(elem);
		node.setLeftChild(left);
		node.setRightChild(right);
		return node;
	}

	public static BinaryTreeUtility createBinaryTreeUtility() {
		return new BinaryTreeUtilityImpl();
	}

	public static <T extends Comparable<? super T>> BinarySearchTree<T> createBinarySearchTree() {
		return new BinarySearchTreeImpl<>();
	}
}
