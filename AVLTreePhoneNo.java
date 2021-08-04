import java.util.ArrayList;

//The AVLTreePhoneNo child class extends the parent AVLTree parent class
public class AVLTreePhoneNo extends AVLTree {

	public AVLTreePhoneNo(AVLTreeNode<Person> rootPhoneNumber) {
		super(rootPhoneNumber);
	}

	// A search method that takes a phone number and returns that person’s number &
	// returns null if not in the tree
	// This method has a worst case time complexity of O(logN), where N is the
	// number of nodes and log N is the height of the tree
	public Person searchByPhoneNumber(String phoneNumber) {

		AVLTreeNode<Person> current = root;
		while (current != null) {
			if (phoneNumber == current.getKey()) {

				return current.getData();
			} else if (phoneNumber.compareTo(current.getKey()) < 0)
				current = current.getLeft();
			else
				current = current.getRight();

		}
		return null;
	}

	// Insert method that takes a person object and returns true if added and False
	// if the phone number is already exist.
	// This method has a worst case time complexity of O(logN), where N is the
	// number of nodes and log N is the height of the tree
	public boolean insertAVLTreeNode(Person data) {

		// Find the parent of the new AVLTreeNode Person data
		AVLTreeNode<Person> parent = null;
		AVLTreeNode<Person> current = root;
		while (current != null) {
			if (data.getName().compareTo(current.getData().getName()) == 0) {
				return false;
			}
			if (!current.getData().equals(data)) {

				// check for either phoneNo or name of the person
				if (data.getPhoneNumber().compareTo(current.getKey()) < 0) {
					parent = current;
					current = current.getLeft();
				} else if (data.getPhoneNumber().compareTo(current.getKey()) > 0) {
					parent = current;
					current = current.getRight();
				} else
					return false; // Duplicate Phone Number won't not insert
			} else {
				return false; // Duplicate Person won't insert
			}
		}
		// Create the new AVLTreeNode and attach it to the parent AVLTreeNode
		if (root == null)
			root = new AVLTreeNode<Person>(data.getPhoneNumber(), data); // Create a new root
		else if (data.getPhoneNumber().compareTo(parent.getKey()) < 0)
			parent.setLeft(new AVLTreeNode<Person>(data.getPhoneNumber(), data));
		else
			parent.setRight(new AVLTreeNode<Person>(data.getPhoneNumber(), data));

		return true;
	}

	// Insert an element and re-balance if necessary
	// This method has a worst case time complexity of O(logN), where N is the
	// number of nodes and log N is the height of the tree
	public boolean insert(Person data) {
		boolean successful = insertAVLTreeNode(data);
		if (!successful)
			return false; // e is already in the tree
		else {
			balancePath(data); // Balance from e to the root if necessary
		}
		return true; // e is inserted
	}

	// Delete an element from the binary tree and returns true if the element is
	// deleted successfully & false if the element is not in the tree
	// This method has a worst case time complexity of O(logN), where N is the
	// number of nodes and log N is the height of the tree
	public boolean delete(Person data) {
		if (root == null)
			return false; // Element is not in the tree
		// Locate the AVLTreeNode to be deleted and also locate its parent AVLTreeNode
		AVLTreeNode<Person> parent = null;
		AVLTreeNode<Person> current = root;
		while (current != null) {
			if (data.getPhoneNumber().compareTo(current.getKey()) < 0) {
				parent = current;
				current = current.getLeft();
			} else if (data.getPhoneNumber().compareTo(current.getKey()) > 0) {
				parent = current;
				current = current.getRight();
			} else
				break; // Element is in the tree pointed by current
		}
		if (current == null)
			return false; // Element is not in the tree
		// Case 1: current has no left children
		if (current.getLeft() == null) {
			// Connect the parent with the right child of the current AVLTreeNode
			if (parent == null) {
				root = current.getRight();
			} else {
				if (data.getPhoneNumber().compareTo(parent.getKey()) < 0)
					parent.setLeft(current.getRight());
				else
					parent.setRight(current.getRight());
				// Balance the tree if necessary
				balancePath(parent.getData());
			}
		} else {
			// Case 2: The current AVLTreeNode has a left child
			// Locate the rightmost AVLTreeNode in the left subtree of
			// the current AVLTreeNode and also its parent
			AVLTreeNode<Person> parentOfRightMost = current;
			AVLTreeNode<Person> rightMost = current.getLeft();
			while (rightMost.getRight() != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.getRight();
			}
			// Replace the element in current by the element in rightMost
			current.setData(rightMost.getData());
			// Eliminate rightmost AVLTreeNode
			if (parentOfRightMost.getRight() == rightMost)
				parentOfRightMost.setRight(rightMost.getLeft());
			else
				// Special case: parentOfRightMost is current
				// Balance the tree if necessary
				balancePath(parentOfRightMost.getData());
		}

		return true; // Element is sucessfully deleted
	}

	// Balance the AVLTreeNodes in the path from the specified AVLTreeNode to the
	// root if necessary
	// The balancePath method is executed in constant time for a node in the path
	// and has a worst case time compliecity of O(1)
	public void balancePath(Person data) {
		ArrayList<AVLTreeNode<Person>> path = path(data);
		for (int i = path.size() - 1; i >= 0; i--) {
			AVLTreeNode<Person> A = (AVLTreeNode<Person>) (path.get(i));
			updateHeight(A);
			updateBalance(A);
			AVLTreeNode<Person> parentOfA = (A == root) ? null : (AVLTreeNode<Person>) (path.get(i - 1));
			switch (balanceFactor(A)) {
			case -2:
				if (balanceFactor((AVLTreeNode<Person>) A.getLeft()) <= 0) {
					balanceLL(A, parentOfA); // Perform Left-Left rotation
				} else {
					balanceLR(A, parentOfA); // Perform Left-Right rotation
				}
				break;
			case +2:
				if (balanceFactor((AVLTreeNode<Person>) A.getRight()) >= 0) {
					balanceRR(A, parentOfA); // Perform Right-Right rotation
				} else {
					balanceRL(A, parentOfA); // Perform Right-Left rotation
				}
			}
		}
	}

	// Return an array list of AVLTreeNodes
	public ArrayList<AVLTreeNode<Person>> path(Person data) {
		ArrayList<AVLTreeNode<Person>> list = new ArrayList<>();
		AVLTreeNode<Person> current = root; // Start from the root
		while (current != null) {
			list.add(current); // Add the AVLTreeNode to the list
			if (data.getPhoneNumber().compareTo(current.getKey()) < 0) {
				current = current.getLeft();
			} else if (data.getPhoneNumber().compareTo(current.getKey()) > 0) {
				current = current.getRight();
			} else
				break;
		}
		return list;
	}

}
