package ver04;

public class PhoneInfo {
	
	private String name;
	private String phoneNumber;
	private String birth;

	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneInfo(String name, String phoneNumber, String birth) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}
	
	// get
	public String getName() {
		return this.name;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getBirth() {
		return this.birth;
	}
	
	// 
	public boolean birthCheck() {
		if(this.birth != null) {
			return true;
		}
		
		return false;
	}
	public void showInfo() { 
		System.out.println("=========================");
		System.out.println("이름: " + this.name);
		System.out.println("전번: " + this.phoneNumber);
		if (this.birth != null) {
			System.out.println("생일: " + this.birth);
		}
		System.out.println("=========================");
	}
}
