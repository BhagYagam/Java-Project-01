import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UpdateContactForm extends JFrame {

    public static int index;
    
    private JTextField searchby;

    private  String gotId;
    private  String gotName;
    private  String gotPnum;
    private  String gotCName;
    private  String gotSal;
    private  String gotBday;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtNo;
    private JTextField txtCName;
    private JTextField txtSalary;
    private JTextField txtBirth;
    
    private AddContactName addContactName;
    private AddContactNo addContactNo;
    private AddContactCName addContactCName;
    private AddContactSalary addContactSalary;
    
  
    
    UpdateContactForm() {
        setSize(600, 400);
        setTitle("Update Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("UPDATE CONTACT");
        titleLabel.setFont(new Font("", Font.BOLD, 35)); 
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North", titleLabel);
        
        JPanel searchpanel = new JPanel(new GridLayout(1, 1, 3, 3));

        searchby = new JTextField(10);
        searchby.setFont(new Font("", Font.BOLD, 20));
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(searchby);
        searchpanel.add(idTextPanel);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", Font.BOLD, 20)); 
        JPanel searchBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchBtnPanel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean found =false;
                index=0;
                for(int i=0; i<ContactMainForm.contactList.size(); i++) {
                    Contact contact=ContactMainForm.contactList.get(i);
                    if(searchby.getText().equals(contact.getName()) || searchby.getText().equals(contact.getPnum())) {
                        index = i;
                        gotId = (contact.getId());
                        gotName = (contact.getName());
                        gotPnum = (contact.getPnum());
                        gotCName = (contact.getConum());
                        gotSal = String.valueOf((contact.getSalary()));
                        gotBday = (contact.getBirthday());

                        txtId.setText(gotId);
                        txtName.setText(gotName);
                        txtNo.setText(gotPnum);
                        txtCName.setText(gotSal);
                        txtSalary.setText(gotSal);
                        txtBirth.setText(gotBday);
                    }
                    }
                }

        });
        searchpanel.add(searchBtnPanel);
        
        
        add("North", searchpanel);

		
		JPanel downPanel = new JPanel(new GridLayout(2, 3, 3, 3));

		JButton btnUpdateName=new JButton("Update Name");
        btnUpdateName.setFont(new Font("",1,20));
        btnUpdateName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addContactName==null){
                    addContactName=new AddContactName();
                }
                addContactName.setVisible(true);
            }
        });
        downPanel.add(btnUpdateName);

        JButton btnUpdateNo=new JButton("Update Pno");
        btnUpdateNo.setFont(new Font("",1,20));
        btnUpdateNo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addContactNo==null){
                    addContactNo=new AddContactNo();
                }
                addContactNo.setVisible(true);
            }
        });
        downPanel.add(btnUpdateNo);

        JButton btnCName=new JButton("Update Company");
        btnCName.setFont(new Font("",1,20));
        btnCName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addContactCName==null){
                    addContactCName=new AddContactCName();
                }
                addContactCName.setVisible(true);
            }
        });
        downPanel.add(btnCName);

        JButton btnSalary=new JButton("Update Salary");
        btnSalary.setFont(new Font("",1,20));
        btnSalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addContactSalary==null){
                    addContactSalary=new AddContactSalary();
                }
                addContactSalary.setVisible(true);
            }
        });
        downPanel.add(btnSalary);

        add("South", downPanel);
		
        
        
        
		
		JPanel labelPanel = new JPanel(new GridLayout(6, 1, 3, 3));

        JLabel lblId = new JLabel("Contact Id");
        lblId.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblId);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblName);

        JLabel lblPnum = new JLabel("Phone Number");
        lblPnum.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblPnum);

        JLabel lblConame = new JLabel("Company Name");
        lblConame.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblConame);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblSalary);

        JLabel lblBday = new JLabel("Birthday");
        lblBday.setFont(new Font("", Font.BOLD, 20)); 
        labelPanel.add(lblBday);

        add("West", labelPanel);

        JPanel textPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        txtId = new JTextField();
        txtId.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtId);

        txtName = new JTextField();
        txtName.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtName);

        txtNo = new JTextField();
        txtNo.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtNo);

        txtCName = new JTextField();
        txtCName.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtCName);

        txtSalary = new JTextField();
        txtSalary.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtSalary);

        txtBirth = new JTextField();
        txtBirth.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtBirth);

        add("Center", textPanel);


    }
}
