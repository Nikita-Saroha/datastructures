package com.ds.study.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BinarySearchTreeTest{
	
	BinarySearchTree bst;
	
	
	/**
	 * The input Binary Search Tree
	 * 				4
	 * 			   / \
	 * 			  3	  5
	 * 			 /	   \
	 * 			1		10
	 * 		   / \	   /  \
	 * 		  0	  2	  6    11
	 * 				   \
	 * 					8
	 */
	@Before
	public void init() {
		bst = new BinarySearchTree();
		bst.insert(bst.getRoot(), 4);
		bst.insert(bst.getRoot(), 5);
		bst.insert(bst.getRoot(), 10);
		bst.insert(bst.getRoot(), 3);
		bst.insert(bst.getRoot(), 6);
		bst.insert(bst.getRoot(), 1);
		bst.insert(bst.getRoot(), 8);
		bst.insert(bst.getRoot(), 2);
		bst.insert(bst.getRoot(), 11);
		bst.insert(bst.getRoot(), 0);
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
	}
	
	@Test
	public void testInsert() {
		BinarySearchTree bst = new BinarySearchTree();
		BinarySearchTree.Node root = bst.insert(bst.getRoot(), 4);
		Assert.assertEquals(root, bst.getRoot());
		bst.insert(2);
		Assert.assertEquals(2, bst.getRoot().leftChild.data);
	}
	
	
	@Test
	public void testSearch() {
		Assert.assertEquals(true, bst.search(bst.getRoot(), 6));
		Assert.assertEquals(false, bst.search(bst.getRoot(), 7));
	}
	
	@Test
	public void testFindMax() {
		Assert.assertEquals(11, bst.findMax());
		Assert.assertEquals(11, bst.findMax(bst.getRoot()));
	}
	
	@Test
	public void testFindMin() {
		Assert.assertEquals(0, bst.findMin());
		Assert.assertEquals(0, bst.findMin(bst.getRoot()));
	}
	
	@Test
	public void testFindHeight() {
		Assert.assertEquals(4, bst.findHeight(bst.getRoot()));
	}
	
	@Test
	public void testTraversal() {
		System.out.println("--------- Traversals ---------");
		System.out.println("level order:-");
		bst.levelOrderTraversal(); // 4 3 5 1 10 0 2 6 11 8 
		System.out.println("\npreorder:-");
		bst.preorder(bst.getRoot()); // 4 3 1 0 2 5 10 6 8 11 
		System.out.println("\npostorder:-");
		bst.postorder(bst.getRoot()); // 0 2 1 3 8 6 11 10 5 4 
		System.out.println("\ninorder:-");
		bst.inorder(bst.getRoot()); // 0 1 2 3 4 5 6 8 10 11 
	}
	
	@Test
	public void testIsBinarySearchTree() {
		boolean isBST = bst.isBinarySearchTree(bst.getRoot());
		Assert.assertEquals(true, isBST);
	}
	
	/**
	 * The Binary Search Tree after deletion below
	 * 				5
	 * 			   / \
	 * 			  3	  10
	 * 			 /	 /  \
	 * 			1	6	11
	 * 		   / \	 \    
	 * 		  0	  2	  8    
	 */
	@Test
	public void testDeleteNode() {
		boolean isDeleted = bst.deleteNode(100);
		Assert.assertEquals(false, isDeleted);
		
		isDeleted = bst.deleteNode(4);
		Assert.assertEquals(true, isDeleted);
		Assert.assertEquals(5, bst.getRoot().data);
		System.out.println("Afeter deletion:-");
		bst.preorder(bst.getRoot());
		System.out.println();
	}
	
	@Test
	public void testGetInorderSuccessor() {
		int successorValue = bst.getInorderSuccessor(2);
		Assert.assertEquals(3, successorValue);
		successorValue = bst.getInorderSuccessor(8);
		Assert.assertEquals(10, successorValue);
	}
	
	/** This below is a BST but it is not balanced
	 * 						20
	 * 					   /	
	 * 					  6
	 * 					 / \
	 * 					2	7
	 * 					 \	 \
	 * 					  4	  8
	 * 					 /	   \
	 * 					3		11
	 * 							 \
	 * 							  12
	 * 							   \
	 * 								18
	 * 								/
	 * 							  17
	 */	
	
	public void testgetBalancedBST() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(bst.getRoot(), 20);
		bst.insert(bst.getRoot(), 6);
		bst.insert(bst.getRoot(), 7);
		bst.insert(bst.getRoot(), 8);
		bst.insert(bst.getRoot(), 2);
		bst.insert(bst.getRoot(), 4);
		bst.insert(bst.getRoot(), 3);
		bst.insert(bst.getRoot(), 11);
		bst.insert(bst.getRoot(), 12);
		bst.insert(bst.getRoot(), 18);
		bst.insert(bst.getRoot(), 17);
	}
}
