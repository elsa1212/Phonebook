package ver07;

public class PhoneBook {
	private static PhoneBook instance;
	private PhoneInfo[] info = new PhoneInfo[10]; // 공간 {null, null, ..., null}
	private int index = 0;
	
	private PhoneBook() {
		
	}

	// get Method
	public static PhoneBook getPhoneBook() {
		if(instance == null) {
			instance = new PhoneBook();
		}
		
		return instance; 
	}
	public PhoneInfo[] getPhoneInfos() {
		return info; 
	}
	
	public int getIndex() {
		return index;
	}
	
	// set Method
	public void setPhoneBook(int length) {
		info = new PhoneInfo[length]; 
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public boolean checkSame(PhoneInfo info) {
		for(int i = 0; i < index; i++) {
			if (this.info[i].equals(info)) {
				return true;
			}
		}
		return false;
	}
	
	public void inputData(PhoneInfo info) {
		boolean existsSame = checkSame(info);
		if (!existsSame) {
			this.info[index++] = info;
		}
	}
	
	public void renewData(PhoneInfo info, int index) {
		this.info[index] = info;
	}

	public void deleteData(int targetIndex) {
		int end = index - 1;

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
	
	public void scaleUp () {
		// 1. 기존 크기의 2배인 PhoneInfo[] 생성
		PhoneInfo[] newInfo = new PhoneInfo[info.length*2];
		
		// 2. this.info 으로부터 newInfo에게 값을 순차대로 가져옴.
		for(int i=0; i<info.length; i++) {
			newInfo[i] = info[i];
			System.out.println(newInfo[i]);
		}
		
		this.info = newInfo;
	}
	
	
	public void testInput(int num) {
		for (int i=0; i<num; i++) {
			if(i == info.length) {
				scaleUp();
			}
			
			if (i % 2 == 0) {
				info[index] = new PhoneInfoSchool(
							"홍길" + (i+1), "010-1111-1111",
							"2001.01.01", "울산대");
				index++;
				continue;
			} 
				
			info[index] = new PhoneInfoSociety("강감" + (i+1), "010-2222-2222",
			             "2002.02.02", "KH");	
			index++;
		}
	}

	public PhoneInfo[] getInfo() {
		return info;
	}
	
	
}
