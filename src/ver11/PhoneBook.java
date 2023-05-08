package ver11;

import java.util.Vector;

public class PhoneBook {
	private static PhoneBook instance;
	private Vector<PhoneInfo> infos = new Vector<>(); // Size of Vector : Variable
	private int index = 0;
	
	/* Constructor */
	
	/* Singleton Pattern */
	
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
	public Vector<PhoneInfo> getPhoneVector() {
		return infos;
	}
	
	public int getIndex() {
		return index;
	}
	
	// Setter on index

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	/* Add, Replace (at specific Index), Delete PhoneInfo */  
	
	public void addData(PhoneInfo info) {
		(this.infos).add(info);
	}
	
	public void replaceData(PhoneInfo info, int index) {
		this.infos.setElementAt(info, index);
	}
	
	public boolean modify(PhoneInfo newInfo) {
		for (int i=0; i<infos.size(); i++) {
			if(infos.get(i) != null) {
				if(newInfo.getName().equals(this.infos.get(i).getName())) {
					this.infos.setElementAt(newInfo, i);
					return true;
				}
			}
		}
		return false;
	}

	public void deleteData(int targetIndex) {
		this.infos.remove(targetIndex);
	}
	
	public void remove(String targetName) {
		for (int i=0; i<infos.size(); i++) {
			if(infos.get(i) != null) {
				if((infos.get(i).getName()).equals(targetName)) {
					this.infos.remove(i); 
				}
			}
		}
	}
	
	/* replaceData
	
	// public boolean remove(String name) {
	
	// }
	 */
	
	// Create new phoneInfo from each Information -> name, phoneNum, birthDay, [ school | company ]
	public PhoneInfo createPhoneInfo(String[] basicInfo) {
		PhoneInfo info = null;
		
		if (basicInfo[4].equals("")) { 
			info = new PhoneInfoSchool(basicInfo[0], basicInfo[1], basicInfo[2], basicInfo[3]);
			
		} else if (basicInfo[3].equals("")) {
			info = new PhoneInfoSociety(basicInfo[0], basicInfo[1], basicInfo[2], basicInfo[4]);
		}
			
		return info;
	}

	// Search info in infos( Vector ) by name
	public PhoneInfo searchData(String targetName) {
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
	
	public boolean checkDataIndex(String targetName) {
		for (int i=0; i<infos.size(); i++) {
			if(infos.get(i) != null) {
				if((infos.get(i).getName()).equals(targetName)) {
					return true; // 벡터 내에 이름이 존재함.
				}
			}
		}
		return false; // 존재하지 않음		
	}
	
	/* Test case */
	public void testInput(int num) {
		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				this.infos.add(new PhoneInfoSchool(
							"홍길" + (i+1), "010-1111-1111",
							"2001.01.01", "울산대"));
				
				continue;
			} 
			
			this.infos.add(new PhoneInfoSociety("강감" + (i+1), "010-2222-2222",
		             "2002.02.02", "KH"));	
		}
	}
}
