public class BinarySearchTreeDemo {
	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int value) {
			this.value = value;
		}
	}

	static class BinarySearchTree {

		TreeNode root;

		public TreeNode findValue(TreeNode current, int target) {
			if (current == null) {
				return null;
			}

			if (current.value == target) {
				return current;
			}

			if (target < current.value) {
				return findValue(current.left, target);
			} else {
				return findValue(current.right, target);
			}
		}

		public TreeNode find(int target) {
			return findValue(root, target);
		}

		public void insertNode(TreeNode current, int newValue) {
			if (newValue == current.value) {
				System.out.println("Valor duplicado");
				return;
			}

			if (newValue < current.value) {
				if(current.left != null) {
					insertNode(current.left, newValue);
				} else {
					current.left = new TreeNode(newValue);
					current.left.parent = current;
				}
			}  else {
				if(current.right != null) {
					insertNode(current.right, newValue);
				} else {
					current.right = new TreeNode(newValue);
					current.right.parent = current;
				}
			}
		}

		public void insert(int newValue) {
			if (root == null) {
				root = new TreeNode(newValue);
			} else {
				insertNode(root, newValue);
			}
		}

		private void inorderRec(TreeNode node) {
			if (node != null) {
				inorderRec(node.left);
				System.out.print(node.value + " ");
				inorderRec(node.right);
			}
		}

		public void inorder() {
			System.out.print("Recorrido In-Order: ");
			inorderRec(root);
			System.out.println();
		}

		public void preorder(TreeNode node) {
			if (node != null) {
				System.out.print(node.value + " "); 
				preorder(node.left);            
				preorder(node.right);         
			}
		}

		public void preorder() {
			System.out.print("Recorrido Pre-Order: ");
			preorder(root);
			System.out.println();
		}

		public void postorder(TreeNode node) {
		    if (node != null) {
		        postorder(node.left);  
		        postorder(node.right);  
		        System.out.print(node.value + " ");  
		    }
		}

		public void postorder() {
		    System.out.print("Recorrido Post-Order: ");
		    postorder(root);
		    System.out.println();
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();

		System.out.println("Creando árbol binario de búsqueda");
		int[] values = {8,3,10,1,6,14,4,7,13};
		for(int v : values) {
			tree.insert(v);
		}

		tree.inorder();
		tree.preorder();
		tree.postorder();
	}
}
