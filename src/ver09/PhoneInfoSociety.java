package ver09;
public class PhoneInfoSociety extends PhoneInfo {
	// field
	private String facility;
	
	public PhoneInfoSociety() {
		
	}
	
	public PhoneInfoSociety(String name, String phoneNumber, String birth, String facility) {
		super(name, phoneNumber, birth);
		// TODO Auto-generated constructor stub
		this.facility = facility;
	}
	
	// getter
	public String getFacility() {
		return this.facility;
	}
	
	// setter
	public void setFacility(String facility) {
		this.facility = facility;
	}
		
	@Override
	public String toString() {
		String str = "PhoneInfoCompany [";
		str += "name=" + getName() + ", ";
		str += "phoneNumber=" + getPhoneNumber() + ", ";
		str += "company=" + facility;
		str += "]";
		return str;
	}

	
}
