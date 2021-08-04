import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//J-unit testing of Insert, Delete, and Search methods
class AVLUnitTest {
	
	AVLTreePhBook avlTreePhBook = new AVLTreePhBook();
	Person p1 = new Person("Tina", "0000000030");
	Person p2 = new Person("Rosy", "1111113467");
	Person p3 = new Person("Isha", "4356789234");
	Person p4 = new Person("Alie", "2134567890");
	Person p5 = new Person("Dave", "8608302732");
	Person p6 = new Person("Jane", "6437890667");
	Person p7 = new Person("Zain", "7324456889");
	Person p8 = new Person("Xyzv", "9997778989");
	Person p9 = new Person("Cari", "3567892341");
	// Same name and number already exists in the AVL tree.
	// It won't add ("Jane", "6437890667") to the both AVLTree
	Person p10 = new Person("Jane", "6437890667");

	// Test for PhbInsert( )
	@Test
	void testAVLTreePHBookAll() {

		// AVL Tree Insert testing for both AVLTreePhoneNo and AVLTreeName
		assertEquals("Insert testing for p1: ", true, avlTreePhBook.PhbBInsert(p1.getName(), p1.getPhoneNumber()));
		assertEquals("Insert testing for p2: ", true, avlTreePhBook.PhbBInsert(p2.getName(), p2.getPhoneNumber()));
		assertEquals("Insert testing for p3: ", true, avlTreePhBook.PhbBInsert(p3.getName(), p3.getPhoneNumber()));
		assertEquals("Insert testing for p4: ", true, avlTreePhBook.PhbBInsert(p4.getName(), p4.getPhoneNumber()));
		assertEquals("Insert testing for p5: ", true, avlTreePhBook.PhbBInsert(p5.getName(), p5.getPhoneNumber()));
		assertEquals("Insert testing for p6: ", true, avlTreePhBook.PhbBInsert(p6.getName(), p6.getPhoneNumber()));
		assertEquals("Insert testing for p7: ", true, avlTreePhBook.PhbBInsert(p7.getName(), p7.getPhoneNumber()));
		assertEquals("Insert testing for p8: ", true, avlTreePhBook.PhbBInsert(p8.getName(), p8.getPhoneNumber()));
		assertEquals("Insert testing for p9: ", true, avlTreePhBook.PhbBInsert(p9.getName(), p9.getPhoneNumber()));
		
		//this returns false since Name:"Jane", PhoneNo:"6437890667" already exists in the tree
		assertEquals("Insert testing for p11: ", false, avlTreePhBook.PhbBInsert(p10.getName(), p10.getPhoneNumber()));

		// AVL Tree Delete testing for both AVLTreePhoneNo and AVLTreeName
		assertEquals("Delete testing for p7: ", true, avlTreePhBook.PhbBDelete(p7.getName(), p7.getPhoneNumber()));

		// AVL Tree Search testing by phone number 
		String searchPhoneNumber = "4356789234";
		Person searchedPersonByPhoneNo = avlTreePhBook.PhbBPhoneSeach(searchPhoneNumber);
		assertEquals(searchedPersonByPhoneNo, p3);

		// Test for null person by ohone No
		String searchPhoneNumberNotExists = "999999999";
		Person searchedPersonByPhoneNotExists = avlTreePhBook.PhbBPhoneSeach(searchPhoneNumberNotExists);
		assertNull(searchedPersonByPhoneNotExists);

		// AVL Tree Search testing by Name
		String searchName  = "Zain";
		Person searchedPersonByName = avlTreePhBook.PhbNameSeach(searchName);
		assertEquals(searchedPersonByName, p8);

		// Test for null person by name
		String searchNameNotExists = "abc";
		Person searchedPersonByNameNotExists = avlTreePhBook.PhbNameSeach(searchNameNotExists);
		assertNull(searchedPersonByNameNotExists);
	}
}
