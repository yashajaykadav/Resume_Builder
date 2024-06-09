package minipro;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ProjectsPage extends JFrame {

	private JPanel contentPane;
	public JLabel ProjectEmail;
	private JTextField ProName2, Pro2Dur, ProTech2,ProTech1,ProName1,Pro1Dur;
private JTextArea Pro1Des,Pro2Des;
private String pro1name, pro2name , pro1dur , pro2dur , pro1tech , pro2tech ,pro1des,pro2des,Email;
	public static void main(String[] args) {
		
					ProjectsPage frame = new ProjectsPage();
					frame.setVisible(true);
				
	}
	public ProjectsPage() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		
		JLabel lblProjectsInformation = new JLabel("PROJECTS INFORMATION");
		lblProjectsInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectsInformation.setForeground(Color.WHITE);
		lblProjectsInformation.setFont(new Font("Algerian", Font.BOLD, 50));
		lblProjectsInformation.setBounds(437, 29, 667, 70);
		contentPane.add(lblProjectsInformation);
		
		JLabel lblNewLabel = new JLabel("Enter Project Name  :- ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(73, 419, 158, 36);
		contentPane.add(lblNewLabel);
		
		ProName2 = new JTextField();
		ProName2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ProName2.setBounds(227, 417, 763, 40);
		contentPane.add(ProName2);
		ProName2.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration :-");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuration.setBounds(1053, 424, 93, 26);
		contentPane.add(lblDuration);
		
		Pro2Dur = new JTextField();
		Pro2Dur.setColumns(10);
		Pro2Dur.setBounds(1188, 420, 165, 40);
		contentPane.add(Pro2Dur);
		
		JLabel lblTechnologyUsed = new JLabel("Technology Used  :- ");
		lblTechnologyUsed.setForeground(Color.WHITE);
		lblTechnologyUsed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTechnologyUsed.setBounds(73, 493, 158, 33);
		contentPane.add(lblTechnologyUsed);
		
		ProTech2 = new JTextField();
		ProTech2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ProTech2.setColumns(10);
		ProTech2.setBounds(227, 489, 534, 40);
		contentPane.add(ProTech2);
		
		 Pro2Des = new JTextArea();
		Pro2Des.setBounds(1004, 504, 466, 125);
		Pro2Des.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(Pro2Des);
		
		JLabel proDescription = new JLabel("Short Description on Project :-");
		proDescription.setForeground(Color.WHITE);
		proDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		proDescription.setBounds(794, 486, 200, 46);
		contentPane.add(proDescription);
		
		JButton SubBtn = new JButton("NEXT");
		SubBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pro1name =ProName1.getText();
				pro2name =ProName2.getText();
				pro1dur = Pro1Dur.getText();
				pro2dur = Pro2Dur.getText();
				pro1tech = ProTech1.getText();
				pro2tech = ProTech2.getText();
				pro1des  = Pro1Des.getText();
				pro2des  = Pro2Des.getText();
				Email =ProjectEmail.getText();
				
				
				if((pro1name.equals("")|| pro1tech.equals("")||pro1dur.equals("")||pro1des.equals(""))&&
				   (pro2name.equals("")|| pro2tech.equals("")||pro2dur.equals("")||pro2des.equals(""))) {
					
					JOptionPane.showMessageDialog(null, "AtLeast One Project Required With All Details");
				}
				else {
					boolean rs =false;
				DataBaseCon db = new DataBaseCon();
				
				String query = "INSERT INTO `project_page`(`Email`, `Project1_Name`, `Project1_Duration`, `Project1_Tech`, `Project1_Description`, `Project2_Name`, `Project2_Duration`, `Project2_Tech`, `Project2_Description`) VALUES ('"+Email+"','"+pro1name+"','"+pro1dur+"','"+pro1tech+"','"+pro1des+"','"+pro2name+"','"+pro2dur+"','"+pro2tech+"','"+pro1des+"')";
				try {
					db.DataBase();
					java.sql.PreparedStatement ps = db.con.prepareStatement(query);
				     rs = ps.execute();
} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "DataBase Is Not Connected");
				}
				    if(rs) {
				    	JOptionPane.showMessageDialog(null,"Error Occured");
				    }else {
				    	try {
				    	PdfCreator pdf = new PdfCreator();
				    	pdf.finalMail.setText(ProjectEmail.getText());
				    	pdf.setVisible(true);
				    	dispose();}
				    	catch(Exception e5) {
				    		
				    	}
				    }
				
			}
				}
		});
		SubBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				
				
				SubBtn.setBackground(Color.GREEN);
				
			}
			public void mouseExited(MouseEvent e) {
				
		
				SubBtn.setBackground(new Color(153, 204, 153));
			}
		});
		SubBtn.setBorderPainted(false);
		SubBtn.setForeground(new Color(0, 0, 0));
		SubBtn.setBackground(new Color(153, 204, 153));
		SubBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		SubBtn.setBounds(1231, 716, 130, 40);
		
		contentPane.add(SubBtn);
		
		JLabel lblinWeeks = new JLabel("(In Weeks)");
		lblinWeeks.setForeground(Color.WHITE);
		lblinWeeks.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblinWeeks.setBounds(1363, 149, 93, 26);
		contentPane.add(lblinWeeks);
		
		contentPane.setLayout(null);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height);
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Project Name  :- ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(73, 144, 158, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTechnologyUsed_1 = new JLabel("Technology Used  :- ");
		lblTechnologyUsed_1.setForeground(Color.WHITE);
		lblTechnologyUsed_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTechnologyUsed_1.setBounds(73, 218, 158, 33);
		contentPane.add(lblTechnologyUsed_1);
		
		ProTech1 = new JTextField();
		ProTech1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ProTech1.setColumns(10);
		ProTech1.setBounds(227, 214, 534, 40);
		contentPane.add(ProTech1);
		
		ProName1 = new JTextField();
		ProName1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		ProName1.setColumns(10);
		ProName1.setBounds(227, 142, 763, 40);
		contentPane.add(ProName1);
		
		JLabel proDescription_1 = new JLabel("Short Description on Project :-");
		proDescription_1.setForeground(Color.WHITE);
		proDescription_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		proDescription_1.setBounds(794, 211, 200, 46);
		contentPane.add(proDescription_1);
		
		JLabel lblDuration_1 = new JLabel("Duration :-");
		lblDuration_1.setForeground(Color.WHITE);
		lblDuration_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuration_1.setBounds(1053, 149, 93, 26);
		contentPane.add(lblDuration_1);
		
		Pro1Dur = new JTextField();
		Pro1Dur.setColumns(10);
		Pro1Dur.setBounds(1188, 145, 165, 40);
		contentPane.add(Pro1Dur);
		
	    Pro1Des = new JTextArea();
		Pro1Des.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		Pro1Des.setBounds(1004, 229, 466, 125);
		contentPane.add(Pro1Des);
		
		JLabel lblinWeeks_1 = new JLabel("(In Weeks)");
		lblinWeeks_1.setForeground(Color.WHITE);
		lblinWeeks_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblinWeeks_1.setBounds(1363, 424, 93, 26);
		contentPane.add(lblinWeeks_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SkillsPage sp = new SkillsPage();
				sp.skillLabel.setText(ProjectEmail.getText());
				sp.setVisible(true);
				dispose();
			}
		});
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
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(255, 153, 102));
		btnBack.setBounds(1004, 716, 130, 40);
		contentPane.add(btnBack);
		
		 ProjectEmail = new JLabel("yashkadav52@gmail.com");
		ProjectEmail.setHorizontalAlignment(SwingConstants.CENTER);
		ProjectEmail.setForeground(Color.WHITE);
		ProjectEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ProjectEmail.setBounds(1208, 10, 304, 32);
		contentPane.add(ProjectEmail);
		
	}
}
