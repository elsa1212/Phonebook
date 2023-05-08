package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhoneBook book = new PhoneBook();
		
		PhoneBookManager manager = new PhoneBookManager();

		manager.showMenu();
		int num = scanner.nextInt();
		while(num != 3) {
			switch(num) {
				case 1:
					manager.inputData(book);
					break;
				case 2:
					manager.showData(book);
					break;
				default:
					break;
			}
			
			manager.showMenu();
			num = scanner.nextInt();
		}
	scanner.close();
	}
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

