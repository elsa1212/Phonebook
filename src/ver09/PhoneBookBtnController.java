package ver09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class PhoneBookBtnController implements ActionListener {

	/* Controller 'has a' Model, View */
	
	// Model
	private PhoneBook book = PhoneBook.getPhoneBook();
	
	// View
	private PhoneBookFrame frame;
	
	public PhoneBookBtnController(PhoneBookFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		/* array of information */
		String[] infoTuple = new String[5]; 
		
		// 0: name, 1: phoneNum, 2: birthDay, 3: school, 4: company
		Vector<PhoneInfo> infos;
		String targetName = "";
		int btnIndex = 0; // 입력, 수정, 삭제, 검색, 전체 조회 버튼 판별할 인덱스 
		int bookIndex = 0;
		
		btnIndex = getButtonIndex(obj, frame.btns);
		
		switch (btnIndex) {
		
		// 입력 ( 등록 )
		case 0:
			infoTuple = frame.getInfoTuple(); // View -> Controller
			book.addData(book.createPhoneInfo(infoTuple));
			frame.appendTaScreen("[등록 완료]");
			break;
			
		// 수정
		case 1:
			targetName = frame.getTargetName();
			infos = book.getPhoneVector();
			bookIndex = book.getDataIndex(infos, targetName);
			if (checkValidBookIndex(bookIndex)) {
				infoTuple = frame.getInfoTuple();
				PhoneInfo newInfo = book.createPhoneInfo(infoTuple);
				book.replaceData(newInfo, bookIndex);
				frame.appendTaScreen("[수정 완료]\n");
			} else {
				frame.appendTaScreen("[수정 실패]\n");
			}
			
			break;
			
		// 삭제
		case 2:
			targetName = JOptionPane.showInputDialog(this.frame, 
					"삭제할 이름을 입력하세요.", "삭제", JOptionPane.INFORMATION_MESSAGE);
			bookIndex = book.getDataIndex(book.getPhoneVector(), targetName);
			if (checkValidBookIndex(bookIndex)) {
				book.deleteData(bookIndex);
				JOptionPane.showMessageDialog(this.frame, 
						"삭제 성공", "알림", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this.frame, 
						"삭제 실패", "알림", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;
			
		// 검색
		case 3:
			targetName = JOptionPane.showInputDialog(this.frame, 
					"검색할 이름을 입력하세요.", "검색", JOptionPane.INFORMATION_MESSAGE);
			infos = book.getPhoneVector();
			PhoneInfo targetInfo = book.searchData(infos, targetName);
			frame.showData(targetInfo);
			break;
			
		// 전체 조회
		case 4: 
			infos = book.getPhoneVector();
			frame.showDataAll(infos);	
			break;
		}
	}
	
	public int getButtonIndex(Object obj, JButton[] btns) {
		int index = 0;
		
		for(int i = 0; i < btns.length; i++) {
			if(obj == btns[i]) {
				index = i;
			}
		}
		return index;
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
