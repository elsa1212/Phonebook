package ver06;

public class PhoneBook {
	PhoneInfo[] info = new PhoneInfo[10]; // 공간 {null, null, ..., null}
	int index = 0;
	
	// get Method
	public PhoneInfo[] getPhoneBook() {
		return info; 
	}
	
	public void inputData(PhoneInfo info) {
		this.info[index++] = info;
	}
	
	public void renewData(PhoneInfo info, int index) {
		this.info[index] = info;
	}

	public void deleteData(int targetIndex) {
		int end = index-1;

		// case 1. 삭제 요소가 맨 끝에 있을 때
		if (end == targetIndex) {
			this.info[targetIndex] = null;
			index--;

		// case 2. 삭제 요소가 처음 혹은 중간에 있을 때
		} else {
			for(int i= (targetIndex + 1); i < index; i++) {
				this.info[i-1] = this.info[i];
			}
			this.info[end] = null;
			index--;
		}
	}
	
	public void testInput() {
		for (int i=0; i<info.length; i++) {
			if (i % 2 == 0) {
				info[index] = new PhoneInfoSchool(
							"홍길" + (i+1), "010-1111-1111",
							"2001.01.01", "울산대");
				index++;
	
			} else {
				info[index] = new PhoneInfoSociety("강감" + (i+1), "010-2222-2222",
			             "2002.02.02", "KH");
				index++;
			}
		}
	}

}
