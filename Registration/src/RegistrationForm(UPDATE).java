import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.dbutils.DbUtils;

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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;

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
	private JTextField tfSearch;
	private JPanel panel;
	private JPanel panel2;
	private JLabel lbPanelDisplay;
	private JLabel lbPanel2Display;
	private JLabel lbClockDisplay;


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
	public void clock() {
		
		Calendar cal = new GregorianCalendar();
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		lbClockDisplay.setText("Time: " + hour+" : "+minute+" : "+second);
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
	
	public RegistrationForm() {
				
		setBackground(new Color(0, 51, 51));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FAbdu\\Downloads\\register.png"));
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 669);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmInformation = new JMenuItem("Information");
		mnNew.add(mntmInformation);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNew.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("About");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "This is the simple User Registration desktop app, \nwhich shows the different sides of the window builder");
			}
		});
		mnNew.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open File");
		mnFile.add(mntmNewMenuItem_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
				if(action==0) {
					System.exit(1);
				}
			}
		});
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbName = new JLabel("Name:");
		lbName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbName.setBounds(24, 117, 121, 37);
		contentPane.add(lbName);
		
		JLabel lbAddress = new JLabel("Address:");
		lbAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAddress.setBounds(24, 184, 121, 37);
		contentPane.add(lbAddress);
		
		JLabel lbAge = new JLabel("Age:");
		lbAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAge.setBounds(24, 304, 121, 37);
		contentPane.add(lbAge);
		
		JLabel lbMobileNo = new JLabel("Mobile No.:");
		lbMobileNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbMobileNo.setBounds(24, 351, 121, 37);
		contentPane.add(lbMobileNo);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbEmail.setBounds(24, 398, 121, 37);
		contentPane.add(lbEmail);
		
		JLabel lbUserName = new JLabel("User Name:");
		lbUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbUserName.setBounds(24, 453, 121, 37);
		contentPane.add(lbUserName);
		
		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbPassword.setBounds(24, 500, 121, 37);
		contentPane.add(lbPassword);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfName.setBounds(156, 117, 185, 25);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAddress.setColumns(10);
		tfAddress.setBounds(156, 170, 185, 60);
		contentPane.add(tfAddress);
		
		JLabel lbGender = new JLabel("Gender:");
		lbGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbGender.setBounds(24, 266, 121, 37);
		contentPane.add(lbGender);
		
		tfAge = new JTextField();
		tfAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfAge.setColumns(10);
		tfAge.setBounds(155, 316, 185, 25);
		contentPane.add(tfAge);
		
		tfMobileNo = new JTextField();
		tfMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfMobileNo.setColumns(10);
		tfMobileNo.setBounds(155, 363, 185, 25);
		contentPane.add(tfMobileNo);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(155, 410, 185, 25);
		contentPane.add(tfEmail);
		
		tfUserName = new JTextField();
		tfUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfUserName.setColumns(10);
		tfUserName.setBounds(155, 460, 185, 25);
		contentPane.add(tfUserName);
		
		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPassword.setColumns(10);
		tfPassword.setBounds(155, 512, 185, 25);
		contentPane.add(tfPassword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnMale.setBounds(151, 270, 73, 21);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnFemale.setBounds(234, 270, 103, 21);
		contentPane.add(rdbtnFemale);
		
		JLabel lbUserRegistration = new JLabel("User Registration");
		lbUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbUserRegistration.setBounds(156, 70, 214, 37);
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
					JOptionPane.showMessageDialog(btnRegistration, "Record added successfully!");
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
					e1.printStackTrace();
				}
			}
		});
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegistration.setBounds(24, 565, 166, 37);
		contentPane.add(btnRegistration);
		
		JButton btnReset = new JButton("Clear");
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
		btnReset.setBounds(546, 565, 103, 37);
		contentPane.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(401, 159, 478, 378);
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
					e1.printStackTrace();
				}		
			}
		});
		scrollPane.setColumnHeaderView(table);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
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
					
					e1.printStackTrace();
				}
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoad.setBounds(313, 565, 110, 37);
		contentPane.add(btnLoad);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do you really want to delete?","Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
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
					e1.printStackTrace();
				}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(433, 565, 103, 37);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					String query = "Update registration set name='"+tfName.getText()+"' ,address='"+tfAddress.getText()+"' ,age='"+tfAge.getText()+"' ,mobile='"+tfMobileNo.getText()+"' ,email='"+tfEmail.getText()+"' ,username='"+tfUserName.getText()+"' ,password='"+tfPassword.getText()+"' where name='"+tfName.getText()+"' ";
					PreparedStatement pstd = con.prepareStatement(query);
					pstd.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data is Updated");
					pstd.close();
					con.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(193, 565, 110, 37);
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
		comboBoxName.setBounds(694, 113, 185, 26);
		contentPane.add(comboBoxName);
		
		tfSearch = new JTextField();
		tfSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean foundData = false;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "2207");
					String query = "select * from registration where name=? ";
					PreparedStatement pstd = con.prepareStatement(query);
					pstd.setString(1, tfSearch.getText());
					ResultSet rstd = pstd.executeQuery();
					  
						while(rstd.next()) {
							tfName.setText(rstd.getString("name"));
							tfAddress.setText(rstd.getString("address"));
							tfAge.setText(rstd.getString("age"));
							tfMobileNo.setText(rstd.getString("mobile"));
							tfEmail.setText(rstd.getString("email"));
							tfUserName.setText(rstd.getString("username"));
							tfPassword.setText(rstd.getString("password"));
							lbPanelDisplay.setText(rstd.getString("name"));
							lbPanel2Display.setText(rstd.getString("email"));
						}
					pstd.close();
					con.close();
					rstd.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
//				} finally {
//					if(!foundData) {
//						JOptionPane.showMessageDialog(null, "NO DATA FOR THIS NAME");
//					}
				}
			}
		});
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfSearch.setColumns(10);
		tfSearch.setBounds(401, 117, 185, 25);
		contentPane.add(tfSearch);
		
		JLabel lbSearch = new JLabel("Search");
		lbSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSearch.setBounds(401, 82, 121, 37);
		contentPane.add(lbSearch);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(401, 10, 478, 70);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("User Name", null, panel, null);
		panel.setLayout(null);
		
		lbPanelDisplay = new JLabel("");
		lbPanelDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPanelDisplay.setBounds(0, 0, 473, 43);
		panel.add(lbPanelDisplay);
		
		panel2 = new JPanel();
		tabbedPane.addTab("User email", null, panel2, null);
		panel2.setLayout(null);
		
		lbPanel2Display = new JLabel("");
		lbPanel2Display.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPanel2Display.setBounds(0, 0, 473, 43);
		panel2.add(lbPanel2Display);
		
		lbClockDisplay = new JLabel("");
		lbClockDisplay.setForeground(SystemColor.activeCaption);
		lbClockDisplay.setBackground(SystemColor.activeCaption);
		lbClockDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbClockDisplay.setBounds(756, 566, 137, 35);
		contentPane.add(lbClockDisplay);
	
		clock();
	}
} 
