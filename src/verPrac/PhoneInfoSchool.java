package verPrac;
public class PhoneInfoSchool extends PhoneInfo {
	// field
	private String school;
	
	// default Constructor
	public PhoneInfoSchool() {

	}
	
	public PhoneInfoSchool(String name, String phoneNumber, String birth, String school) {
		super(name, phoneNumber, birth);
		this.school = school;
	}
	

	// Getter
	public String getSchool() {
		return this.school;
	}
	
	// Setter
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Override
	// name이 동일 -> same PhoneInfoSchool
	public boolean equals(Object obj) {
		PhoneInfoSchool other = (PhoneInfoSchool)obj; 
		if(this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String str = "PhoneInfoSchool [";
		str += "name=" + getName() + ", ";
		str += "phoneNumber=" + getPhoneNumber() + ", ";
		str += "birthDay=" + getBirth() + ", ";
		str += "school=" + school;
		str += "]";
		return str;
	}


}
