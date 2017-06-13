import java.io.*;
import java.util.*;

class BinarySearchTree{

	static class Node{
		int key;
		Node left;
		Node right;
	
	Node(int key){
		this.key = key;
		left= right = null;
	}
	}
	static Node root;
	static Node pre, suc;
	BinarySearchTree(){
		root = null;
	}
	
	static void insert(int value){
		 root =  insertValue(root,value);
	
	}
	static Node insertValue(Node root, int value){
	
		if(root == null)
		{
			root = new Node(value);
			return root;
		}
		if(value < root.key)
			root.left =  insertValue(root.left, value);
		else if(value > root.key)
		root.right = insertValue(root.right, value);
		
		return root;
	
	}
	
	
	static void deleteKey(int key){
		root = deleteRec(root,key);
	
	}
	
	static Node deleteRec(Node root, int key){
	
		if(root == null)
			return root;
		if(key<root.key)
			root.left = deleteRec(root.left,key);
		else if(key>root.key)
			root.right = deleteRec(root.right, key);
		else{
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
				
				
			root.key = inorderSuccessor(root.right);
			
			root.right = deleteRec(root.right, key);
		}
		return root;
	
	}
	
	static int inorderSuccessor(Node root){
		int minv = root.key;
		while(root.left!=null){
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}
	
	static void printInorder(Node root){
		if(root!=null){
			printInorder(root.left);
			System.out.print(root.key+" ");
			printInorder(root.right);
		
		}
	
	}
	
	
	static void findPreSuc(Node root,  int key){
		if(root == null) return;
		
		if(root.key == key){
			if(root.left!=null){
			Node tmp = root.left;
			while(tmp.right!=null){
				
				tmp = tmp.right;
			}
			pre = tmp;
			
			}
			
			if(root.right!=null){
				Node tmp = root.right;
				while(tmp.left!=null){
					tmp = tmp.left;
				}
			suc = tmp;
			
			}
			return;
		}
		if(root.key > key){
			suc = root;
			findPreSuc(root.left, key);
		}
		else{
		
			pre = root;
			findPreSuc(root.right,  key);
	
		}
			
	
	
	}
	
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
		bst.printInorder(bst.root);
		//bst.deleteKey(40);
		//bst.printInorder(bst.root);
		
		 pre=null;suc=null;
		bst.findPreSuc(bst.root ,65);
		System.out.println();
		if(pre!=null && suc!=null)
		System.out.println(pre.key+" "+suc.key);
		
	}

}
