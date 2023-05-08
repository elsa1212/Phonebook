package ver08;
public class PhoneBookTest {

	private static PhoneBook testBook = PhoneBook.getPhoneBook();
	
	public static void main(String[] args) {
		testBook.testInput(45);
		
		PhoneBookMessenger.showData(testBook.getPhoneVector());
	}

}
