package ver02;

public class PhoneInfo {
	String name;
	String phoneNum;
	String birth;
	
	public PhoneInfo(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	
	public PhoneInfo(String name, String phoneNum, String birth) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.birth = birth;
	}
	
	public void showInfo() {
		if(this.birth == null) {
			System.out.println("이름: " + this.name);
			System.out.println("전번: " + this.phoneNum);
			System.out.println("------------------");
		}
		
		else {
			System.out.println("이름: " + this.name);
			System.out.println("전번: " + this.phoneNum);
			System.out.println("생일: " + this.birth);			
			System.out.println("------------------");
		}
	}
}
