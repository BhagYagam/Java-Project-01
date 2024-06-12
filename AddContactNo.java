import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddContactNo extends JFrame{
    private final JButton btnAddContact;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtNo;

    AddContactNo(){
        setSize(600,400);
        setTitle("Add Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Customer Form");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateContactForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddContact=new JButton("Add Customer");
        btnAddContact.setFont(new Font("",1,20));
        btnAddContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                String pnum=txtNo.getText();
                ContactMainForm.contactList.get(i).setPhoneNumber(pnum);
            }
        });

        buttonPanel.add(btnAddContact);

        btnCancel=new JButton("Cancel");
        btnCancel.setFont(new Font("",1,20));
        buttonPanel.add(btnCancel);

        add("South",buttonPanel);

        JPanel labelPanel=new JPanel(new GridLayout(1,1,3,3));

        JLabel lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,20));
        labelPanel.add(lblName);


        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(6,1,3,3));


        txtNo=new JTextField(10);
        txtNo.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtNo);
        textPanel.add(nameTextPanel);



        add("East",textPanel);

    }
}
