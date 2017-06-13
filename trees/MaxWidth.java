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
	Node root;
	
	BinaryTree(){
		root = null;
	
	}
	
	static int height(Node root){
	
		if(root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		if(lheight > rheight)
			return lheight+1;
		return rheight+1;
	
	}
	
	
	static int getMaxWidth(Node root){
		int ht = height(root);
		int maxWidth = 0;
		for(int i=1;i<=ht;i++){
			int width = calculateWidth(root,i);
			if(width > maxWidth){
				maxWidth = width;
			}
		}
		return maxWidth;
	
	
	
	}
	static int calculateWidth(Node root, int level){
		if(root == null)
			return 0;
		if(level == 1)
			return 1;
		else{
		return calculateWidth(root.left, level-1)+calculateWidth(root.right, level -1);
		
		
		}
	
	}
	
	public static void main(String args[]){
	
		BinaryTree tree= new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(5);
		tree.root.left.left = new Node(6);
		tree.root.left.right  = new Node(7);
		
		
		System.out.println(tree.getMaxWidth(tree.root));
	
	
	}


}
