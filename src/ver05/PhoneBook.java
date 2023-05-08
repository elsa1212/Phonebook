package ver05;

public class PhoneBook {
	PhoneInfo[] info = new PhoneInfo[10]; // 공간 {null, null, ..., null}
	int index = 0;
	
	public void inputData(PhoneInfo info) {
		this.info[index++] = info;
	}
	
	public PhoneInfo[] getPhoneBook() {
		return info; 
	}
	
	/*
	public void showData() {
		for (int i = 0; i < index; i++) {
			info[i].showInfo(); 			
		}
	}
	*/	
}
