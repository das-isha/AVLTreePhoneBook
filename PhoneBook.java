//a phonebook interface of type Person created for abstraction
public interface PhoneBook<Person> {

	// returns true if the person can be inserted to Phonebook and false otherwise
	boolean PhbBInsert(String name, String phoneNumber);

	// returns true if the person can be deleted to Phonebook and false otherwise
	boolean PhbBDelete(String name, String phoneNumber);

	// search a person in the phonebook by phone number
	Person PhbBPhoneSeach(String phoneNumber);

	// search a person in the phonebook by name
	Person PhbNameSeach(String name);
}
