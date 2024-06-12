import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddContactCName extends JFrame{
    private final JButton btnAddContact;
    private final JButton btnCancel;
    private int i;
    private final JTextField txtCName;

    AddContactCName(){
        setSize(600,400);
        setTitle("Add Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("Add Contact Form");
        titleLabel.setFont(new Font("",1,35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        i=UpdateContactForm.index;

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddContact=new JButton("Add Contact");
        btnAddContact.setFont(new Font("",1,20));
        btnAddContact.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){

                String coname=txtCName.getText();
                ContactMainForm.contactList.get(i).setName(coname);
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


        txtCName=new JTextField(10);
        txtCName.setFont(new Font("",1,20));
        JPanel nameTextPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtCName);
        textPanel.add(nameTextPanel);



        add("East",textPanel);

    }
}
