package ver07;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
        PhoneBookManager manager = PhoneBookManager.getInstance();
        PhoneBook book = PhoneBook.getPhoneBook();
        
        PhoneBookMessenger.showTitle();
        
        while (true) {
        	PhoneBookMessenger.showMenu();
        	PhoneBookMessenger.ShowString("선택> ");
            String choice = manager.getChoice();
            
            switch (choice) {
            // 입력
            case IConstant.INPUT:
            	boolean fullBook = manager.fullPhoneBook(book);
            	if(fullBook) {
            		book.scaleUp();
            	}
            	
            	PhoneBookMessenger.showInputMenu();
            	PhoneBookMessenger.ShowString("선택> ");
            	choice = manager.getChoice();
            	PhoneInfo info = manager.inputData(choice, manager.getBasicInfo());
            	book.inputData(info);
            	PhoneBookMessenger.showInputFinish();
            	break;
            		
            // 전체 조회
            case IConstant.SHOW_ALL:
            	PhoneBookMessenger.showData(book.getPhoneInfos());
            	break;
            	
            // 검색
            case IConstant.SEARCH:
				PhoneBookMessenger.ShowString("이름> ");
            	PhoneInfo targetInfo = manager.searchData(book.getPhoneInfos());
				PhoneBookMessenger.ShowString("[검색 결과]");
            	PhoneBookMessenger.showData(targetInfo);
            	break;

            // 수정 - 이름은 변경 X 
            case IConstant.UPDATE:
				PhoneBookMessenger.ShowString("이름> ");
				String targetName = manager.getString();
				int index = manager.infoAt(book.getPhoneInfos(), targetName);
				if (index == IConstant.NO_EXIST) {
					PhoneBookMessenger.ShowString("[그런 이름이 존재하지 않습니다.]");
				} else {
					PhoneInfo newInfo = manager.newInfo(book.getPhoneInfos(), index, targetName);
					book.renewData(newInfo, index); // 해당 인덱스에 해당하는 정보 덮어쓰기.
				}
            	break;

			// 삭제
			case IConstant.DELETE:
				PhoneBookMessenger.ShowString("[이름]> ");
				targetName = manager.getString();
				index = manager.infoAt(book.getPhoneInfos(), targetName);
				if (index == IConstant.NO_EXIST) {
					PhoneBookMessenger.ShowString("[삭제하려는 정보 없음]");
				} else {
					book.deleteData(index);
					
				}
				break;
				
            // 종료
            case IConstant.EXIT:
            	PhoneBookMessenger.showExit();
            	return; // main 종료
            } // switch
        } // while
        
    } // main
} // class
