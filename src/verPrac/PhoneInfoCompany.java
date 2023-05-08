package verPrac;
public class PhoneInfoCompany extends PhoneInfo {
	// field
	private String company;
	
	public PhoneInfoCompany() {
		
	}
	
	public PhoneInfoCompany(String name, String phoneNumber, String birth, String facility) {
		super(name, phoneNumber, birth);
		this.company = facility;
	}
	
	// getter
	public String getCompany() {
		return this.company;
	}
	
	// setter
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	// name이 동일 -> same PhoneInfoCompany
	public boolean equals(Object obj) {
		PhoneInfoCompany other = (PhoneInfoCompany)obj; 
		if(this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}
		
	@Override
	public String toString() {
		String str = "PhoneInfoCompany [";
		str += "name=" + getName() + ", ";
		str += "phoneNumber=" + getPhoneNumber() + ", ";
		str += "birthDay=" + getBirth() + ", ";
		str += "company=" + company;
		str += "]";
		return str;
	}

	
}
