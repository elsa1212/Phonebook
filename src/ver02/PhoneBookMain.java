package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		
		PhoneInfo info1 = new PhoneInfo("길재원", "010-2222-2222");
		PhoneInfo info2 = new PhoneInfo("이도현", "010-4444-5555","2055-01-01");
		
		book.inputData(info1);
		// book.addOneInfo(new PhoneInfo("길재원", "010-2222-2222"));
		
		book.inputData(info2);
		// book.addOneInfo(new PhoneInfo("이도현", "010-4444-5555","2055-01-01"));
		
		book.showData();		
	}
	
	/* 
	<실행 결과>
	이름: 길재원
	전번: 010-1111-1111
	------------------
	이름: 이도현
	전번: 010-2222-2222
	생일: 2000-01-01
	*/
	
	

}
