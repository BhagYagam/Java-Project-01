import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
class AddContactForm extends JFrame{
	private final JButton btnAddContact;
	private final JButton btnCancel;
	private final JButton btnHomepage;	
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPnum;
	private JTextField txtConame;
	private JTextField txtSalary;
	private JTextField txtBday;
	private String ID;
	
	private ChangeNo changeNo;
	private ChangeSalary changeSalary;
	private ChangeBday changeBday;
	private SuccessMsg successMsg; 
	
	AddContactForm(){
		setSize(700,500);
		setTitle("Add Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel hpanel=new JPanel(new GridLayout(2,1,3,3));
		JLabel titleLabel=new JLabel("ADD CONTACT");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		hpanel.add(titleLabel);
		
		ID=contactIdGenarate();
		
		JPanel cIdPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblId=new JLabel("Contact ID - "+ID);
		lblId.setFont(new Font("",1,20));
		cIdPanel.add(lblId);
		hpanel.add(cIdPanel);
		
		add("North", hpanel);
		
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAddContact=new JButton("Add Customer");
		btnAddContact.setFont(new Font("",1,20)); 
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=ID;
				String name=txtName.getText();
				String pnum=txtPnum.getText();
				String coname=txtConame.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				String bday=txtBday.getText();
				
					if(pnum.length()!=10|| pnum.charAt(0)!='0'){
						InvalidPnum.Ipnum();
					}else if(salary<0){
						InvalidSalary.ISalary();
					}else if(checkBirthday(bday)){
						InvalidBday.Ibday();
					}else{
						Contact contact=new Contact(ID,name,pnum,salary,coname,bday);
						ContactMainForm.contactList.add(contact);
						SuccessMsg.Save();
						dispose();
						new AddContactForm().setVisible(true);
					}
			}
			});

		buttonPanel.add(btnAddContact);
		
		
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20)); 
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				dispose();
				new AddContactForm().setVisible(true);
			}
        });
		buttonPanel.add(btnCancel);
		
		add("South",buttonPanel);
		
		
		
		btnHomepage=new JButton("Back To HomePage");
		btnHomepage.setFont(new Font("",1,20)); 
		btnHomepage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                dispose();
                new ContactMainForm().setVisible(true);
            }
		}
		);

		buttonPanel.add(btnHomepage);
		
		add("South",buttonPanel);
		
		
		
		JPanel labelPanel=new JPanel(new GridLayout(5,1,3,3));
		
		
		JLabel lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20)); 
		labelPanel.add(lblName);
		
		JLabel lblPnum=new JLabel("Phone Number");
		lblPnum.setFont(new Font("",1,20)); 
		labelPanel.add(lblPnum);
		
		JLabel lblConame=new JLabel("Company Name");
		lblConame.setFont(new Font("",1,20)); 
		labelPanel.add(lblConame);
		
		JLabel lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20)); 
		labelPanel.add(lblSalary);
		
		JLabel lblBday=new JLabel("Birthday");
		lblBday.setFont(new Font("",1,20)); 
		labelPanel.add(lblBday);
		
		add("West",labelPanel);




		JPanel textPanel=new JPanel(new GridLayout(5,1,3,3));
		
		
		txtName=new JTextField(10);
		txtName.setFont(new Font("",1,20)); 
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);

		txtPnum=new JTextField(10);
		txtPnum.setFont(new Font("",1,20)); 
		JPanel pnumTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnumTextPanel.add(txtPnum);
		textPanel.add(pnumTextPanel);
	
		txtConame=new JTextField(10);
		txtConame.setFont(new Font("",1,20)); 
		JPanel conameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		conameTextPanel.add(txtConame);
		textPanel.add(conameTextPanel);
						
		txtSalary=new JTextField(6);
		txtSalary.setFont(new Font("",1,20));
		JPanel salTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		salTextPanel.add(txtSalary);
		textPanel.add(salTextPanel);
		
		txtBday=new JTextField(10);
		txtBday.setFont(new Font("",1,20)); 
		JPanel bdayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		bdayTextPanel.add(txtBday);
		textPanel.add(bdayTextPanel);
		

		add("East",textPanel);		
		
		}
		
		 public static boolean checkBirthday(String bday) {
		 
			 int year = Integer.parseInt(bday.substring(0, 4));
			 int month = Integer.parseInt(bday.substring(5, 7));
			 int day = Integer.parseInt(bday.substring(8, 10));

				if (year <= 2023 && month >= 1 && month <= 12 && day >= 1 && day <= 31) {
				   return false;
				}

				return true;
		 }	
	
		 public static String contactIdGenarate(){
			String str="";
			int x=ContactMainForm.contactList.size()+1;
			if(ContactMainForm.contactList.size()-1<9){
				str="B000"+x;
			}else if(ContactMainForm.contactList.size()-1<99){
				str="B00"+x;
			}else if(ContactMainForm.contactList.size()-1<999){
				str="B0"+x;
			}else if(ContactMainForm.contactList.size()-1<9999){
				str="B"+x;
			}
			return str;
		}
}


