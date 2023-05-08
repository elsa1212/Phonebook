package ver10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

public class PhoneBookMenuController implements ActionListener {

	/* Controller 'has a' Model, View */
	
	// Model
	private PhoneBook book = PhoneBook.getPhoneBook();
	
	// View
	private PhoneBookFrame frame;
	
	public PhoneBookMenuController(PhoneBookFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Vector<PhoneInfo> infos;
		String targetName = "";
		int bookIndex = 0;
		
		String command = e.getActionCommand();
		
		switch (command) {
		case "입력":
			if(!frame.checkNorthPanelVisible()) {
				frame.showNorthPanel();
			} else {
				
			}
			break;
			
		case "수정":
			break;
			
		case "삭제":
			targetName = JOptionPane.showInputDialog(this.frame, 
					"삭제할 이름을 입력하세요.", "입력", JOptionPane.INFORMATION_MESSAGE);
			targetName = targetName.trim(); // 양 쪽 공백 제거
			bookIndex = book.getDataIndex(book.getPhoneVector(), targetName);
			if (checkValidBookIndex(bookIndex)) {
				book.deleteData(bookIndex);
				JOptionPane.showMessageDialog(this.frame, 
						"삭제 성공", "알림", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.frame, 
						"데이터 없음", "알림", 
						JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case "검색":
			targetName = JOptionPane.showInputDialog(this.frame, 
					"검색할 이름을 입력하세요.", "검색", JOptionPane.INFORMATION_MESSAGE);
			infos = book.getPhoneVector();
			PhoneInfo targetInfo = book.searchData(infos, targetName);
			frame.showData(targetInfo);
			break;
			
		case "전체 조회":
			infos = book.getPhoneVector();
			frame.showDataAll(infos);	
			break;
			
		case "종료":
			int resultExit = JOptionPane.showConfirmDialog(this.frame, 
					"종료하시겠습니까?", "종료", 
					JOptionPane.ERROR_MESSAGE);
			
			if(resultExit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			
			break;
		}
	}
	
	public boolean checkValidBookIndex (int bookIndex) {
		boolean validBookIndex = false;
		if (bookIndex == -1) {
			validBookIndex = false;
		} else {
			validBookIndex = true;
		}
		
		return validBookIndex;
	}

}
