//To avoid repeated code, the AVLTree parent class is created so that it can be extended by the child classes (AVLTreePhoneNo & AVLTreeName)
public class AVLTree {
    
	AVLTreeNode<Person> root;

	public AVLTree(AVLTreeNode<Person> root) {
      this.root = root;
	}

	//Returns the balance factor of the AVLTreeNode 
	//The balanceFactor method has a worst case time complexity of O(1) since it is executed in a constant time for each node in the path
	public int balanceFactor(AVLTreeNode<Person> AVLTreeNode) {
		int balanceFactor = 0;
		if (AVLTreeNode.getRight() == null) {// AVLTreeNode has no right subtree
			balanceFactor = -AVLTreeNode.getHeight();
	    	
		}
		else if (AVLTreeNode.getLeft() == null) // AVLTreeNode has no left subtree
			balanceFactor =  +AVLTreeNode.getHeight();
		else
			balanceFactor =  ((AVLTreeNode<Person>) AVLTreeNode.getRight()).getHeight() - ((AVLTreeNode<Person>) AVLTreeNode.getLeft()).getHeight();
		return balanceFactor;
	}
	
	//Update the balance of a specified AVLTreeNode 
	//The updateBalance method has a worst case time complexity of O(1) since it is executed in a constant time for each node in the path
	public void updateBalance(AVLTreeNode<Person> AVLTreeNode)
	{
		AVLTreeNode.setBalance(balanceFactor(AVLTreeNode));
	}

	//Update the height of a specified AVLTreeNode 
	//The updateHeight method has a worst case time complexity of O(1) since it is executed in a constant time for each node in the path
	public void updateHeight(AVLTreeNode<Person> AVLTreeNode) {
		if (AVLTreeNode.getLeft() == null && AVLTreeNode.getRight() == null) // AVLTreeNode is a leaf
			AVLTreeNode.setHeight(0); 
		else if (AVLTreeNode.getLeft() == null) // AVLTreeNode has no left subtree
			AVLTreeNode.setHeight(1 + ((AVLTreeNode<Person>) AVLTreeNode.getRight()).getHeight());
		else if (AVLTreeNode.getRight() == null) // AVLTreeNode has no right subtree
			AVLTreeNode.setHeight(1 + ((AVLTreeNode<Person>) AVLTreeNode.getLeft()).getHeight());
		else
			AVLTreeNode.setHeight(1 + Math.max(((AVLTreeNode<Person>) (AVLTreeNode.getRight())).getHeight(), ((AVLTreeNode<Person>) (AVLTreeNode.getLeft())).getHeight()));
	}
	
	//Balance Left-Left Rotation (i.e left-heavy,left-heavy tree rotation)
	//This method has a worst case time complexity of O(1) since the method is executed in a constant time for each node in the path
	public void balanceLL(AVLTreeNode<Person> A, AVLTreeNode<Person> parentOfA) {
		AVLTreeNode<Person> B = A.getLeft(); // A is left-heavy and B is left-heavy
		if (A == root) {
			root = B;
		} else {
			if (parentOfA.getLeft() == A) {
				parentOfA.setLeft(B);
			} else {
				parentOfA.setRight(B);
			}
		}
		A.setLeft(B.getRight()); // 
		B.setRight(A); // Make A the left child of B
		
		// Update heights
		updateHeight((AVLTreeNode<Person>) A);
		updateHeight((AVLTreeNode<Person>) B);
		
		// Update balance
		updateBalance(A);
		updateBalance(B);
	}

	//Balance Right-Right Rotation (i.e right-heavy,right-heavy tree rotation)
	//This method has a worst case time complexity of O(1) since the method is executed in a constant time for each node in the path
	public void balanceRR(AVLTreeNode<Person> A, AVLTreeNode<Person> parentOfA) {
		AVLTreeNode<Person> B = A.getRight(); // A is right-heavy and B is right-heavy
		if (A == root) {
			root = B;
		} else {
			if (parentOfA.getLeft() == A) {
				parentOfA.setLeft(B);
			} else {
				parentOfA.setRight(B);
			}
		}
		A.setRight(B.getLeft()); 
		B.setLeft(A);
		
		// Update heights
		updateHeight((AVLTreeNode<Person>) A);
		updateHeight((AVLTreeNode<Person>) B);
		
		// Update balances
		updateBalance(A);
		updateBalance(B);
	}

	//Balance Left-Right rotation (i.e left-heavy,right-heavy tree rotation)
	//This method has a worst case time complexity of O(1) since the method is executed in a constant time for each node in the path
	public void balanceLR(AVLTreeNode<Person> A, AVLTreeNode<Person> parentOfA) {
		AVLTreeNode<Person> B = A.getLeft(); // A is left-heavy
		AVLTreeNode<Person> C = B.getRight(); // B is right-heavy
		if (A == root) {
			root = C;
		} else {
			if (parentOfA.getLeft() == A) {
				parentOfA.setLeft(C);
			} else {
				parentOfA.setRight(C);
			}
		}
		A.setLeft(C.getRight()); 
		B.setRight(C.getLeft()); 
		C.setLeft(B);
		C.setRight(A);
		
		// Update heights
		updateHeight((AVLTreeNode<Person>) A);
		updateHeight((AVLTreeNode<Person>) B);
		updateHeight((AVLTreeNode<Person>) C);
		
		// Update balance
		updateBalance(A);
		updateBalance(B);
		updateBalance(C);
	}

	//Balance Right-Left Rotation (i.e right-heavy,left-heavy tree rotation)
	//This method has a worst case time complexity of O(1) since the method is executed in a constant time for each node in the path
	public void balanceRL(AVLTreeNode<Person> A, AVLTreeNode<Person> parentOfA) {
		AVLTreeNode<Person> B = A.getRight(); // A is right-heavy
		AVLTreeNode<Person> C = B.getLeft(); // B is left-heavy
		if (A == root) {
			root = C;
		} else {
			if (parentOfA.getLeft() == A) {
				parentOfA.setLeft(C);
			} else {
				parentOfA.setRight(C);
			}
		}
		A.setRight(C.getLeft()); 
		B.setLeft(C.getRight());
		C.setLeft(A);
		C.setRight(B);
	
		// Update heights
		updateHeight((AVLTreeNode<Person>)A);
		updateHeight((AVLTreeNode<Person>) B);
		updateHeight((AVLTreeNode<Person>) C);
		
		// Update balance
		updateBalance(A);
		updateBalance(B);
		updateBalance(C);
	}

	//This method prints InOrder (i.e it will print all persons in the phone book in the ascending order of the key)
	public void inOrder(AVLTreeNode<Person> root) {
		if (root == null) {
			return;
		}
		inOrder(root.getLeft());
		System.out.println(root.getData().toString() + " ");
		inOrder(root.getRight());
	}
}
