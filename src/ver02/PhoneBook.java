package ver02;

// 전화번호부
public class PhoneBook {
	PhoneInfo[] info = new PhoneInfo[10]; // 공간 {null, null, ..., null}
	int index = 0;
	
	public void inputData(PhoneInfo info) {
		this.info[index++] = info;
	}
	
	public void showData() {
		for (int i = 0; i < index; i++) {
			info[i].showInfo();
		}
	}
				
	/*
	// 필드
	PhoneInfo[] phoneInfos;
	int length; // 전화번호부의 크기(길이)
	
	// 메서드
	// set
	//  -> 전화번호부의 크기 할당 setLengthPhoneBook()
	public void setLengthPhoneBook(int length) {
		this.length = length;
		this.phoneInfos = new PhoneInfo[length]; // 공간만 만들었지 아직 할당 x
		
    //		for(int i=0; i<length; i++) {
    //			this.phoneInfos[i] = new PhoneInfo();
    //		}
	}
	
	//  -> 전화번호부에 전화번호를 1개를 저장 setOnePhoneNum()
	public void addOneInfo(PhoneInfo info1) {
		for(int i=0; i<this.length; i++) {
			if(this.phoneInfos[i] == null) {
				this.phoneInfos[i] = info1; // 생성자와 같은 역할.
				break;
			}		
		}
		return;
	}
	
	// get 
	//  -> 전화번호 전체를 보여줄 메서드 showAllPhoneNum()
	public void showAllPhoneNum() {
		for(int i=0; i<this.length; i++) {
			if(this.phoneInfos[i] != null) {
				if(this.phoneInfos[i].birth == null) {
					System.out.println(this.phoneInfos[i].name);
					System.out.println(this.phoneInfos[i].phoneNum);
					System.out.println("------------------");
				} else {
					System.out.println(this.phoneInfos[i].birth);
					System.out.println(this.phoneInfos[i].name);
					System.out.println(this.phoneInfos[i].phoneNum);
					System.out.println("------------------");
				}
			} else {
				break;
			}
		}
	}
	*/
}
