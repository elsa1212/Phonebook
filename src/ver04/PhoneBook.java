package ver04;

public class PhoneBook {
	PhoneInfo[] info = new PhoneInfo[10]; // 공간 {null, null, ..., null}
	int index = 0;
	
	public void inputData(PhoneInfo info) {
		this.info[index++] = info;
	}
	
	public void showData() {
		for (int i = 0; i < index; i++) {
		
			if ( info[i] instanceof PhoneInfoSchool) {
				((PhoneInfoSchool)info[i]).showInfo();
			} else if( info[i] instanceof PhoneInfoSociety) {
				((PhoneInfoSociety)info[i]).showInfo();
			} else if( info[i] instanceof PhoneInfo) {
				((PhoneInfo)info[i]).showInfo();
			}
			
		}
	}
	
}
