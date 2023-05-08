package ver03;

import java.util.Scanner;

public class PhoneBookManager {
	// field
	int num;
	PhoneInfo info; // create PhoneInfo for inserting

	// method 
	public void showMenu() {
		System.out.println("===== My PhoneBook =====");
		System.out.println("------------------------");
		System.out.println("1. 입력 2. 전체 조회 3. 종료");
		System.out.println("------------------------");
		System.out.print("선택> ");
	}
	
	public void inputData(PhoneBook book) {
		Scanner scanner = new Scanner(System.in);
			this.info = new PhoneInfo();
			System.out.print("이름> ");
			this.info.name = scanner.next();
			System.out.print("전번> ");
			this.info.phoneNum = scanner.next();
			System.out.print("생일> ");
			this.info.birth = scanner.next();
			
			// System.out.println(this.info.name);
			// System.out.println(this.info.phoneNum);
			// System.out.println(this.info.birth);	
			book.inputData(this.info);
			scanner.close();
	}
	
	public void showData(PhoneBook book) {
		book.showData();
	}
}

