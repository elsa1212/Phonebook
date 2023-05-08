package ver07;

public class PhoneBookTest {

	private static PhoneBook testBook = PhoneBook.getPhoneBook();
	
	public static void main(String[] args) {
		// testBook.testInput(10);
		// testBook.getInfo();
		testSameInfo();
		getInfo();
		
		
		PhoneBookMessenger.showData(testBook.getPhoneInfos());
	}
	
	private static void testSameInfo() {
		PhoneInfoSchool info1 = 
				new PhoneInfoSchool("홍길동", "010-1111-1111", "2001.01.01", "울산대");
		
		testBook.inputData(info1);
		
		PhoneInfoSociety info2 = 
				new PhoneInfoSociety("홍길동", "010-2222-1111", "2001.01.01", "서울대");
	}
	
	@SuppressWarnings("unused")
	private static void getInfo() {
		PhoneInfo[] infos = testBook.getInfo();
		for (PhoneInfo aInfo : infos) {
			System.out.println(aInfo); // .toString()
		}
		
	}

}
