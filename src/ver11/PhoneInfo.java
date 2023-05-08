package ver11;
public class PhoneInfo {
	
	private String name;
	private String phoneNumber;
	private String birth;

	/* Constructor */
	
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
	
	/* Getter, Setter on fields */
	
	// Getter on name, phoneNumber, birth 
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getBirth() {
		return this.birth;
	}
	
	// Setter on name, phoneNumber, birth 
	public void setName(String name) {
		this.name = name;
	}
	public void setPhoneNumber(String PhoneNumber) {
		this.phoneNumber = PhoneNumber;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	/* methods by using 1 instance */
	
	// null check on each field -> null : true / notNull : false
	public boolean nameNullCheck() {
		if(name == null) {
			return true;
		}
		
		return false;
	}
	
	public boolean phoneNumberNullCheck() {
		if(phoneNumber == null) {
			return true;
		}
		
		return false;
	}
	
	public boolean birthNullCheck() {
		if(birth == null) {
			return true;
		}
		
		return false;
	}
	
	// Get Summary of Instance -> toString Overriding 
	@Override
	public String toString() {
		String summary = "PhoneInfo ["; 
		summary += "이름: " + name + ", ";
		summary += "전화번호: " + phoneNumber + ", ";
		summary += "생일: " + birth + ", ";
		summary += "]";
		return summary;
	}
	
	/* methods by using instances */
	
	// equals Overriding 
	
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

}
