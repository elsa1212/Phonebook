package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneInfo info1 = new PhoneInfo("길재원", "010-1111-1111");
		PhoneInfo info2 = new PhoneInfo("이도현", "010-2222-2222","2000-01-01");
		
		info1.showInfo();
		info2.showInfo();

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
