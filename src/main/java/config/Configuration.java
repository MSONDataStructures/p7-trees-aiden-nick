package config;

import structures.BinarySearchTree;
import structures.BinaryTreeNode;
import structures.BinaryTreeNodeImpl;
import structures.BinaryTreeUtility;

/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when your assignment is graded.
 * @author jcollard jddevaug
 */
public class Configuration {
	public static <T> BinaryTreeNode<T> createBinaryTreeNode(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right) {
		BinaryTreeNodeImpl<T> node = new BinaryTreeNodeImpl<>(elem); // Create a new node with the element
		node.setLeftChild(left);  // Set the left child
		node.setRightChild(right); // Set the right child
		return node; // Return the node
	}
	
	public static BinaryTreeUtility createBinaryTreeUtility(){
		return null;
	}

	public static <T extends Comparable<? super T>> BinarySearchTree<T> createBinarySearchTree(){
		return null;
	}
}
