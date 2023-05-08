package ver05;

import java.util.Scanner;

public class PhoneBookManager {
	private static PhoneBookManager instance; // 최초 상태 null
	
	Scanner scan = new Scanner(System.in);
	
	// Main()에서 new 키워드를 통해 객체 생성 못하도록!
	private PhoneBookManager() {
		
	}
	
	public static PhoneBookManager getInstance() {
		if(instance == null) {
			instance = new PhoneBookManager();
		}
		
		return instance;
	} // Singleton Pattern
	

	// public void showTitle() {
	//	 System.out.println("===== My PhoneBook =====");
	// }
	
	// public void showMenu() {
	//	 showWhat("1.입력   2.전체조회  3.종료");
	// }
	
	// public void showInputMenu() {
	//	 showWhat("1.학교   2.사회");
	// }
	
	public String getChoice() {
		String choice = scan.next();
		return choice;
	}
	
	public String[] getBasicInfo() {
		String[] basic = new String[3]; // name, phoneNum, birth
		String[] infoName = {"이름> ", "전번> ", "생일> "};
		
		for(int i=0; i<infoName.length; i++) {
			System.out.println(infoName[i]);
			basic[i] = scan.next();
		}
		return basic;
	}
	
	public PhoneInfo inputData(String choice, String[] basic) {
		String school;
		String facility;
		PhoneInfo info;
		
		switch(choice) {
		 // 1 : 학교
		 case "1":
			 System.out.print("학교> ");
			 school = scan.next();
			 info = new PhoneInfoSchool(basic[0], basic[1], basic[2], school);
			 break;
			 
		 // 2 : 직장
		 case "2":
			 System.out.print("직장> ");
			 facility = scan.next();
			 info = new PhoneInfoSociety(basic[0], basic[1], basic[2], facility);
			 break;
			 
		 default:
			 info = new PhoneInfo(basic[0], basic[1], basic[2]);
			 break;
		}
		
		return info;
	}
	
	// public void showInputFinish() {
	//	 showWhat("입력 완료");
	// }
	
	//public void showExit() {
	//	scan.close();
	//	showWhat("프로그램 종료");
	// }
	
	// public void showWhat(String what) {
	//	 System.out.println("------------------------");
	//	 System.out.println(what);
	//	 System.out.println("------------------------");
	// }
}
