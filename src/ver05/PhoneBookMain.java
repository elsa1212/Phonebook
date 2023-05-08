package ver05;

public class PhoneBookMain {
	public static void main(String[] args) {
        PhoneBookManager manager = PhoneBookManager.getInstance();
        PhoneBook book = new PhoneBook();
        
        PhoneBookMessenger.showTitle();
        
        while (true) {
        	PhoneBookMessenger.showMenu();
            String choice = manager.getChoice();
            
            switch (choice) {
            case "1":
            	PhoneBookMessenger.showInputMenu();
            	PhoneBookMessenger.ShowString("선택> ");
            	choice = manager.getChoice();
            	PhoneInfo info = manager.inputData(choice, manager.getBasicInfo());
            	book.inputData(info);
            	PhoneBookMessenger.showInputFinish();
            	break;
            case "2":
            	PhoneBookMessenger.showData(book.getPhoneBook());
            	break;
            case "3":
            	PhoneBookMessenger.showExit();
            	return; // main 종료
            } // switch
        } // while
        
    } // main
} // class
