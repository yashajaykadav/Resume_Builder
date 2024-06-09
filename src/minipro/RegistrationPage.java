package minipro;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

import javax.swing.*;

public class RegistrationPage extends JFrame {

	private JPanel contentPane;
	private JTextField fnText,lnText,emailText,phoneText;
	private JPasswordField passText1,passText2;
	 
	
	public static void main(String[] args) {
					RegistrationPage frame = new RegistrationPage();
					frame.setVisible(true);
	}

	public RegistrationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRACTION");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 50));
		lblNewLabel.setBounds(185, 31, 408, 67);
		contentPane.add(lblNewLabel);
		
		JLabel info = new JLabel("FILL INFORMATION CAREFULLY");
		info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		info.setForeground(Color.WHITE);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBounds(195, 108, 398, 27);
		contentPane.add(info);
		
		JLabel fn = new JLabel("FIRST NAME ");
		fn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		fn.setHorizontalAlignment(SwingConstants.CENTER);
		fn.setForeground(Color.WHITE);
		fn.setBackground(Color.BLACK);
		fn.setBounds(60, 162, 115, 13);
		contentPane.add(fn);
		
		JLabel ln = new JLabel("LAST NAME ");
		ln.setHorizontalAlignment(SwingConstants.CENTER);
		ln.setForeground(Color.WHITE);
		ln.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ln.setBackground(Color.BLACK);
		ln.setBounds(431, 163, 153, 13);
		contentPane.add(ln);
		
		fnText = new JTextField("");
		fnText.setForeground(getForeground());
		fnText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e2) {
								
				char c = e2.getKeyChar();
				
				if(c>='0'&&c<='9') {
					
						fnText.setEditable(false);
				}
				else {
					
					
						fnText.setEditable(true);
						
				}
			}
		});
	
		fnText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		fnText.setBounds(60, 196, 308, 38);
		contentPane.add(fnText);
		fnText.setColumns(50);
		
		lnText = new JTextField();
		lnText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e3) {
                char c = e3.getKeyChar();
				
				if(c>='0'&&c<='9') {
					
					lnText.setEditable(false);
				}
				else {
             
						lnText.setEditable(true);
					
			}}
				
			
		});
		lnText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lnText.setColumns(10);
		lnText.setBounds(441, 196, 308, 37);
		contentPane.add(lnText);
		
		JLabel lblFirstName = new JLabel("E-MAIL");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFirstName.setBackground(Color.BLACK);
		lblFirstName.setBounds(60, 276, 73, 17);
		contentPane.add(lblFirstName);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		emailText.setColumns(10);
		emailText.setBounds(60, 314, 689, 38);
		contentPane.add(emailText);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setBounds(60, 394, 104, 17);
		contentPane.add(lblPassword);
		
		passText1 = new JPasswordField();
		passText1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passText1.setColumns(10);
		passText1.setBounds(60, 433, 308, 38);
		contentPane.add(passText1);
		
		passText2 = new JPasswordField();
		passText2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passText2.setColumns(10);
		passText2.setBounds(441, 433, 308, 38);
		contentPane.add(passText2);
		
		JLabel lblRetypePassword = new JLabel("RETYPE - PASSWORD");
		lblRetypePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetypePassword.setForeground(Color.WHITE);
		lblRetypePassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRetypePassword.setBackground(Color.BLACK);
		lblRetypePassword.setBounds(436, 394, 178, 17);
		contentPane.add(lblRetypePassword);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhone.setBackground(Color.BLACK);
		lblPhone.setBounds(60, 516, 89, 17);
		contentPane.add(lblPhone);
		
		phoneText = new JTextField();
		phoneText.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				String num = phoneText.getText();
				int length = num.length();
				char c = e.getKeyChar();
				
				if(c>='0'&&c<='9') {
					if(length<10) {
						phoneText.setEditable(true);
					}
				else {
					phoneText.setEditable(false);
				}
				}
				else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						
						phoneText.setEditable(true);
					}
					else {
						phoneText.setEditable(false);
					}
				}
			}
			
		});
		phoneText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phoneText.setColumns(10);
		phoneText.setBounds(60, 549, 689, 38);
		contentPane.add(phoneText);
		
		JButton rbtn = new JButton("NEXT");
		rbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName , lastName , email , phone ,pass,pass2;
				
				firstName = fnText.getText().toString().toUpperCase();
				lastName = lnText.getText().toString().toUpperCase();
				email =emailText.getText().toString();
				phone = phoneText.getText().toString();
				pass = passText1.getText().toString();
				pass2 = passText2.getText().toString();
				
				if(!pass.equals(pass2)){
					JOptionPane.showMessageDialog(null, "Passwords Are Not Matching !!");
				}
				else if(firstName.trim().isEmpty() || lastName.trim().isEmpty() || email.trim().isEmpty() ||phone.trim().isEmpty()||pass.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Fill All Details" );
				}
				else {
			
				
				try {
					
					DataBaseCon db = new DataBaseCon();
					db.DataBase();
			         PreparedStatement ps  = db.con.prepareStatement("INSERT INTO `register` VALUES ('"+firstName+"','"+lastName+"','"+email+"','"+pass+"','"+phone+"')");
			        boolean i = ps.execute();
			        
			        if(!i) {
			        	JOptionPane.showMessageDialog(null,"Successfull Registered");
			        	dispose();
			        	LoginPage lp = new LoginPage();
			        	lp.textuser.setText(email);
			        	lp.textpass.setText(pass);
			        	lp.setVisible(true);
			        }
			        else {
			        	JOptionPane.showMessageDialog(null,"Enconter error");
			        }
			         
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "DataBase Is Not Started");
				}}
			}
		});
		rbtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				
				
				rbtn.setBackground(Color.GREEN);
				
			}
			public void mouseExited(MouseEvent e) {
				
		
				rbtn.setBackground(new Color(153, 204, 153));
			}
		});
		rbtn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rbtn.setBorderPainted(false);
		rbtn.setBackground(new Color(153, 204, 153));
		rbtn.setBounds(623, 616, 127, 37);
		contentPane.add(rbtn);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered (MouseEvent e) {
				btnBack.setBackground(new Color(210, 105, 30));
				btnBack.setForeground(Color.BLACK);
			}
			public void mouseExited(MouseEvent e) {
				btnBack.setForeground(Color.WHITE);
				btnBack.setBackground(new Color(255, 153, 102));
				
				
			}
		});
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				LoginPage lg = new LoginPage();
				lg.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(255, 153, 102));
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setBounds(457, 616, 127, 37);
		contentPane.add(btnBack);
		
		JCheckBox passcheck = new JCheckBox("");
		passcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(passcheck.isSelected()) {
					passText1.setEchoChar((char)0);
					passText2.setEchoChar((char)0);
				}
				else {
					passText1.setEchoChar('*');
					passText2.setEchoChar('*');
				}
				
			}
		});
		passcheck.setBounds(33, 443, 21, 21);
		setLocationRelativeTo(null);
		contentPane.add(passcheck);
	}
}
