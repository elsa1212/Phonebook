package ver07;

import java.util.Scanner;

public class PhoneBookManager {
	private static PhoneBookManager instance; // 최초 상태 null
	
	Scanner scan = new Scanner(System.in);

	public static PhoneBookManager getInstance() {
		if(instance == null) {
			instance = new PhoneBookManager();
		}
		
		return instance;
	} // Singleton Pattern

	public String getChoice() {
		String choice = scan.next();
		return choice;
	}
	
	public String getString() {
		String string = scan.next();
		return string;
	}

	public String[] getStrings(String inputStr1, String inputStr2, String inputStr3) {
		String[] strings = new String[3];
		PhoneBookMessenger.ShowString(inputStr1);
		strings[0] = scan.next();
		PhoneBookMessenger.ShowString(inputStr2);
		strings[1] = scan.next();
		PhoneBookMessenger.ShowString(inputStr3);
		strings[2] = scan.next();

		return strings;
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
		 // 학교
		 case IConstant.SUB_SCHOOL:
			 System.out.print("학교> ");
			 school = scan.next();
			 info = new PhoneInfoSchool(basic[0], basic[1], basic[2], school);
			 break;
			 
		 // 직장
		 case IConstant.SUB_COMPANY:
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
	
	// search Info by name;
	public PhoneInfo searchData(PhoneInfo[] book) {
		PhoneInfo targetInfo = null;
		String targetName = scan.next();
		
		for (PhoneInfo i : book) {
			if (i != null) {
				if ((i.getName()).equals(targetName)) {
					targetInfo = i;
				}
			}
		}
		
		return targetInfo;
	}

	public int infoAt(PhoneInfo[] book, String targetName) {

		for (int i=0; i<book.length; i++) {
			if(book[i] != null) {
				if((book[i].getName()).equals(targetName)) {
					return i; // 존재하니 수정할 데이터의 index 반환
				}
			}
		}
		return -1; // 존재하지 않음
	}
	
	// 수정하려는 데이터에 접근 -> 레퍼런스 타입에 알맞는 새 객체 생성 -> 이를 반환
	public PhoneInfo newInfo(PhoneInfo[] book, int index, String targetName) {
		PhoneInfo info = null;
		String[] inputNames = new String[3];

			if(book[index] instanceof PhoneInfoSchool) {
				inputNames = getStrings("전번> ", "생일> ", "학교> ");
				info = new PhoneInfoSchool(targetName, inputNames[0], inputNames[1], inputNames[2]);
				
			} else if(book[index] instanceof PhoneInfoSociety) {
				inputNames = getStrings("전번> ","생일> ","직장> ");
				info = new PhoneInfoSociety(targetName, inputNames[0], inputNames[1], inputNames[2]);
				
			}
		return info;
	}
	
	// PhoneBook 이 꽉 찼는지 검사.
	public boolean fullPhoneBook(PhoneBook book) {
		int curIndex = book.getIndex();
		if (curIndex == book.getPhoneInfos().length) {
			return true;
		} else if( curIndex < book.getPhoneInfos().length) {
			return false;
		}
		return false;
	}				
}
