package ver10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneBookController implements ActionListener{
/* Controller 'has a' Model, View */
	
	// Model
	private PhoneBook book = PhoneBook.getPhoneBook();
	
	// View
	private PhoneBookFrame frame;
	
	public PhoneBookController(PhoneBookFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
