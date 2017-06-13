class BinarySearchTree{

	static class Node{
		Node left;
		Node right;
		int key;
		Node(int key){
			this.key = key;
		}
	
	}
	static Node root;
	
	static Node first, second, pre;
	public static void correctBST(Node root){
		if(root == null)
			return;
		correctBST(root.left);
		
		if(pre == null){
		
			pre = root;
		
		}
		else {
		
			if(root.key < pre.key){
				if(first == null)
					first = pre;
			
				
			second = root;
			}
		pre =root;
		}
		
		
		correctBST(root.right);
	
	
	}
	public static void printInorder(Node root){
		if(root != null){
		
		printInorder(root.left);
		System.out.print(root.key+" ");
		printInorder(root.right);
		}
	}
	
	
	public static void main(String args[]){
	
		BinarySearchTree bst = new BinarySearchTree();
		pre = null;
		first = null;
		second = null;
		bst.root = new Node(4);
		bst.root.left = new Node(2);
		bst.root.right =  new Node(3);
		bst.printInorder(bst.root);
		bst.correctBST(bst.root);
		if(second!=null && first!=null){
		 int tmp = second.key;
		 second.key = first.key;
		 first.key = tmp;
		}
		bst.printInorder(bst.root);
		
	
	}


}
