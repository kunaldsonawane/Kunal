import java.io.*;
import java.util.*;
import java.util.Map.Entry;

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
	
		root = null; 
	}
	
	static class QItem{
	
		Node node;
		int hd;
		QItem(Node node, int hd){
			this.node = node;
			this.hd = hd;
		}
	
	}
	
	static int max_level = 0;
	static void printLeftView(Node root, int level){
		
		if(root == null) return;
		if(level > max_level){
			max_level = level;
			System.out.print(root.key+" ");
		}
		
		printLeftView(root.left, level+1);
		printLeftView(root.right,level+1);
	
	}
	static void printRightView(Node root, int level){
		
		if(root == null) return;
		if(level > max_level){
			max_level = level;
			System.out.print(root.key+" ");
		}
		
		printRightView(root.right, level+1);
		printRightView(root.left,level+1);
	
	}
	
	static void printTopView(Node root){
		if(root == null)return;
		HashSet<Integer> set = new HashSet<Integer>();
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<QItem> q = new LinkedList<QItem>();
		q.add(new QItem(root,0));
		while(!q.isEmpty()){
		
			QItem qi = q.remove();
			Node n = qi.node;
			int hd = qi.hd;
				
			if(!set.contains(hd)){
				set.add(hd);
				map.put(hd,n.key);
				//System.out.print(n.key+" ");
			
			}
			
			if(n.left!=null)
				q.add(new QItem(n.left,hd-1));
			if(n.right!=null)
				q.add(new QItem(n.right, hd+1));
		
		
		}
		Set<Entry<Integer, Integer>> set1 = map.entrySet();
	 
		// Make an iterator
		Iterator<Entry<Integer, Integer>> iterator = set1.iterator();
	 
		// Traverse the map elements using the iterator.
		while (iterator.hasNext())
		{
		    Map.Entry<Integer, Integer> me = iterator.next();
		    System.out.print(me.getValue()+" ");
		}
	
	
	
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
		
		tree.printLeftView(tree.root,1);
		max_level=0;
		System.out.println();
		tree.printRightView(tree.root,1);
		System.out.println();
		tree.printTopView(tree.root);
	
	}

}
