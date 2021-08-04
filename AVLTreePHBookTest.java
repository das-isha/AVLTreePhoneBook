//Test Class for PhoneBook to test the Insert, Delete, Search by PhoneNumber and Name methods
public class AVLTreePHBookTest {

	public static void main(String[] args) {

		try {
			AVLTreePhBook avlTreePhBook = new AVLTreePhBook();

			avlTreePhBook.PhbBInsert("Tina", "0000000030");
			avlTreePhBook.PhbBInsert("Rosy", "1111113467");
			avlTreePhBook.PhbBInsert("Isha", "4356789234");
			avlTreePhBook.PhbBInsert("Alie", "2134567890");
			avlTreePhBook.PhbBInsert("Dave", "8608302732");
			avlTreePhBook.PhbBInsert("Jane", "6437890667");
			avlTreePhBook.PhbBInsert("Zain", "7324456889");
			avlTreePhBook.PhbBInsert("Sami", "9997778989");
			avlTreePhBook.PhbBInsert("Cari", "3567892341");

			System.out.println("Printing AVL Tree after inserting using AVLTreePhoneNo: ");
			System.out.println("");
			avlTreePhBook.avlTreePhoneNo.inOrder(avlTreePhBook.avlTreePhoneNo.root);
			System.out.println();
			System.out.println("Printing AVL Tree after inserting using AVLTreeName: ");
			System.out.println("");
			avlTreePhBook.avlTreeName.inOrder(avlTreePhBook.avlTreeName.root);
			System.out.println("===================================================================");
			String searchPhoneNumber = "4356789234";
			// String searchPhoneNumber = "9999999999";
			// The statement above returns null since it does not exist in the phonebook
			Person searchedPersonByPhoneNo = avlTreePhBook.PhbBPhoneSeach(searchPhoneNumber);
			if (searchedPersonByPhoneNo != null) {
				System.out.println("Person name and phone number with searched phone number " + searchPhoneNumber
						+ " -> " + searchedPersonByPhoneNo.toString());
			} else {
				System.out.println("The " + searchPhoneNumber + " doesnot exist in the AVL Double Tree book ");
			}

			String searchedName = "Zain";

			System.out.println("Person name and phone number with searched name  " + searchedName + " -> "
					+ avlTreePhBook.PhbNameSeach(searchedName).toString());
			System.out.println("====================================================================");
			System.out.println("Delete testing:(Jane, 6437890667) ");
			System.out.println("Printing AVL Tree after deleting using AVLTreePhoneNo: ");
			avlTreePhBook.PhbBDelete("Jane", "6437890667");
			System.out.println();
			avlTreePhBook.avlTreePhoneNo.inOrder(avlTreePhBook.avlTreePhoneNo.root);
			System.out.println("");
			System.out.println("Printing AVL Tree after deleting using AVLTree Name: ");
			System.out.println("");
			avlTreePhBook.avlTreeName.inOrder(avlTreePhBook.avlTreeName.root);

			System.out.println("=====================================================================");
			boolean testInsert = avlTreePhBook.PhbBInsert("Isha", "4356789234");
			// Returns False since it wont insert a person if the person already exists in
			// the AVL Tree
			System.out.println(
					"Testing can the method insert a person if the person exists in the AVL Tree?(True if it can & False if not:) "
							+ testInsert);

			boolean testDelete = avlTreePhBook.PhbBDelete("John", "111111111");
			// Returns False since it wont delete a person if the person already exists in
			// the AVL Tree
			System.out.println(
					"Testing can the method delete a person if the person doesn't exist in the AVL Tree?(True if it can & False if not:) "
							+ testDelete);
			System.out.println("======================================================================");

			System.out.println("");
			System.out.println("Printing AVL Tree after testing using AVLTreePhoneNo: ");
			System.out.println("");
			avlTreePhBook.avlTreePhoneNo.inOrder(avlTreePhBook.avlTreePhoneNo.root);
			System.out.println("");
			System.out.println("Printing AVL Tree after tesing AVLTree Name: ");
			System.out.println("");
			avlTreePhBook.avlTreeName.inOrder(avlTreePhBook.avlTreeName.root);
		} catch (Exception ex) {
			System.out.print("Please handle the error: " + ex.getMessage());
		}

	}
}
