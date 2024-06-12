import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class ContactMainForm extends JFrame{
	
	public static final ArrayList<Contact>contactList=new ArrayList<>();
	
	private JButton btnAddContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact;
	private JButton btnUpdateContact;
	private JButton btnViewContact;
	private JButton btnExit;
	
	
	private AddContactForm addContactForm;
	private SearchContactForm searchContactForm;
	private UpdateContactForm updateContactForm;
	private DeleteContactForm deleteContactForm;
	private ViewContactForm viewContactForm;
	private ListContactForm listContactForm;



	
	ContactMainForm(){
		setSize(600,400);
		setTitle("Home Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6,1));
		
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,20));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContactForm==null){
					addContactForm=new AddContactForm();
					dispose();
				}
				addContactForm.setVisible(true);
			}
		});
		add(btnAddContact);
		
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,20));
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(searchContactForm==null){
					searchContactForm=new SearchContactForm();
					dispose();
				}
				searchContactForm.setVisible(true);
			}
		});
		add(btnSearchContact);
		
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,20));
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(updateContactForm==null){
					updateContactForm=new UpdateContactForm();
				}
				updateContactForm.setVisible(true);
			}
		});
		add(btnUpdateContact);
		
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,20));
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(deleteContactForm==null){
					deleteContactForm=new DeleteContactForm();
				}
				deleteContactForm.setVisible(true);
			}
		});
		add(btnDeleteContact);
		
		
		btnViewContact=new JButton("View Contact Form");
		btnViewContact.setFont(new Font("",1,20));
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(viewContactForm==null){
					viewContactForm=new ViewContactForm();
				}
				viewContactForm.setVisible(true);
			}
		});
		add(btnViewContact);

	}	

}
