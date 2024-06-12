import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SearchContactForm extends JFrame {
    private JButton btnSearch;
    private JButton btnHomepage;
    private JTextField searchby;
    public static int index;

    private JLabel txtId;
    private JLabel txtName;
    private JLabel txtNo;
    private JLabel txtCName;
    private JLabel txtSalary;
    private JLabel txtBirth;

    private String gotId;
    private String gotName;
    private String gotPnum;
    private String gotCName;
    private String gotSal;
    private String gotBday;

    SearchContactForm() {
        setSize(600, 400);
        setTitle("Search Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel uPanel = new JPanel(new GridLayout(2, 1, 4, 4));

        JLabel titleLabel = new JLabel("Search CONTACT");
        titleLabel.setFont(new Font("", Font.BOLD, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        uPanel.add(titleLabel);

        searchby = new JTextField(10);
        searchby.setFont(new Font("", Font.BOLD, 20));
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(searchby);
        uPanel.add(idTextPanel);

        add("North", uPanel);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", Font.BOLD, 20));
        JPanel searchBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchBtnPanel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean found = false;
                for (int i = 0; i < ContactMainForm.contactList.size(); i++) {
                    Contact contact = ContactMainForm.contactList.get(i);
                    if (searchby.getText().equals(contact.getName()) || searchby.getText().equals(contact.getPnum())) {
                        index = i;
                        gotId = contact.getId();
                        gotName = contact.getName();
                        gotPnum = contact.getPnum();
                        gotCName = contact.getConum();
                        gotSal = String.valueOf(contact.getSalary());
                        gotBday = contact.getBirthday();

                        txtId.setText(gotId);
                        txtName.setText(gotName);
                        txtNo.setText(gotPnum);
                        txtCName.setText(gotCName);
                        txtSalary.setText(gotSal);
                        txtBirth.setText(gotBday);

                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(SearchContactForm.this, "Contact not found.");
                }
            }
        });
        idTextPanel.add(searchBtnPanel);

        add("North", idTextPanel);

        JPanel labelPanel = new JPanel(new GridLayout(6, 1, 4, 4));

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
        txtId = new JLabel();
        txtId.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtId);

        txtName = new JLabel();
        txtName.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtName);

        txtNo = new JLabel();
        txtNo.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtNo);

        txtCName = new JLabel();
        txtCName.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtCName);

        txtSalary = new JLabel();
        txtSalary.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtSalary);

        txtBirth = new JLabel();
        txtBirth.setFont(new Font("", Font.BOLD, 20));
        textPanel.add(txtBirth);

        add("Center", textPanel);

        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnHomepage = new JButton("Back To HomePage");
        btnHomepage.setFont(new Font("", 1, 20));
        btnHomepage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to go back to homepage
            }
        });
        downPanel.add(btnHomepage);

        add("South", downPanel);
    }
}