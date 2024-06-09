package minipro;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainPage extends JFrame {

	private JPanel contentPane;
	public JLabel LblMail;

	public static void main(String[] args) {
		
					MainPage frame = new MainPage();
					frame.setVisible(true);
				
	}

	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel PageName = new JLabel("RESUME BUILDER ");
		PageName.setHorizontalAlignment(SwingConstants.CENTER);
		PageName.setFont(new Font("Algerian", Font.BOLD, 60));
		PageName.setBounds(91, 41, 620, 50);
		PageName.setForeground(Color.WHITE);
		getContentPane().add(PageName);
		
		JLabel word = new JLabel("MAKE YOUR RESUME STYLISH AND PROFESSIONAL ");
		word.setForeground(Color.WHITE);
		word.setHorizontalAlignment(SwingConstants.CENTER);
		word.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		word.setBounds(199, 117, 386, 20);
		getContentPane().add(word);
		
	
		JLabel resumelogo = new JLabel();
		resumelogo.setIcon(new ImageIcon(new ImageIcon("img/logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
		
		resumelogo.setBounds(21, 29, 100, 100);
		getContentPane().add(resumelogo);
		
		JButton createbtn = new JButton();
		createbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				PersonalInfo pi = new PersonalInfo();
				pi.PersonalEmail.setText(LblMail.getText());
				pi.setVisible(true);
			}
		});
		createbtn.setBounds(321, 184, 100, 100);
		createbtn.setIcon(new ImageIcon(new ImageIcon("img/create.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));

		getContentPane().add(createbtn);
		
		JLabel lblNewLabel = new JLabel("CREATE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(321, 304, 100, 20);
		getContentPane().add(lblNewLabel);
		
	    LblMail = new JLabel();
	    LblMail.setHorizontalAlignment(SwingConstants.CENTER);
	    LblMail.setForeground(Color.white);
	    LblMail.setFont(new Font("Monospaced", Font.PLAIN, 12));
		LblMail.setBounds(501, 0, 253, 23);
		getContentPane().add(LblMail);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setBorderPainted(false);
		btnLogOut.setForeground(Color.white);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnLogOut.setBounds(638, 355, 106, 30);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.setVisible(true);
				dispose();
			}
			
		});
		getContentPane().add(btnLogOut);
		
		setSize(size.width/2,size.height/2);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
