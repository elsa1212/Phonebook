package ver04;

public class PhoneBookMain {
	public static void main(String[] args) {
        PhoneBookManager manager = PhoneBookManager.getInstance();
        PhoneBook book = new PhoneBook();
        
        manager.showTitle();
        
        while (true) {
        	manager.showMenu();
            String choice = manager.getChoice();
            
            switch (choice) {
            case "1":
            	manager.showInputMenu();
            	choice = manager.getChoice();
            	PhoneInfo info = manager.inputData(choice, manager.getBasicInfo());
            	book.inputData(info);
            	manager.showInputFinish();
            	break;
            case "2":
            	book.showData();
            	break;
            case "3":
            	manager.showExit();
            	return; // main 종료
            } // switch
        } // while
        
    } // main
} // class
