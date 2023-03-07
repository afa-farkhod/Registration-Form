import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfAddress;
	private JTextField tfAge;
	private JTextField tfMobileNo;
	private JTextField tfEmail;
	private JTextField tfUserName;
	private JTextField tfPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setBackground(new Color(0, 51, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FAbdu\\Downloads\\register.png"));
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbName = new JLabel("Name:");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbName.setBounds(24, 79, 121, 37);
		contentPane.add(lbName);
		
		JLabel lbAddress = new JLabel("Address:");
		lbAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAddress.setBounds(24, 146, 121, 37);
		contentPane.add(lbAddress);
		
		JLabel lbAge = new JLabel("Age:");
		lbAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAge.setBounds(24, 266, 121, 37);
		contentPane.add(lbAge);
		
		JLabel lbMobileNo = new JLabel("Mobile No.:");
		lbMobileNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbMobileNo.setBounds(24, 313, 121, 37);
		contentPane.add(lbMobileNo);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbEmail.setBounds(24, 360, 121, 37);
		contentPane.add(lbEmail);
		
		JLabel lbUserName = new JLabel("User Name:");
		lbUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbUserName.setBounds(24, 415, 121, 37);
		contentPane.add(lbUserName);
		
		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbPassword.setBounds(24, 462, 121, 37);
		contentPane.add(lbPassword);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfName.setBounds(152, 91, 185, 25);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAddress.setColumns(10);
		tfAddress.setBounds(152, 144, 185, 60);
		contentPane.add(tfAddress);
		
		JLabel lbGender = new JLabel("Gender:");
		lbGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbGender.setBounds(24, 228, 121, 37);
		contentPane.add(lbGender);
		
		tfAge = new JTextField();
		tfAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAge.setColumns(10);
		tfAge.setBounds(152, 278, 185, 25);
		contentPane.add(tfAge);
		
		tfMobileNo = new JTextField();
		tfMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfMobileNo.setColumns(10);
		tfMobileNo.setBounds(152, 325, 185, 25);
		contentPane.add(tfMobileNo);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(152, 372, 185, 25);
		contentPane.add(tfEmail);
		
		tfUserName = new JTextField();
		tfUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfUserName.setColumns(10);
		tfUserName.setBounds(152, 422, 185, 25);
		contentPane.add(tfUserName);
		
		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPassword.setColumns(10);
		tfPassword.setBounds(152, 474, 185, 25);
		contentPane.add(tfPassword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMale.setBounds(151, 239, 73, 21);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemale.setBounds(234, 239, 103, 21);
		contentPane.add(rdbtnFemale);
		
		JLabel lbUserRegistration = new JLabel("User Registration");
		lbUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbUserRegistration.setBounds(152, 22, 214, 37);
		contentPane.add(lbUserRegistration);
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
					String query = "insert into registration values(?,?,?,?,?,?,?,?)";
					PreparedStatement pstd = con.prepareStatement(query);
					pstd.setString(1,  tfName.getText());
					pstd.setString(2, tfAddress.getText());
					if(rdbtnMale.isSelected())	
						pstd.setString(3, rdbtnMale.getText());
					else
						pstd.setString(3, rdbtnFemale.getText());
					pstd.setInt(4, Integer.parseInt(tfAge.getText()));
					pstd.setInt(5, Integer.parseInt(tfMobileNo.getText()));
					pstd.setString(6, tfEmail.getText());
					pstd.setString(7, tfUserName.getText());
					pstd.setString(8, tfPassword.getText());
					
					int i = pstd.executeUpdate();
					JOptionPane.showMessageDialog(btnRegistration, i + "Record added successfully!");
					pstd.close();
					con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegistration.setBounds(24, 525, 166, 37);
		contentPane.add(btnRegistration);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfName.setText("");
				tfAddress.setText("");
				tfAge.setText("");
				tfMobileNo.setText("");
				tfEmail.setText("");
				tfUserName.setText("");
				tfPassword.setText("");
				buttonGroup.clearSelection();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(200, 525, 103, 37);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(311, 525, 87, 37);
		contentPane.add(btnExit);
	}
}
