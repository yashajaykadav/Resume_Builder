package minipro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class LoginPage extends JFrame {
	public JTextField textuser;
	public JPasswordField textpass;

	public static void main(String[] args) {
		
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				
	}

	
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		JLabel loginlogo = new JLabel();
		loginlogo.setIcon(new ImageIcon(new ImageIcon("img/login.png").getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT)));

		loginlogo.setBounds(294, 100, 90, 90);
		
		getContentPane().add(loginlogo);
		
		JLabel PageName = new JLabel("wel-come");
		PageName.setHorizontalAlignment(SwingConstants.CENTER);
		PageName.setFont(new Font("Algerian", Font.BOLD, 50));
		PageName.setBounds(183, 47, 306, 80);
		PageName.setForeground(Color.WHITE);
		getContentPane().add(PageName);
		
		setSize(700,600);
		setLocationRelativeTo(PageName);
		
		JLabel un = new JLabel("UserEmail");
		un.setForeground(Color.WHITE);
		un.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		un.setBounds(60, 215,114, 30);
		getContentPane().add(un);
		
		textuser = new JTextField();
		textuser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textuser.setBounds(60, 255, 574, 38);
		getContentPane().add(textuser);
		textuser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblPassword.setBounds(60, 330, 114, 30);
		getContentPane().add(lblPassword);
		
		textpass = new JPasswordField();
		textpass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textpass.setEchoChar('*');
		textpass.setBounds(60, 377, 574, 38);
		getContentPane().add(textpass);
		
		JButton subbtn = new JButton("LOGIN");
		subbtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered( MouseEvent e) {
				subbtn.setBorderPainted(false);
				subbtn.setForeground(Color.WHITE);
				subbtn.setBackground(Color.GREEN);
				subbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
				
			}
		});
		
		subbtn.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				subbtn.setBorderPainted(false);
				subbtn.setForeground(Color.BLACK);
				subbtn.setBackground(new Color(153, 204, 153));
				subbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
				
			}
		});
		subbtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String username = textuser.getText().toString();
                char[] passecho = textpass.getPassword();
                String userpass = new String(passecho);
               
				
				try {
					DataBaseCon db = new DataBaseCon();
					db.DataBase();
			        java.sql.PreparedStatement ps = db.con.prepareStatement("select * from register where E_mail = '"+username+"' and password='"+userpass+"'");
			        java.sql.ResultSet rs = ps.executeQuery();
			        
			        if(rs.next()) {
			        	
			        	MainPage mp = new MainPage();
			        	mp.setVisible(true);
			        	mp.LblMail.setText(username);
			        	dispose();
			        }
			        else {
			        	JOptionPane.showMessageDialog(null,"Fill correct details");
			        	textuser.setText("");
			        	
			        }
			     
			        }
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null,"DataBase Is not Started");
				}
			}
		});
		subbtn.setBorderPainted(false);
		subbtn.setForeground(Color.BLACK);
		subbtn.setBackground(new Color(153, 204, 153));
		subbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		subbtn.setBounds(464, 490, 170, 40);
		getContentPane().add(subbtn);
		
		JButton btnRegistration = new JButton("REGISTRATION");
		
		btnRegistration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnRegistration.setForeground(Color.WHITE);
				btnRegistration.setFont(new Font("Times New Roman", Font.BOLD, 16));
				btnRegistration.setBorderPainted(false);
				btnRegistration.setBackground(new Color(0, 206, 209));
			}
		});
		btnRegistration.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btnRegistration.setForeground(Color.BLACK);
				btnRegistration.setFont(new Font("Times New Roman", Font.BOLD, 16));
				btnRegistration.setBorderPainted(false);
				btnRegistration.setBackground(new Color(153, 204, 255));
				
				
			}
			
		});
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegistrationPage rp = new RegistrationPage();
				rp.setVisible(true);
			}
		});
	
		btnRegistration.setBounds(60, 490, 170, 40);
		getContentPane().add(btnRegistration);
		
		JCheckBox showpass = new JCheckBox("SHOW");
		showpass.setBackground(Color.BLACK);
		showpass.setForeground(Color.WHITE);
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(showpass.isSelected()) {
					textpass.setEchoChar((char)0);
				}
				else {
					textpass.setEchoChar('*');
				}
				
				
			}
		});
		btnRegistration.setForeground(Color.BLACK);
		btnRegistration.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnRegistration.setBorderPainted(false);
		btnRegistration.setBackground(new Color(153, 204, 255));
		showpass.setBounds(60, 421, 74, 23);
		getContentPane().add(showpass);
		setVisible(true);
		
		
	}
}
