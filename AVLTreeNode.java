//helper AVLTreenode class of type Person and used in both AVLs(AVLTreeName&AVLPhoneNo)
//the class was created  in order to have a more proper way of information hiding and encapsulation(through the private fields)
public class AVLTreeNode<Person> {

	private AVLTreeNode<Person> root;// Reference to the root of the AVLTree
	private Person data;
	private String key;
	private AVLTreeNode<Person> leftChild; // Reference to the left child
	private AVLTreeNode<Person> righChild; // Reference to the right child
	private AVLTreeNode<Person> parent; // Refernce to parent
	private int balance;
	private int height;

	public AVLTreeNode(String key, Person data) {
		this.key = key;
		this.data = data;
		this.height = 0;
		this.balance = 0;
	}

	// getter methods
	// get the data of AVLTreeNode
	public Person getData() {
		return data;
	}

	public String getKey() {
		return key;
	}

	// returns the left child of the AVLTreeNode
	public AVLTreeNode<Person> getLeft() {
		return leftChild;
	}

	// returns the right child of the AVLTreeNode
	public AVLTreeNode<Person> getRight() {
		return righChild;
	}

	// returns the root of the AVLTreeNode
	public AVLTreeNode<Person> getRoot() {
		return root;
	}

	// returns the root of the AVLTreeNode
	public AVLTreeNode<Person> getParent() {
		return parent;
	}

	// returns the balance of the AVLTreeNode
	public int getBalance() {
		return balance;
	}

	// Returns the height of the AVLTreeNode
	public int getHeight() {
		return height;
	}

	// setter methods
	// sets the height of the AVLTreeNode
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	// sets the balance of the AVLTreeNode
	public void setBalance(int newBalance) {
		balance = newBalance;
	}

	// sets the key of the AVLTreeNode
	public void setKey(String newKey) {
		key = newKey;
	}

	// sets the data of the AVLTreeNode
	public void setData(Person newPerson) {
		data = newPerson;
	}

	// sets the left child of the AVLTreeNode
	public void setLeft(AVLTreeNode<Person> newLeftChild) {
		leftChild = newLeftChild;
	}

	// sets the right child of the AVLTreeNode
	public void setRight(AVLTreeNode<Person> newRightChild) {
		righChild = newRightChild;
	}

	// sets the parent of the AVLTreeNode
	public void setParent(AVLTreeNode<Person> newParent) {
		parent = newParent;
	}

}
