package ver06;

public class PhoneInfo {
	
	private String name;
	private String phoneNumber;
	private String birth;

	
	// Constructor
	
	// default Constructor
	public PhoneInfo() {
		
	}
	
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber, String birth) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}
	
	// Getter
	public String getName() {
		return this.name;
	}

	public String getName(boolean exists) {
		if(exists) {
			return this.name;
		}

		else {
			return "";
		}
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getBirth() {
		return this.birth;
	}
	
	// Settter
	public void setPhoneNumber(String PhoneNumber) {
		this.phoneNumber = PhoneNumber;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	@Override
	// name이 동일 -> same PhoneInfo
	public boolean equals(Object obj) {
		// parameter 받아오면서 upcasting 됨
		PhoneInfo other = (PhoneInfo)obj; // 대상 클래스의 레퍼런스 타입에 맞게 -> downCasting
		// String.equals() -> 이미 Overriding 되어 있음. 
		if(this.name.equals(other.name)) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "PhoneInfo [이름: " + name + ", 전화번호: " + phoneNumber + ", 생일: " + birth + "]";
	}

	// PhoneInfoManager의 기능????
	public boolean birthCheck() {
		if(this.birth != null) {
			return true;
		}
		
		return false;
	}
}
