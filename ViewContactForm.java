import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
class ViewContactForm extends JFrame{
	private JButton btnLBname;
	private JButton btnLBSalary;
	private JButton btnLBBday;
	private JButton btnCancel;
	
	private JTable tblContactDetails;
	private DefaultTableModel dtm;
	
	ViewContactForm(){
		setSize(600,400);
		setTitle("Contacts List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JLabel titleLabel=new JLabel("CONTACT LIST");
		titleLabel.setFont(new Font("",1,30)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		add("North",titleLabel);
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnLBname=new JButton("List by Name");
		btnLBname.setFont(new Font("",1,20)); 
		buttonPanel.add(btnLBname);
		btnLBname.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				
				for (int i = 0; i < ContactMainForm.contactList.size(); i++){
					Contact contact=ContactMainForm.contactList.get(i);
					Object[] rowData={contact.getName(), contact.getPnum(),contact.getConum(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData); 	
				}
			}
		});
		buttonPanel.add(btnLBname);
		
		
		btnLBSalary=new JButton("List by Salary");
		btnLBSalary.setFont(new Font("",1,20)); 
		buttonPanel.add(btnLBSalary);
		btnLBSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				
				for (int i = 0; i < ContactMainForm.contactList.size(); i++){
					Contact contact=ContactMainForm.contactList.get(i);
					Object[] rowData={contact.getName(), contact.getPnum(),contact.getConum(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData); 	
				}
			}
		});
		buttonPanel.add(btnLBSalary);
		
		btnLBBday=new JButton("List by Birthday");
		btnLBBday.setFont(new Font("",1,20)); 
		buttonPanel.add(btnLBBday);
		btnLBBday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dtm.setRowCount(0);
				
				for (int i = 0; i < ContactMainForm.contactList.size(); i++){
					Contact contact=ContactMainForm.contactList.get(i);
					Object[] rowData={contact.getName(), contact.getPnum(),contact.getConum(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData); 	
				}
			}
		});
		buttonPanel.add(btnLBBday);

		add("South",buttonPanel);
		
		
		
		String[] columnName={"Name","Phone","Company Name","Salary","Birthday"};
		dtm=new DefaultTableModel(columnName,10);
		tblContactDetails=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblContactDetails);
		
		add("Center",tablePane);

	}	
}
