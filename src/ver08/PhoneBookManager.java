package ver08;

import java.util.Scanner;
import java.util.Vector;

public class PhoneBookManager {
	private String[] phoneInfoName = {"이름> ", "전번> ", "생일> "};
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
	
	public String[] getBasicInfo() {
		String[] basic = new String[3]; // name, phoneNum, birth
		
		for(int i=0; i<phoneInfoName.length; i++) {
			System.out.println(phoneInfoName[i]);
			basic[i] = scan.next();
		}
		return basic;
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

	// 각각의 필드에 대해 키보드로부터 값을 입력받은 PhoneInfo Instance 생성 후 반환.
	public PhoneInfo createPhoneInfo(String choice, String[] basic) {
		String school;
		String company;
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
			 company = scan.next();
			 info = new PhoneInfoSociety(basic[0], basic[1], basic[2], company);
			 break;
			 
		 default:
			 info = new PhoneInfo(basic[0], basic[1], basic[2]);
			 break;
		}
		
		return info;
	}
	
	// PhoneInfo 
	public PhoneInfo newInfo(Vector<PhoneInfo> infos, int index, String targetName) {
		PhoneInfo info = null;
		String[] inputNames = new String[3];

			if(infos.get(index) instanceof PhoneInfoSchool) {
				inputNames = getStrings("전번> ", "생일> ", "학교> ");
				info = new PhoneInfoSchool(targetName, inputNames[0], inputNames[1], inputNames[2]);
				
			} else if(infos.get(index) instanceof PhoneInfoSociety) {
				inputNames = getStrings("전번> ","생일> ","직장> ");
				info = new PhoneInfoSociety(targetName, inputNames[0], inputNames[1], inputNames[2]);
				
			}
		return info;
	}	
	
	// search info in infos ( Vector ) by name
	public PhoneInfo searchData(Vector<PhoneInfo> infos) {
		PhoneInfo targetInfo = null;
		String targetName = scan.next();
		
		for (PhoneInfo i : infos) {
			if (i != null) {
				if ((i.getName()).equals(targetName)) {
					targetInfo = i;
				}
			}
		}
		
		return targetInfo;
	}

	// get index from targetInfo in infos ( Vector )
	public int getDataIndex(Vector<PhoneInfo> infos, String targetName) {
		for (int i=0; i<infos.size(); i++) {
			if(infos.get(i) != null) {
				if((infos.get(i).getName()).equals(targetName)) {
					return i; // 존재하니 수정할 데이터의 index 반환
				}
			}
		}
		return -1; // 존재하지 않음		
	}
	
}
