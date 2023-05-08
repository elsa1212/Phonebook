package ver11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ver11.PhoneBookFrame.InputDialog;

public class PhoneBookController implements ActionListener{
/* Controller 'has a' Model, View */
	
	// Model
	private PhoneBook book = PhoneBook.getPhoneBook();
	
	// View
	private PhoneBookFrame frame;
	private InputDialog dialog;
	
	public PhoneBookController(PhoneBookFrame frame, InputDialog dialog) {
		
		this.frame = frame;
		this.dialog = dialog;
	}
	
	/* array of information */
	String[] infoTuple = new String[5]; 
	
	// 0: name, 1: phoneNum, 2: birthDay, 3: school, 4: company

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch (command) {
		case "입력":
			dialog.setVisible(true);
			break;
			
		case "수정":
			String targetName = frame.getTargetName();
			infoTuple = frame.getInfoTuple();
			PhoneInfo info = book.createPhoneInfo(infoTuple);
			boolean modifyResult = book.modify(info);
			if (modifyResult) {
				frame.appendTaScreen("[수정 완료]\n");
			} else {
				frame.appendTaScreen("[수정 실패]\n");
			}
			break;
			
		case "삭제":
			String deleteName = JOptionPane.showInputDialog(this.frame, 
					"삭제할 이름을 입력하세요.", "삭제", JOptionPane.INFORMATION_MESSAGE);
			boolean deleteResult = book.checkDataIndex(deleteName);
			if(deleteResult) {
				book.remove(deleteName);
				JOptionPane.showMessageDialog(this.frame, 
						"삭제 성공", "알림", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.frame, 
						"삭제 실패", "알림",  
						JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		case "검색":
			String searchName = JOptionPane.showInputDialog(this.frame, 
					"검색할 이름을 입력하세요.", "검색", JOptionPane.INFORMATION_MESSAGE);
			PhoneInfo searchedInfo = book.searchData(searchName);
			frame.showData(searchedInfo);
			break;
			
		case "전체 조회":
			frame.showDataAll(book.getPhoneVector());	
			break;
	
		}
		
	}
}
