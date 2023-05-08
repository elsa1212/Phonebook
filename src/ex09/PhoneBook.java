package ex09;

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

	public void deleteData(int targetIndex) {
		this.infos.remove(targetIndex);
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
