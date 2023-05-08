package verPrac;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PhoneBookFrame extends JFrame {
	/* Fields */
	
	// Model
	PhoneBook book = PhoneBook.getPhoneBook();
	
	// JComponent
	Container c = getContentPane();
	
	JMenuBar mbPhoneBook = new JMenuBar(); // MenuBar
	JMenu menuFile = new JMenu("파일");
	JMenuItem miInput = new JMenuItem("입력");
	JMenuItem miModify = new JMenuItem("수정");
	JMenuItem miDelete = new JMenuItem("삭제");
	JMenuItem miSearch = new JMenuItem("검색");
	JMenuItem miInquiry = new JMenuItem("전체조회");
	JMenuItem[] itemsFile = {miInput, miModify, miDelete, miSearch, miInquiry};
	
	JPanel pnlCenter = new JPanel(); // Center Panel
	JTextArea taScreen = new JTextArea(80, 40);
	 
	JPanel pnlSouth = new JPanel(); // South Panel
	JButton btnInput = new JButton("입력");
	JButton btnModify = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	JButton btnInquiry = new JButton("전체조회");
	JButton[] btnsSouth = {btnInput, btnModify, btnDelete, btnSearch, btnInquiry};
	
	// Class : Dialog 
	PhoneBookDialog dialog = new PhoneBookDialog("Hello", this);
	
	// Class : Listener - controller 
	PhoneBookController controller = new PhoneBookController(this, dialog);
	
	public PhoneBookFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My phoneBook");
		setSize(500, 500);
		
		setUI();
		
		setVisible(true);
	}
	
	public void setUI() {
		setMenuBar();
		setCenterPanel();
		setSouthPanel();
		setListener();
	}
	
	private void setMenuBar() {
		mbPhoneBook.add(menuFile);
		for(int i = 0; i < itemsFile.length; i++) {
			menuFile.add(itemsFile[i]);
		}
		
		this.setJMenuBar(mbPhoneBook);
	}
	
	private void setCenterPanel() {
		taScreen.setEditable(false); // View를 임의로 조작 못하도록.
		pnlCenter.add(taScreen);
		c.add(pnlCenter);
	}
	
	private void setSouthPanel() {
		for(int i = 0; i < btnsSouth.length; i++) {
			pnlSouth.add(btnsSouth[i]);
		}
		c.add(pnlSouth, BorderLayout.SOUTH);
	}
	
	public void setListener() {
		
		for(int i = 0; i < itemsFile.length; i++) {
			itemsFile[i].addActionListener(controller);
		}
		
		for(int i = 0; i < btnsSouth.length; i++) {
			btnsSouth[i].addActionListener(controller);
		}
	} // View Method
	
	public void showInfo(PhoneInfo info) {
		String infoTuple = "";
		String specified = "";
		
		infoTuple = info.getName() + " | " + info.getPhoneNumber() + " | ";
		infoTuple += info.getBirth() + " | ";
		
		if (info instanceof PhoneInfoSchool) {
			specified = ((PhoneInfoSchool) info).getSchool();
		} else {
			specified = ((PhoneInfoCompany) info).getCompany();
		}
		
		infoTuple += specified + "\n";
		taScreen.setText(infoTuple);
	}
	
	public void showInfoTable() {
		Vector<PhoneInfo> table = book.getInfoTable();
		String infoTuple = "";
		String specified = "";
		
		for(int i = 0; i < table.size(); i++) {
			PhoneInfo infoInTable = table.get(i);
			infoTuple = infoInTable.getName() + " | " + infoInTable.getPhoneNumber() + " | ";
			infoTuple += infoInTable.getBirth() + " | ";
			
			if (infoInTable instanceof PhoneInfoSchool) {
				specified = ((PhoneInfoSchool) infoInTable).getSchool();
			} else {
				specified = ((PhoneInfoCompany) infoInTable).getCompany();
			}
			
			infoTuple += specified + "\n";
			taScreen.append(infoTuple);
		}
	} 
	
	public static void main(String[] args) {
		new PhoneBookFrame();
	}

}
