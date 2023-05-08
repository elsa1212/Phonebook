package ex09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame {
	
	PhoneBook book = PhoneBook.getPhoneBook();
	PhoneBookManager manager = PhoneBookManager.getInstance();
	BtnListener btnListener = new BtnListener();
	
	/* JFrame Components*/
	Container c = getContentPane();
	
	JPanel pnlNorth = new JPanel();
	JPanel pnlCenter = new JPanel();
	JPanel pnlSouth = new JPanel();
	JPanel pnlRadio = new JPanel();
	
	JTextField tfName = new JTextField();
	JTextField tfPhoneNum = new JTextField();
	JTextField tfBirthDay = new JTextField();
	JTextField tfDetail = new JTextField();
	JTextField[] tfs = {tfName, tfPhoneNum, tfBirthDay, tfDetail}; 
	
	ButtonGroup detailGroup = new ButtonGroup();	
	JRadioButton btnSchool = new JRadioButton("학교");
	JRadioButton btnCompany = new JRadioButton("회사");
	JRadioButton[] details = {btnSchool, btnCompany};
	
	JTextArea taScreen = new JTextArea(200, 50);
	
	JButton btnInput = new JButton("입력");
	JButton btnRenew = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	JButton btnShowTotal = new JButton("전체 조회");
	JButton[] btns = {btnInput, btnRenew, btnDelete, btnSearch, btnShowTotal};
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("♡ My PhoneBook ♥");
		setSize(600, 600);
		c.setLayout(new BorderLayout());
		
		setNorthPanel();
		setCenterPanel();
		setSouthPanel();
		setRadioPanel();
		setListener();
	
		setVisible(true);
	}
	
	/* 4 x 2 GridLayout 
	 * 4 lbl , 3 tf, 2 radioBtn ( School / Company ) 
	 */
	
	public void setNorthPanel() {

		JLabel lblName = new JLabel("이름");
		JLabel lblPhoneNum = new JLabel("전화번호");
		JLabel lblBirthDay = new JLabel("생일");
		JLabel lblSpecific = new JLabel("학교/회사");
		JLabel[] lbls = {lblName, lblPhoneNum, lblBirthDay, lblSpecific};
		
		pnlNorth.setLayout(new GridLayout(4, 2));
		int size = 4 * 2;
					
		for(int i = 0; i < size; i++) {
			// 짝수 index
			if((i % 2) == 0) {
				pnlNorth.add(lbls[i / 2]);
			// 홀수 index
			} else {
				if(i != size - 1) {
					pnlNorth.add(tfs[i / 2]);
				} else {
					pnlNorth.add(pnlRadio);
				}
			}
		} // for lbl, tf, radioBtns
		
		c.add(pnlNorth, BorderLayout.NORTH);
	}
	
	public void setRadioPanel() {
		setRadioBtn();
		pnlRadio.setLayout(new GridLayout(1,3));
		pnlRadio.add(btnSchool);
		pnlRadio.add(btnCompany);
		pnlRadio.add(tfDetail);
	}
	
	public void setRadioBtn() {
		detailGroup.add(btnSchool);
		detailGroup.add(btnCompany);
		
		for(int i = 0; i < details.length; i++) {
			detailGroup.add(details[i]); // 여러 개 중에 하나만 선택되도록 Grouping
			if ( i == IConstant.FIRST_INDEX ) {
				details[i].setSelected(true);
			}
		}
	} 
	// North Panel
	
	public void setCenterPanel() {
		// pnlCenter.setBackground(Color.LIGHT_GRAY);
		pnlCenter.add(new JScrollPane(taScreen));
		
		c.add(pnlCenter, BorderLayout.CENTER);
	}
	// Center Panel
	
	public void setSouthPanel() {
		pnlSouth.setLayout(new FlowLayout());
		// pnlSouth.setBackground(Color.PINK);
		for(int i = 0; i < btns.length; i++) {
			pnlSouth.add(btns[i]);
		}
		c.add(pnlSouth, BorderLayout.SOUTH);
	}
	// South Panel()
	
	public void setListener() {
		for(int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(btnListener);
		}
	}
	
	public class BtnListener implements ActionListener {
				
		/* array of information */
		private String[] infoTuple = new String[5]; // 0: name, 1: phoneNum, 2: birthDay, 3: school, 4: company
		
		private String choice = "";
		private String targetName = "";
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			int index = 0;
			
			for(int i = 0; i < btns.length; i++) {
				if(obj == btns[i]) {
					index = i;
				}
			}
			
			switch(index) {
			// 입력
			case 0:				
				makeInfoTuple();			
				book.addData(manager.createPhoneInfo(infoTuple, choice));
				taScreen.append("등록 완료. " + "\n");
				break;
				
			// 수정	
			case 1:
				targetName = tfName.getText();
				int bookIndex = manager.getDataIndex(book.getPhoneVector(), targetName);
				if (bookIndex == IConstant.NO_EXIST) {
					taScreen.append("[그런 이름이 존재하지 않습니다.]" + "\n");
				} else {
					makeInfoTuple();
					PhoneInfo newInfo = manager.createPhoneInfo(infoTuple, choice);
					book.replaceData(newInfo, bookIndex); // 해당 인덱스에 해당하는 정보 덮어쓰기.
					taScreen.append("[수정 완료]" + "\n");
				}
				break;
				
			// 삭제
			case 2:
				targetName = tfName.getText();
				bookIndex = manager.getDataIndex(book.getPhoneVector(), targetName);
				if (bookIndex == IConstant.NO_EXIST) {
					taScreen.append("[그런 이름이 존재하지 않습니다.]" + "\n");
				} else {
					book.deleteData(bookIndex);
					taScreen.append("[삭제 완료]" + "\n");
				}
				break;
				
			// 검색
			case 3:
				targetName = tfName.getText();
				PhoneInfo targetInfo = manager.searchData(book.getPhoneVector(), targetName);
				showData(targetInfo);
				break;
				
			// 전체 조회
			case 4:
				showDataAll(book.getPhoneVector());
				break;
			}
					
		}
		
		public void makeInfoTuple () {				
			infoTuple[0] = tfName.getText();
			infoTuple[1] = tfPhoneNum.getText();
			infoTuple[2] = tfBirthDay.getText();
			
			if (details[0].isSelected()) {
				this.choice = "1";
				infoTuple[3] = tfDetail.getText();
				infoTuple[4] = "";
				
			}
			
			else if (details[1].isSelected()) {
				this.choice = "2";
				infoTuple[3] = "";
				infoTuple[4] = tfDetail.getText();
			}		
		}
		
		public void showData(PhoneInfo info) {
			if(info == null) {
				taScreen.append("검색결과 없음." + "\n");
			} else {
				if (info instanceof PhoneInfoSociety) {
					PhoneInfoSociety infoSoc = (PhoneInfoSociety)info;
					taScreen.append("이름: " + infoSoc.getName() + " | ");
					taScreen.append("전번: " + infoSoc.getPhoneNumber() + " | ");
					if (infoSoc.birthNullCheck()) {
						taScreen.append("생일: " + infoSoc.getBirth() + " | ");
					}
					taScreen.append("직장: " + infoSoc.getFacility() + "\n");
					
				} else if (info instanceof PhoneInfoSchool) {
					PhoneInfoSchool infoSch = (PhoneInfoSchool)info;
					taScreen.append("이름: " + infoSch.getName() + " | ");
					taScreen.append("전번: " + infoSch.getPhoneNumber() + " | ");
					if (infoSch.birthNullCheck()) {
						taScreen.append("생일: " + infoSch.getBirth() + " | ");
					}
					taScreen.append("학교: " + infoSch.getSchool() + "\n");
				}
			}
		}
		
		public void showDataAll(Vector<PhoneInfo> infos) {
			String str = "";

			for(PhoneInfo info : infos) {
				str += "이름: " + info.getName() + " | ";
				str += "전번: " + info.getPhoneNumber() + " | ";
				str += "생일: " + info.getBirth() + " | ";
				
				if (info instanceof PhoneInfoSociety) {
					PhoneInfoSociety infoSoc = (PhoneInfoSociety)info;
					str += "직장: " + infoSoc.getFacility() + "\n";
					
					
				} else if (info instanceof PhoneInfoSchool) {
					PhoneInfoSchool infoSch = (PhoneInfoSchool)info;
					str += "직장: " + infoSch.getSchool() + "\n";
				}
			}
			taScreen.append(str);
		}
	}

	public static void main(String[] args) {
		new PhoneBookFrame();
	}

}
