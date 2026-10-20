import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exp1 extends JFrame implements ActionListener {

    JLabel Name, Rollno, Gender, Branch;
    JTextField txtname, txtroll, txtbranch;
    JRadioButton male, female;
    ButtonGroup g;
    JCheckBox terms;
    JButton submit, reset;

    private static final String URL = "jdbc:mysql://localhost:3306/form";
    private static final String USER = "root";
    private static final String PASS = "harshi";

    public Exp1() {
        setTitle("Student Registration Form");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Name = new JLabel("Name : ");
        Name.setBounds(30, 30, 120, 30);
        add(Name);

        txtname = new JTextField();
        txtname.setBounds(120, 30, 180, 30);
        add(txtname);

        Rollno = new JLabel("RollNo :");
        Rollno.setBounds(30, 60, 120, 30);
        add(Rollno);

        txtroll = new JTextField();
        txtroll.setBounds(120, 60, 180, 30);
        add(txtroll);

        Branch = new JLabel("Branch : ");
        Branch.setBounds(30, 90, 120, 30);
        add(Branch);

        txtbranch = new JTextField();
        txtbranch.setBounds(120, 90, 180, 30);
        add(txtbranch);

        Gender = new JLabel("Gender : ");
        Gender.setBounds(30, 120, 120, 30);
        add(Gender);

        male = new JRadioButton("Male");
        male.setBounds(120, 120, 80, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(200, 120, 80, 30);
        add(female);

        g = new ButtonGroup();
        g.add(male);
        g.add(female);

        terms = new JCheckBox("I accept Terms & Conditions");
        terms.setBounds(30, 170, 250, 30);
        add(terms);

        submit = new JButton("Submit");
        submit.setBounds(190, 210, 100, 35);
        submit.addActionListener(this);
        add(submit);

        reset = new JButton("Reset");
        reset.setBounds(50, 210, 100, 35);
        reset.addActionListener(this);
        add(reset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            txtname.setText("");
            txtroll.setText("");
            txtbranch.setText("");
            g.clearSelection();
            terms.setSelected(false);
            return;
        }

        if (txtname.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student Name");
            return;
        }
        if (txtroll.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Roll Number");
            return;
        }
        if (txtbranch.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Branch");
            return;
        }
        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select Gender");
            return;
        }
        if (!terms.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please accept Terms & Conditions");
            return;
        }

        String gender = male.isSelected() ? "Male" : "Female";
        String sql = "INSERT INTO student1 (name, rollno, branch, gender) VALUES (?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, txtname.getText().trim());
            pst.setString(2, txtroll.getText().trim());
            pst.setString(3, txtbranch.getText().trim());
            pst.setString(4, gender);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Registration Successful and saved to Database!\n\n"
                        + "Name : " + txtname.getText()
                        + "\nRoll no : " + txtroll.getText()
                        + "\nBranch : " + txtbranch.getText()
                        + "\nGender : " + gender);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Exp1();
    }
}