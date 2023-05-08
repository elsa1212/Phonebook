package ver10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame {
	
	/* Controller : btnListener, MenuListener */
	PhoneBookBtnController btnController = new PhoneBookBtnController(this);
	PhoneBookMenuController MenuController = new PhoneBookMenuController(this);
	
	/* JFrame Components*/
	Container c = getContentPane();
	
	JMenuBar mbPhoneBook =  new JMenuBar();
	
	JMenu mnuFile = new JMenu("파일");
	
	JMenuItem miInput = new JMenuItem("입력");
	JMenuItem miUpdate = new JMenuItem("수정");
	JMenuItem miDelete = new JMenuItem("삭제");
	JMenuItem miSearch = new JMenuItem("검색");
	JMenuItem miShowAll= new JMenuItem("전체 조회");
	JMenuItem miExit = new JMenuItem("종료");
	JMenuItem[] mItems = {miInput, miUpdate, miDelete, miSearch, miShowAll, miExit};
	
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JPanel pnlRadio = new JPanel();
	
	private JTextField tfName = new JTextField();
	private JTextField tfPhoneNum = new JTextField();
	private JTextField tfBirthDay = new JTextField();
	private JTextField tfDetail = new JTextField();
	private JTextField[] tfs = {tfName, tfPhoneNum, tfBirthDay, tfDetail}; 
	
	ButtonGroup detailGroup = new ButtonGroup();	
	JRadioButton btnSchool = new JRadioButton("학교", true);
	JRadioButton btnCompany = new JRadioButton("회사");
	JRadioButton[] details = {btnSchool, btnCompany};
	
	private JTextArea taScreen = new JTextArea(200, 50);

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
		
		setMenu();
		
		setCenterPanel();
		setNorthPanel();
		setSouthPanel();
		setRadioPanel();
		setListener();
	
		setVisible(true);
	}
	
	private void setMenu() {
		String[] itemNames = {"입력", "수정", "삭제", "검색", "전체 조회", "종료"};
		mbPhoneBook.add(mnuFile); // menubar에 파일 메뉴 추가.
		
		mnuFile.add(miInput);
		mnuFile.add(miUpdate);
		mnuFile.add(miDelete);
		mnuFile.add(miSearch);
		mnuFile.add(miShowAll);
		mnuFile.addSeparator();
		mnuFile.add(miExit);
		
		this.setJMenuBar(mbPhoneBook);
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
		
		pnlNorth.setVisible(false);
		c.add(pnlNorth, BorderLayout.NORTH);
	}
	
	public void showNorthPanel() {
		pnlNorth.setVisible(true);
	}
	
	public boolean checkNorthPanelVisible() {
		boolean result = false;
		if(pnlNorth.isVisible()) {
			result = true;
		}
		return result;
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
		taScreen.setEditable(false);
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
	
	private void setListener() {
		// btnController
		for(int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(btnController);
		}
		
		// menuController
		for(int i = 0; i < mItems.length; i++) {
			mItems[i].addActionListener(MenuController);
		}
	}	
	
	public String getTargetName() {
		String name = "";
		name = tfName.getText();
		
		return name;
	}
	
	public String[] getInfoTuple() {
		/* array of information */
		String[] infoTuple = new String[5];
		// 0: name, 1: phoneNum, 2: birthDay, 3: school, 4: company
		
		infoTuple[0] = tfName.getText();
		infoTuple[1] = tfPhoneNum.getText();
		infoTuple[2] = tfBirthDay.getText();
		
		if (btnSchool.isSelected()) {
			infoTuple[3] = tfDetail.getText();
			infoTuple[4] = "";
			
		} else if (btnCompany.isSelected()) {
			infoTuple[3] = "";
			infoTuple[4] = tfDetail.getText();
		}	
		
		for(String info : infoTuple) {
			System.out.println(info);
		}
		
		return infoTuple;
	}

	public void appendTaScreen(String message) {
		taScreen.append(message + "\n");
	}
	
	public void showData(PhoneInfo info) {
		String str = "";
		
		if(info == null) {
			JOptionPane.showMessageDialog(this, 
					"검색 결과 없음", "알림", 
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (info instanceof PhoneInfoSociety) {
				PhoneInfoSociety infoSoc = (PhoneInfoSociety)info;
				taScreen.append("이름: " + infoSoc.getName() + " | ");
				taScreen.append("전번: " + infoSoc.getPhoneNumber() + " | ");
				if (!infoSoc.birthNullCheck()) {
					taScreen.append("생일: " + infoSoc.getBirth() + " | ");
				}
				taScreen.append("직장: " + infoSoc.getFacility() + "\n");
				
			} else if (info instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSch = (PhoneInfoSchool)info;
				taScreen.append("이름: " + infoSch.getName() + " | ");
				taScreen.append("전번: " + infoSch.getPhoneNumber() + " | ");
				if (!infoSch.birthNullCheck()) {
					taScreen.append("생일: " + infoSch.getBirth() + " | ");
				}
				taScreen.append("학교: " + infoSch.getSchool() + "\n");
			}
		}
	}
	
	public void showDataAll(Vector<PhoneInfo> infos) {
		String str = "";

		taScreen.setText(""); // textArea Clear
		
		if(infos.size() == 0) {
			JOptionPane.showMessageDialog(this, 
					"데이터 없음", "알림", 
					JOptionPane.ERROR_MESSAGE);
			return;
		} 
		
		for (PhoneInfo info : infos) {
			str += "이름: " + info.getName() + " | ";
			str += "전번: " + info.getPhoneNumber() + " | ";
			str += "생일: " + info.getBirth() + " | ";
			
			if (info instanceof PhoneInfoSociety) {
				PhoneInfoSociety infoSoc = (PhoneInfoSociety)info;
				str += "직장: " + infoSoc.getFacility() + "\n";
					
			} else if (info instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSch = (PhoneInfoSchool)info;
				str += "학교: " + infoSch.getSchool() + "\n";
			}
		}
		taScreen.append(str);	
	}
	
//	public String infoToString(PhoneInfo info) {
//		String str = "";
//		return str;
//	}
	
	public static void main(String[] args) {
		new PhoneBookFrame();
	}


}
