package ver07;

public class PhoneBookMessenger {

	public static void showWhat(String what) {
		System.out.println("-------------------------------------------------");
		System.out.println(what);
		System.out.println("-------------------------------------------------");
	}
	
	public static void ShowString(String word) {
		System.out.print(word);
	}
	
	public static void showTitle() {
		System.out.println("=================== My PhoneBook ===================");
	}
	
	public static void showMenu() {
		showWhat("1.입력   2.전체조회   3.검색   4.수정   5.삭제   6.종료 ");
	}
	
	public static void showInputMenu() {
		showWhat("1.학교   2.사회");
	}
	
	public static void showInputFinish() {
		 showWhat("입력 완료");
	 }
	
	public static void showExit() {
		showWhat("프로그램 종료");
	}
	
	public static void showData(PhoneInfo info) {
		if(info == null) {
			System.out.println("[검색 결과 없음]");
		} else {
		
			if (info instanceof PhoneInfoSociety) {
				PhoneInfoSociety infoSoc = (PhoneInfoSociety)info;
				System.out.println("=========================");
				System.out.println("이름: " + infoSoc.getName());
				System.out.println("전번: " + infoSoc.getPhoneNumber());
				if (infoSoc.birthCheck()) {
					System.out.println("생일: " + infoSoc.getBirth());
				}
				System.out.println("직장: " + infoSoc.getFacility());
				System.out.println("=========================");
				
			} else if (info instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSch = (PhoneInfoSchool)info;
				System.out.println("=========================");
				System.out.println("이름: " + infoSch.getName());
				System.out.println("전번: " + infoSch.getPhoneNumber());
				if (infoSch.birthCheck()) {
					System.out.println("생일: " + infoSch.getBirth());
				}
				System.out.println("학교: " + infoSch.getSchool());
				
			} else if (info instanceof PhoneInfo) {
				System.out.println("=========================");
				System.out.println("이름: " + info.getName());
				System.out.println("전번: " + info.getPhoneNumber());
				if (info.birthCheck()) {
					System.out.println("생일: " + info.getBirth());
				}
				System.out.println("=========================");
			}
		}
	}
	
	public static void showData(PhoneInfo[] info) {
		for (PhoneInfo i : info) {
			if (i instanceof PhoneInfoSociety) {
				PhoneInfoSociety infoSoc = (PhoneInfoSociety)i;
				System.out.println("=========================");
				System.out.println("이름: " + infoSoc.getName());
				System.out.println("전번: " + infoSoc.getPhoneNumber());
				if (infoSoc.birthCheck()) {
					System.out.println("생일: " + infoSoc.getBirth());
				}
				System.out.println("직장: " + infoSoc.getFacility());
				System.out.println("=========================");
				
			} else if (i instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSch = (PhoneInfoSchool)i;
				System.out.println("=========================");
				System.out.println("이름: " + infoSch.getName());
				System.out.println("전번: " + infoSch.getPhoneNumber());
				if (infoSch.birthCheck()) {
					System.out.println("생일: " + infoSch.getBirth());
				}
				System.out.println("학교: " + infoSch.getSchool());
				
			} else if (i instanceof PhoneInfo) {
				System.out.println("=========================");
				System.out.println("이름: " + i.getName());
				System.out.println("전번: " + i.getPhoneNumber());
				if (i.birthCheck()) {
					System.out.println("생일: " + i.getBirth());
				}
				System.out.println("=========================");
			}
		}
	}

}
