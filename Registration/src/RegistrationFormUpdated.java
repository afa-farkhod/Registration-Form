import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTable table;
	private JComboBox<String> comboBoxName;

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
		
	public void fillComboBox() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","2207");
			String query = "select * from registration";
			PreparedStatement pstd = con.prepareStatement(query);
			ResultSet rst = pstd.executeQuery();
			
			while(rst.next()) {
				comboBoxName.addItem(rst.getString("name"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
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
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
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
					
					tfName.setText("");
					tfAddress.setText("");
					buttonGroup.clearSelection();
					tfAge.setText("");
					tfMobileNo.setText("");
					tfEmail.setText("");
					tfUserName.setText("");
					tfPassword.setText("");
					
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
				table.setModel(new DefaultTableModel());
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(546, 525, 103, 37);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(204, 0, 204));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(827, 525, 87, 37);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 98, 478, 378);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		scrollPane.setViewportView(lblNewLabel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table.getSelectedRow();
					String name_=(table.getModel().getValueAt(row, 0)).toString();
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					String query = "select * from registration where name='"+name_+"' ";
					PreparedStatement pstd = con.prepareStatement(query);
					ResultSet rstd = pstd.executeQuery();
					
					while(rstd.next()) {
						
						tfName.setText(rstd.getString("name"));
						tfAddress.setText(rstd.getString("address"));
						tfAge.setText(rstd.getString("age"));
						tfMobileNo.setText(rstd.getString("mobile"));
						tfEmail.setText(rstd.getString("email"));
						tfUserName.setText(rstd.getString("username"));
						tfPassword.setText(rstd.getString("password"));
					}
					
					pstd.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		scrollPane.setColumnHeaderView(table);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					Statement stmt = con.createStatement();
					String query = "select * from registration";
					ResultSet rs = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i = 0; i < cols; i++)
						colName[i] = rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String name, address, gender, age, mobile, email, username, password;
				
					while(rs.next()) {
					
						name = rs.getString(1);
						address = rs.getString(2);
						gender = rs.getString(3);
						age = rs.getString(4);
						mobile = rs.getString(5);
						email = rs.getString(6);
						username = rs.getString(7);
						password = rs.getString(8);
						String[] row = {name, address, gender, age, mobile, email, username, password};
						model.addRow(row);

					}
					
					stmt.close();
					con.close();
					
					fillComboBox();
								
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoad.setBounds(313, 525, 110, 37);
		contentPane.add(btnLoad);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					String query = "delete from registration where name='"+tfName.getText()+"'  ";
					PreparedStatement pstd = con.prepareStatement(query);
					pstd.executeUpdate();
					JOptionPane.showMessageDialog(null, tfName.getText()+" Deleted");
					pstd.close();
					con.close();
					tfName.setText("");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(433, 525, 103, 37);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					String query = "update registration set name='"+tfName.getText()+"' , address='"+tfAddress.getText()+"' , age='"+tfAge.getText()+"'  , mobile='"+tfMobileNo.getText()+"' , email='"+tfEmail.getText()+"' ,username='"+tfUserName.getText()+"' ,password='"+tfPassword.getText();
					PreparedStatement pstd = con.prepareStatement(query);
					pstd.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data is Updated");
					pstd.close();
					con.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(193, 525, 110, 37);
		contentPane.add(btnUpdate);
		
		comboBoxName = new JComboBox<String>();
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
				try {
					

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					String query = "select * from registration where name=? ";
					PreparedStatement pstd = con.prepareStatement(query);
					pstd.setString(1, (String) comboBoxName.getSelectedItem());
					ResultSet rstd = pstd.executeQuery();
					while(rstd.next()) {
						tfName.setText(rstd.getString("name"));
						tfAddress.setText(rstd.getString("address"));
						tfAge.setText(rstd.getString("age"));
						tfMobileNo.setText(rstd.getString("mobile"));
						tfEmail.setText(rstd.getString("email"));
						tfUserName.setText(rstd.getString("username"));
						tfPassword.setText(rstd.getString("password"));
					}
					
					pstd.close();
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		comboBoxName.setBounds(694, 54, 185, 26);
		contentPane.add(comboBoxName);
	}
}
