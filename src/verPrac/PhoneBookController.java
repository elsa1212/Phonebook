package verPrac;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class PhoneBookController implements ActionListener {
	
	/* Controller has a Model, View */
	
	// Model
	private PhoneBook book = PhoneBook.getPhoneBook();
	
	// View
	private PhoneBookFrame frame; 
	private PhoneBookDialog dialog;
	
	public PhoneBookController(PhoneBookFrame frame, PhoneBookDialog dialog) {
		this.frame = frame;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] commands = {"입력", "수정", "삭제", "검색"};

		// case 1 ) 입력
		if(obj == frame.miInput || obj == frame.btnInput) {
			dialog.setTitle(commands[0]);
			dialog.setVisible(true);
		}
		
		// case 2 ) 수정
		if(obj == frame.miModify || obj == frame.btnModify) {
			dialog.setTitle(commands[1]);
			dialog.setVisible(true);
		}
		
		// case 3 ) 삭제
		if(obj == frame.miDelete || obj == frame.btnDelete) {
			String deleteName = JOptionPane.showInputDialog(frame, 
					"삭제할 이름을 입력하세요.", commands[2], JOptionPane.INFORMATION_MESSAGE);
			if(deleteName!=null) {				
				deleteName = deleteName.trim();
			}
			boolean deleteResult = book.deleteData(deleteName);
			
			// 삭제 성공
			if(deleteResult) {
				JOptionPane.showMessageDialog(frame, 
						 commands[2] + "성공",commands[2],
						 JOptionPane.INFORMATION_MESSAGE);
			// 삭제 실패
			} else {
				JOptionPane.showMessageDialog(frame, 
						 commands[2] + "실패",commands[2],
						 JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// case 4 ) 검색
		if(obj == frame.miSearch || obj == frame.btnSearch) {
			String searchName = JOptionPane.showInputDialog(frame, 
					"검색할 이름을 입력하세요.", commands[3], JOptionPane.INFORMATION_MESSAGE);
			if(searchName != null) {				
				searchName = searchName.trim();
			}
			PhoneInfo searchInfo = book.searchData(searchName);
			
			// Search Success
			if(searchInfo != null) {
				JOptionPane.showMessageDialog(frame, 
						 commands[3] + "성공",commands[3],
						 JOptionPane.INFORMATION_MESSAGE);
				frame.showInfo(searchInfo);
			// Search Failed
			} else {
				JOptionPane.showMessageDialog(frame, 
						 commands[3] + "실패",commands[3],
						 JOptionPane.ERROR_MESSAGE);
			}
			
		}		
		// case 5 ) 전체 조회
		if(obj == frame.miInquiry || obj == frame.btnInquiry) {
			frame.showInfoTable();
		}
		
	}

}
