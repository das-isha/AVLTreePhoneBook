//AVLTreePhoneBook class that implements the Phonebook interface 
public class AVLTreePhBook implements PhoneBook<Person> {

	AVLTreePhoneNo avlTreePhoneNo;
	AVLTreeName avlTreeName;
	AVLTreeNode<Person> rootName;
	AVLTreeNode<Person> rootPhoneNo;

	public AVLTreePhBook() {
		rootName = null;
		rootPhoneNo = null;
		avlTreePhoneNo = new AVLTreePhoneNo(rootPhoneNo);
		avlTreeName = new AVLTreeName(rootName);

	}

	@Override
	//an insert method that takes in a name and phone number & returns "true" if the new entry is added or "false" otherwise
	//This method has a worst case time complexity of O(logN), where N is the number of nodes and log N is the height of the tree
	public boolean PhbBInsert(String name, String phoneNumber) {
		Person p = new Person(name, phoneNumber);
		return avlTreePhoneNo.insert(p) && avlTreeName.insert(p);

	}

	@Override
	//a delete method that takes a name and phone number and returns ”true” if successfully deleted & ”false” if it does not exist
	//This method has a worst case time complexity of O(logN), where N is the number of nodes and log N is the height of the tree
	public boolean PhbBDelete(String name, String phoneNumber) {
		Person p = new Person(name, phoneNumber);
		return avlTreePhoneNo.delete(p) && avlTreeName.delete(p);
	}

	@Override
	//a search method that takes a phonenumber and returns that person and returns null if it is not in the tree
	//This method has a worst case time complexity of O(logN), where N is the number of nodes and log N is the height of the tree
	public Person PhbBPhoneSeach(String phoneNumber) {
		return avlTreePhoneNo.searchByPhoneNumber(phoneNumber);
	}

	@Override
	//a search method that takes a name and returns that person and returns null if it is not in the tree
	//This method has a worst case time complexity of O(logN), where N is the number of nodes and log N is the height of the tree
	public Person PhbNameSeach(String name) {
		return avlTreeName.searchByName(name);
	}

}