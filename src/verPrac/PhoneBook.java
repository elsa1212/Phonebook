package verPrac;

import java.util.Vector;

public class PhoneBook {
	private static PhoneBook instance;
	private Vector<PhoneInfo> infoTable = new Vector<>(); 
	private int index = 0;
	
	/* Singleton Pattern */
	
	/* Constructor */
	private PhoneBook() {
		
	}

	public static PhoneBook getPhoneBook() {
		if(instance == null) {
			instance = new PhoneBook();
		}
		
		return instance; 
	}
	
	/* Getter, Setter on fields */
	
	// Getter on PhoneInfo[], index
	public Vector<PhoneInfo> getInfoTable() {
		return infoTable;
	}
	
	public int getIndex() {
		return index;
	}
	
	// Setter on index

	public void setIndex(int index) {
		this.index = index;
	}
	
	/* Add, Replace (at specific Index), Delete PhoneInfo */  
	
	public boolean inputData(PhoneInfo info) {
		String nameInTable = "";
		String targetName = info.getName();
		
		// Key : Name -> 동명이인 존재 X
		for(int i  = 0; i < infoTable.size(); i++) {
			nameInTable = infoTable.get(i).getName();
			if(targetName.equals(nameInTable)) {
				return false;
			}
		}
		
		infoTable.add(info);	
		return true;
	}
	
	public boolean modifyData(PhoneInfo newInfo) {
		String nameInTable = "";
		String targetName = newInfo.getName();
		
		// 1. newInfo가 기존 Table에 존재하는지 검사 -> key : Name
		if(searchData(targetName) != null) {
			
			// 2. 해당 인덱스에서 newInfo로 수정
			for(int i  = 0; i < infoTable.size(); i++) {
				nameInTable = infoTable.get(i).getName();
				if(targetName.equals(nameInTable)) {
					infoTable.setElementAt(newInfo, i);
					return true;
				}
			}
		} 
		return false;
	}
	
	
	public boolean deleteData(String targetName) {
		String nameInTable = "";
		PhoneInfo targetInfo = null;
		
		// Key : Name -> 입력된 Key에 해당하는 Info 존재하는지 검사.
		for(int i  = 0; i < infoTable.size(); i++) {
			nameInTable = infoTable.get(i).getName();
			if(targetName.equals(nameInTable)) {
				infoTable.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public PhoneInfo searchData(String targetName) {
		String nameInTable = "";
		PhoneInfo targetInfo = null;
		
		// Key : Name -> 입력된 Key에 해당하는 Info 존재하는지 검사.
		for(int i  = 0; i < infoTable.size(); i++) {
			nameInTable = infoTable.get(i).getName();
			if(targetName.equals(nameInTable)) {
				targetInfo = infoTable.get(i);
			}
		}
		return targetInfo;
	}
//	
//	public boolean inputData(PhoneInfo info) {
//		boolean existSame = checkSame(info);
//		if (!existSame) {
//			this.infos.add(info);
//			return true;
//		}
//		return false;
//	}
//	
//	public boolean checkSame(PhoneInfo info) {
//		for (int i = 0; i < this.infos.size(); i++) {
//			if (this.infos.get(i).equals(info)) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean replaceData(PhoneInfo info) {
//		for (int i = 0; i < this.infos.size(); i++) {
//			if (info.getName().equals(this.infos.get(i).getName())) {
//				this.infos.setElementAt(info, i);
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	// Search info in infos( Vector ) by name
//	public PhoneInfo searchData(String targetName) {
//		PhoneInfo targetInfo = null;
//		
//		for (PhoneInfo i : infos) {
//			if (i != null) {
//				if (i.getName().equals(targetName)) {
//					targetInfo = i;
//				}
//			}
//		}
//		
//		return targetInfo;
//	}
//
//	public void deleteData(int targetIndex) {
//		this.infos.remove(targetIndex);
//	}
//	
//	public boolean remove(String name) {
//		for (int i = 0; i < this.infos.size(); i++) {
//			PhoneInfo pInfo = this.infos.get(i);
//			if (pInfo.getName().equals(name)) {
//				this.infos.remove(i);
//				System.out.println(this.infos);
//				return true;
//			}
//		}
//		return false;
//	}
	
	/* Test case */
	public void testInput(int num) {
		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				infoTable.add(new PhoneInfoSchool(
							"홍길" + (i+1), "010-1111-1111",
							"2001.01.01", "울산대"));
				
				continue;
			} 
			
			infoTable.add(new PhoneInfoCompany("강감" + (i+1), "010-2222-2222",
		             "2002.02.02", "KH"));	
		}
	}
}
