package ver04;

public class PhoneInfoSchool extends PhoneInfo {
	//field
	private String school;
	
	public PhoneInfoSchool(String name, String phoneNumber, String birth, String school) {
		super(name, phoneNumber, birth);
		this.school = school;
	}
	
	public void showInfo() { 
		System.out.println("=========================");
		System.out.println("이름: " + this.getName());
		System.out.println("전번: " + this.getPhoneNumber());
		if (this.birthCheck()) {
			System.out.println("생일: " + this.getBirth());
		}
		System.out.println("학교: " + this.school);	
		System.out.println("=========================");
	}
	
}
