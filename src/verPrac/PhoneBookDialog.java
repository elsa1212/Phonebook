package verPrac;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
/* PhoneBookDialog -> View 이면서 Controller */
class PhoneBookDialog extends JDialog implements ActionListener {
	/* View */
	
	// Model
	PhoneBook book = PhoneBook.getPhoneBook();
	
	// Components
	JPanel pnlResult = new JPanel(); // pnlResult has pnlInput, pnlButton
	
	JPanel pnlInput = new JPanel();
	
	JTextField tfName = new JTextField("이이짝도");
	JTextField tfPhoneNum = new JTextField("010-1111-2222");
	JTextField tfBirthDay = new JTextField("2023.03.10");
	JTextField tfSpecified = new JTextField("리부트2");
	JTextField[] tfsDialog = {tfName, tfPhoneNum, tfBirthDay, tfSpecified};
	JPanel pnlRadioBtn = new JPanel(); // inputPanel has a radioBtnPanel
	
	ButtonGroup specified = new ButtonGroup();
	JRadioButton rBtnSchool = new JRadioButton("학교", true);
	JRadioButton rBtnCompany = new JRadioButton("회사");
	JTextField tfGroup = new JTextField();
	JComponent[] rightComponents = {tfName, tfPhoneNum, tfBirthDay, pnlRadioBtn};
	
	JPanel pnlButton = new JPanel();
	JButton btnOk = new JButton("OK");
	JButton btnCancel = new JButton("Cancel");
	JButton[] btnsDialog = {btnOk, btnCancel};
	
	/* Constructor */
	public PhoneBookDialog(String title, PhoneBookFrame frame) {
		super(frame, title, true);
		
		setSize(500, 200);
		setPanel();
		setListener();
	}
	
	public void setPanel() {
		final int INPUT_ROW = 4;
		final int RADIO_ROW = 1;
		
		final int INPUT_COL = 2;
		final int RADIO_COL = 3;
		
		int size = INPUT_ROW * INPUT_COL;
		
		JLabel lblName = new JLabel("이름");
		JLabel lblPhoneNumber = new JLabel("전화번호");
		JLabel lblBirthday = new JLabel("생일");
		JLabel lblGroup = new JLabel("학교 / 직장");
		JComponent[] leftComponents = {lblName, lblPhoneNumber, lblBirthday, lblGroup};
		
		/* RadioBtnPanel */
		// 1. Add RadioBtns to Button Group
		specified.add(rBtnSchool);
		specified.add(rBtnCompany);
		
		// 2. Add RadioBtns to pnlRadioBtn
		pnlRadioBtn.setLayout(new GridLayout(RADIO_ROW, RADIO_COL));
		pnlRadioBtn.add(rBtnSchool);
		pnlRadioBtn.add(rBtnCompany);
		pnlRadioBtn.add(tfSpecified);
		
		/* pnlInput has a RadioBtnPanel */
		pnlInput.setLayout(new GridLayout(INPUT_ROW, INPUT_COL));
		
		for(int i = 0; i < size; i++) {
			// Index가 짝수 
			if(checkEven(i)) {
				pnlInput.add(leftComponents[i/2]);
			// Index가 홀수 
			} else {
				pnlInput.add(rightComponents[i/2]);
			}
		}
		
		/* pnlButton - default -> FlowLayout */
		pnlButton.add(btnOk);
		pnlButton.add(btnCancel);
		
		
		/* pnlResult has pnlInput, pnlButton */
		pnlResult.setLayout(new BorderLayout());
		pnlResult.add(pnlInput, BorderLayout.CENTER);
		pnlResult.add(pnlButton, BorderLayout.SOUTH);
		
		this.add(pnlResult); // add panel to this Dialog
	}
	
	public void setListener() {
		for(int i = 0; i < btnsDialog.length; i++) {
			btnsDialog[i].addActionListener(this);
		}
	} // method on View
	
	public boolean checkEven(int num) {
		if((num % 2) == 0) {
			return true;
		} 
		return false;
	}
	
	public PhoneInfo createNewInfo() {
		// 0 : name, 1 : PhoneNumber, 2 : birthDay, 3 : specified
		String[] infoStrings = new String[tfsDialog.length];
		PhoneInfo newInfo = null;
		
		for(int i = 0; i < tfsDialog.length; i++) {
			infoStrings[i] = tfsDialog[i].getText();
		}
		
		if(rBtnSchool.isSelected()) {
			newInfo = new PhoneInfoSchool(infoStrings[0], infoStrings[1], 
							 			  infoStrings[2], infoStrings[3]);
		} else if(rBtnCompany.isSelected()) {
			newInfo = new PhoneInfoCompany(infoStrings[0], infoStrings[1], 
		 			  					   infoStrings[2], infoStrings[3]);
		}			
		return newInfo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* Controller */
		String[] commands = {"입력", "수정", "삭제", "검색"};
		Object obj = e.getSource();
		PhoneInfo viewInfo = null;
		
		// 1. get vieInfo from Dialog (View)
		if (obj == btnOk) {
			viewInfo = createNewInfo();
		} else if (obj == btnCancel) {
			this.setVisible(false);
		}
		
		// 2. Input / Modify 
		String targetCommand = this.getTitle();
		if(viewInfo != null) {
			
			// Case 1) input
			if (targetCommand.equals(commands[0])) {
				// Input success
				if (book.inputData(viewInfo)) {
					JOptionPane.showMessageDialog(this, 
							targetCommand + "성공", targetCommand, 
							JOptionPane.INFORMATION_MESSAGE);
				// Input Failed
				} else {
					JOptionPane.showMessageDialog(this, 
							targetCommand + "실패", targetCommand, 
							JOptionPane.ERROR_MESSAGE);
				}
							
				// Case 2) Modify
				} else if (targetCommand.equals(commands[1])) {
					// Modify success
					if (book.modifyData(viewInfo)) {
						JOptionPane.showMessageDialog(this, 
								targetCommand + "성공", targetCommand, 
								JOptionPane.INFORMATION_MESSAGE);
					// Modify failed
					} else {
						JOptionPane.showMessageDialog(this, 
								targetCommand + "실패", targetCommand, 
								JOptionPane.INFORMATION_MESSAGE);
					}							
				} // if (targetCommand.equals(commands[0])
			} // if(viewInfo != null)
		} // actionPerformed				
} // class PhoneBook Dialog
