import java.io.*;
import java.util.*;

class BinaryTree{

	static class Node{
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
			left = right=null;
		}
	
	}
	Node root1,root2;
	
	BinaryTree(){
		root1 = null;
		root2 = null;
	}
	
	
	static boolean isIdentical(Node root1, Node root2){
	
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.key == root2.key && isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right)){
		
			return true;
		}
		return false;
	
	}
	
	static boolean isSubtree(Node S, Node T){
		if(S==null)
			return true;
		if(T==null)
			return false;
		if(isIdentical(S,T))
			return true;
		return isSubtree(S.left,T.left)||isSubtree(S.right, T.right);
	
	
	}
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		
		tree.root1 = new Node(1);
		tree.root1.left = new Node(2);
		tree.root1.right = new Node(3);
		tree.root1.right.left = new Node(4);
		tree.root1.right.right = new Node(5);
		tree.root1.left.left = new Node(6);
		tree.root1.left.right  = new Node(7);
		
		tree.root2 = new Node(1);
		tree.root2.left = new Node(9);
		tree.root2.right = new Node(8);
		tree.root2.right.left = new Node(4);
		tree.root2.right.right = new Node(5);
		tree.root2.left.left = new Node(6);
		tree.root2.left.right  = new Node(8);
		System.out.println(tree.isSubtree(tree.root1, tree.root2)) ;
	
	}
	}
