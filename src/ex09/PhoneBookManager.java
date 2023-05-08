package ex09;

import java.util.Vector;

public class PhoneBookManager {
	/* Singleton Pattern */
	
	private static PhoneBookManager instance; // 최초 상태 null
	

	public static PhoneBookManager getInstance() {
		if(instance == null) {
			instance = new PhoneBookManager();
		}
		
		return instance;
	} // Singleton Pattern
	
	// Create new phoneInfo from each Information -> name, phoneNum, birthDay, [ school | company ]
	public PhoneInfo createPhoneInfo(String[] basicInfo, String choice, String[] choices) {
		PhoneInfo info = null;
		
		switch (choice) { 
		case IConstant.SUB_SCHOOL:
			info = new PhoneInfoSchool(basicInfo[0], basicInfo[1], basicInfo[2], choices[0]);
			break;
			
		case IConstant.SUB_COMPANY:
			info = new PhoneInfoSociety(basicInfo[0], basicInfo[1], basicInfo[2], choices[1]);
			break;
		}
		
		return info;
	}
	
	// Create new phoneInfo from each Information -> name, phoneNum, birthDay, [ school | company ]
		public PhoneInfo createPhoneInfo(String[] basicInfo, String choice) {
			PhoneInfo info = null;
			
			switch (choice) { 
			case IConstant.SUB_SCHOOL:
				info = new PhoneInfoSchool(basicInfo[0], basicInfo[1], basicInfo[2], basicInfo[3]);
				break;
				
			case IConstant.SUB_COMPANY:
				info = new PhoneInfoSociety(basicInfo[0], basicInfo[1], basicInfo[2], basicInfo[4]);
				break;
			}
			
			return info;
		}
		
	// Search info in infos( Vector ) by name
	public PhoneInfo searchData(Vector<PhoneInfo> infos, String targetName) {
		PhoneInfo targetInfo = null;
		
		for (PhoneInfo i : infos) {
			if (i != null) {
				if (i.getName().equals(targetName)) {
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
