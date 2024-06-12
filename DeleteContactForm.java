import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DeleteContactForm extends JFrame {
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnHomepage;
    private int x = -1; 

    private JTextField searchby;

    
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblPnum;
    private JLabel lblConame;
    private JLabel lblSalary;
    private JLabel lblBday;
    
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;
    
  
    
    DeleteContactForm() {
        setSize(600, 400);
        setTitle("Delete Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("DELETE CONTACT");
        titleLabel.setFont(new Font("", Font.BOLD, 35)); 
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North", titleLabel);
        
        JPanel textPanel = new JPanel(new GridLayout(1, 1, 3, 3));

        txtId = new JTextField(10);
        txtId.setFont(new Font("", Font.BOLD, 20));
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(txtId);
        textPanel.add(idTextPanel);
        
        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", Font.BOLD, 20)); 
        JPanel searchBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchBtnPanel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean found =false;
                for(Contact contact:ContactMainForm.contactList){
                    if(searchby.getText().equals(contact.getName()) || searchby.getText().equals(contact.getPnum())){
                        txtName.setText("Name: " + contact.getName());
                        txtNo.setText("Phone Number: " + contact.getPnum());
                        txtCName.setText("Company Name: " + contact.getConum());
                        txtSalary.setText("Salary: " + contact.getSalary());
                        txtBirth.setText("Birthday: " + contact.getBirthday());
                        found = true;
                        break;
                    }else {
                        JOptionPane.showMessageDialog(null, "Contact not found");
                    }
                }
            }
        });
        textPanel.add(searchBtnPanel);
        
        
        add("North", textPanel);
        
        
        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                
        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("", Font.BOLD, 20));
        downPanel.add(btnDelete);

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (x != -1) { // Ensure a contact is selected
                    ContactMainForm.contactList.remove(x);
                    //dtm.setRowCount(0);
                    JOptionPane.showMessageDialog(null, "Contact deleted.");
                    //clearFields();
                    x = -1; // Reset the selected index
                } else {
                    JOptionPane.showMessageDialog(null, "No contact selected for deletion.");
                }
            }
        });
        add("South", downPanel);


		
		
		 JPanel labelPanel = new JPanel(new GridLayout(6, 1, 3, 3));

        lblId = new JLabel("Contact Id");
        lblId.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblId);

        lblName = new JLabel("Name");
        lblName.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblName);

        lblPnum = new JLabel("Phone Number");
        lblPnum.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblPnum);

        lblConame = new JLabel("Company Name");
        lblConame.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblConame);

        lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblSalary);

        lblBday = new JLabel("Birthday");
        lblBday.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblBday);

        add("West", labelPanel);
	

	}
}
