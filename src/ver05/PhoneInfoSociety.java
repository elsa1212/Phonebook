package ver05;

public class PhoneInfoSociety extends PhoneInfo {
	//field
	private String facility;
	
	public PhoneInfoSociety(String name, String phoneNumber, String birth, String facility) {
		super(name, phoneNumber, birth);
		// TODO Auto-generated constructor stub
		this.facility = facility;
	}
	
	public String getFacility() {
		return this.facility;
	}
	
	/*
	@Override
	public void showInfo() { 	
			System.out.println("이름: " + this.getName());
			System.out.println("전번: " + this.getPhoneNumber());
			if (this.birthCheck()){
				System.out.println("생일: " + this.getBirth());
			}
			System.out.println("직장: " + this.facility);		
			System.out.println("========================");
	}
	*/
	

}
