package com.ds.study.tree;

import java.util.ArrayList;

public class BinarySearchTree {
	
	static class Node{
		int data;
		Node leftChild=null, rightChild=null;
		Node(int data){
			this.data = data;
		}
	}
	
	private Node root = null;
	
	public Node getRoot() {
		return root;
	}
	
	// Time complexity O(log n), best case - O(height)
	public Node insert(Node root,int data) {
		Node node = new Node(data);
		if(root == null) {
			root = node;
		}else if(data <= root.data){
			root.leftChild = insert(root.leftChild,data);
		}else {
			root.rightChild = insert(root.rightChild, data);
		}
		this.root = root;
		return root;
	}
	
	public boolean deleteNode(int data) {
		if(search(root, data)) {
			root = delete(root,data);
			return true;
		}else {
			return false;
		}
	}
	
	// Time complexity O(log n), best case - O(height)
	private Node delete(Node root, int data) {
		if(root == null)
			return root;
		else if(data < root.data) 
			root.leftChild = delete(root.leftChild, data);
		else if(data > root.data)
			root.rightChild = delete(root.rightChild, data);
		else {// found the node
			// if both child are null
			if(root.leftChild == null && root.rightChild == null)
				return null;
			else if(root.leftChild == null) // if only left child null
				return root.rightChild;
			else if(root.rightChild == null) //if only right child null
				return root.leftChild;
			else {// both child are NOT null
				int minInRightSubtree = findMin(root.rightChild); // find min in right subtree
				root.data = minInRightSubtree;
				root.rightChild = delete(root.rightChild,minInRightSubtree); // delete the copied value
			}
		}
		return root;
	}
	
	// Time complexity O(log n), best case - O(height)
	public boolean search(Node root, int element){
		if(root == null) 
			return false;
		if(root.data == element) 
			return true;
		if(element <= root.data) 
			return search(root.leftChild, element);
		else 
			return search(root.rightChild, element);
	}
	
	private Node find(Node root, int element){
		if(root == null) 
			return null;
		if(root.data == element) 
			return root;
		if(element <= root.data) 
			return find(root.leftChild, element);
		else 
			return find(root.rightChild, element);
	}
	
	public int findMax(Node root) {
		if(root == null)
			return -1;
		if(root.rightChild == null)
			return root.data;
		else
			return findMax(root.rightChild);
	}
	
	public int findMin(Node root) {
		if(root == null)
			return -1;
		if(root.leftChild == null)
			return root.data;
		else
			return findMin(root.leftChild);
	}
	
	// Time complexity O(n) - since we travel all the elements.
	public int findHeight(Node root) {
		if(root == null) {
			return -1;
		}
		int leftHeight = findHeight(root.leftChild);
		int rightHeight = findHeight(root.rightChild);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	// Tree traversal - process of visiting each node in a tree exactly once in some order.
	// Breadth-first / Level order traversal
	// Depth-first - Preorder (root,left,right), Inorder (left, root, right), Postorder (left, right, root)
	public void levelOrderTraversal() {
		if(root == null)
			return;
		ArrayList<Node> list = new ArrayList<Node>();
		list.add(root);
		while(!list.isEmpty()) {
			Node temp = list.remove(0);
			System.out.print(temp.data+" ");
			if(temp.leftChild != null)
				list.add(temp.leftChild);
			if(temp.rightChild != null)
				list.add(temp.rightChild);
		}
	}
	
	//Depth first traversal - root, left, right
	public void preorder(Node root) {
		if(root != null) {
			System.out.print(root.data+" ");
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}
	// Depth first traversal - left, right, root
	public void postorder(Node root) {
		if(root != null) {
			postorder(root.leftChild);
			postorder(root.rightChild);
			System.out.print(root.data+" ");
		}
	}
	// Depth first traversal - left, root, right
	public void inorder(Node root) {
		if(root != null) {
			inorder(root.leftChild);
			System.out.print(root.data+" ");
			inorder(root.rightChild);
		}
	}
	
	public boolean isBinarySearchTree(Node root) {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTUtil(Node root, int min, int max) {
		if(root == null)
			return true;
		if(root.data > min && root.data < max
			&& isBSTUtil(root.leftChild, min, root.data)
			&& isBSTUtil(root.rightChild, root.data, max))
			return true;
		return false;
	}
	
	public int getInorderSuccessor(int data) {
		Node current = find(root, data);
		if(current == null)
			return -1;
		if(current.rightChild != null) {
			return findMin(current.rightChild);
		}
		else {
			Node successor = null;
			Node ancestor = root;
			while(ancestor != current) {
				if(current.data < ancestor.data) {
					successor = ancestor;
					ancestor = ancestor.leftChild;
				}else {
					ancestor = ancestor.rightChild;
				}
			}
			return successor.data;
		}
	}
	
	//-----------------------------------------------------------------------
	// Non recursive methods below
	
	public void insert(int data) {
		Node node = new Node(data);
		if(root == null) {
			root  = node;
			return;
		}
		Node temp = root;
		while(true) {
			if(data <= temp.data) {
				if(temp.leftChild != null) {
					temp = temp.leftChild;
				}
				else {
					temp.leftChild = node;
					break;
				}
			}else {
				temp = temp.rightChild;
				if(temp.rightChild != null) {
					temp = temp.rightChild;
				}
				else {
					temp.rightChild = node;
					break;
				}
			}
		}
	}
	
	public int findMax() {
		if(root == null)
			return -1;
		Node temp = root;
		while(temp.rightChild != null) {
			temp = temp.rightChild;
		}
		return temp.data;
	}
	
	public int findMin() {
		if(root == null)
			return -1;
		Node temp = root;
		while(temp.leftChild != null) {
			temp = temp.leftChild;
		}
		return temp.data;
	}
}
