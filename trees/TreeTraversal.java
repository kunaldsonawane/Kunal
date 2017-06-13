import java.io.*;
import java.util.*;

class BinaryTree{

	static class Node{
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
			left = right = null;
		}
	
	}
	
	Node root;
	BinaryTree(){
		root=null;
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
	
	static void printPostOrder(Node root){
		if(root == null)
			return;
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.key+" ");
		
	
	}
	static void printPreOrder(Node root){
		if(root == null)
			return;
		System.out.print(root.key+" ");
		printPreOrder(root.left);
		printPreOrder(root.right);
		
	}
	static void printInorder(Node root){
	
		if(root == null){
			return;
		}
		printInorder(root.left);
		System.out.print(root.key+" ");
		printInorder(root.right);
	
	}

	
	static void printLevelOrder(Node root){
		int ht =height(root);
		System.out.println("ht: "+ht);
		for(int i=1;i<=ht;i++){
			int c=1;
			printLevels(root,i,c);
			
			}
	
	}
	
	static void printLevels(Node root, int level, int c){
		
		if(root == null)
			return;
		if(level == 1 && c==1){
			System.out.print(root.key+" ");
			c++;
			}
		else{
			printLevels(root.right,level-1,c++);
			printLevels(root.left, level-1,c++);
		
		}
		
	}
	
	
	int diameter(Node root){
		if(root == null){
			return 0;
		}
		
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		return Math.max(lheight+rheight+1, Math.max(ldiameter,rdiameter));
	
	
	}
	public static void main(String args[]){
	
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.right.right = new Node(8);
		tree.printInorder(tree.root);
		System.out.println();
		tree.printPostOrder(tree.root);
		System.out.println();
		tree.printPreOrder(tree.root);
		System.out.println();
		System.out.println(tree.height(tree.root));
		tree.printLevelOrder(tree.root);
		
		System.out.println(tree.diameter(tree.root));
		
	}

}
