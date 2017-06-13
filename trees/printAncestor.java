import java.io.*;
import java.util.*;

class BinaryTree{

	static class Node{
	
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
		}
	}
	
	Node root;
	BinaryTree(){
		root = null;
	}
	
	static boolean printAncestors(Node root, int target){
		if(root == null)
			return false;
		if(root.key == target)
			return true;
		if(printAncestors(root.left,target)||printAncestors(root.right,target)){
			System.out.print(root.key+" ");
			return true;
		
		}
		return false;
	
	
	
	}
	
	public static void main(String args[]){
	
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.printAncestors(tree.root, 4);
		System.out.println(Integer.bitCount(15));
			
	}
}

