package minipro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SkillsPage extends JFrame {

	public JLabel skillLabel;
	private JPanel contentPane;
	private JTextField skill1txt,skill3txt,skill4txt,skill2txt;
	private JLabel language,lblAchivevements;
	private JPanel panel_1, panel_2;
	private JTextField lan1txt,lan2txt,lan3txt,lan4txt,achivetxt1,achivetxt2;
	private JButton subBtn, btnBack;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SkillsPage frame = new SkillsPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SkillsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel skillinfo = new JLabel("SKILLS INFORMATION");
		skillinfo.setHorizontalAlignment(SwingConstants.CENTER);
		skillinfo.setForeground(Color.WHITE);
		skillinfo.setFont(new Font("Algerian", Font.BOLD, 50));
		skillinfo.setBounds(399, 22, 667, 70);
		contentPane.add(skillinfo);
		
		JLabel techSkill = new JLabel("Tech. Skills");
		techSkill.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		techSkill.setForeground(Color.WHITE);
		techSkill.setBounds(87, 108, 129, 40);
		contentPane.add(techSkill);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(195, 152, 1166, 120);
		contentPane.add(panel);
		
		skill1txt = new JTextField();
		skill1txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		panel.setLayout(new GridLayout(2,3,30, 30));
		panel.add(skill1txt);
		
		skill2txt = new JTextField();
		skill2txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		panel.add(skill2txt);
		
		skill3txt = new JTextField();
		skill3txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	
		panel.add(skill3txt);
		
		skill4txt = new JTextField();
		skill4txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		skill1txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		panel.add(skill4txt);
		
		language = new JLabel("Languages");
		language.setForeground(Color.WHITE);
		language.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		language.setBounds(87, 325, 129, 49);
		contentPane.add(language);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(195, 373, 1166, 120);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 3, 30, 30));
		
		lan1txt = new JTextField();
		lan1txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(lan1txt);
		
		lan2txt = new JTextField();
		lan2txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(lan2txt);
		
		lan3txt = new JTextField();
		lan3txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(lan3txt);
		
		lan4txt = new JTextField();
		lan4txt.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(lan4txt);
		
		lblAchivevements = new JLabel("Achivevements");
		lblAchivevements.setForeground(Color.WHITE);
		lblAchivevements.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAchivevements.setBounds(87, 560, 129, 49);
		contentPane.add(lblAchivevements);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(195, 609, 1166, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1,2, 30, 30));
		
		achivetxt1 = new JTextField();
		achivetxt1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(achivetxt1);
		
		
		achivetxt2 = new JTextField();
		achivetxt2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(achivetxt2);
		
		subBtn = new JButton("NEXT");
		subBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(skill1txt.getText().equals("")&&skill2txt.getText().equals("")
				 &&skill3txt.getText().equals("")&&skill4txt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Fill Atleast One Skill");
				}else if(lan1txt.getText().equals("")&&lan2txt.getText().equals("")
						&&lan3txt.getText().equals("")&&lan4txt.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Fill Atleast One Language");
				}
				else if(achivetxt1.getText().equals("")&&achivetxt2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Fill Atleast One Achievement");
				}

				else {
			
				try {
					String Query = "INSERT INTO skill_table(`Email`, `Skill1`, `Skill2`, `Skill3`, `Skill4`, `Lan1`, `Lan2`, `Lan3`, `Lan4`, `Achieve1`, `Achieve2`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
							
					DataBaseCon db = new DataBaseCon();
					db.DataBase();
					
					java.sql.PreparedStatement ps = db.con.prepareStatement(Query);
					
					ps.setString(1,skillLabel.getText());
					ps.setString(2,skill1txt.getText());
					ps.setString(3,skill2txt.getText());
					ps.setString(4,skill3txt.getText());
					ps.setString(5,skill4txt.getText());
					ps.setString(6,lan1txt.getText());
					ps.setString(7,lan2txt.getText());
					ps.setString(8,lan3txt.getText());
					ps.setString(9,lan4txt.getText());
					ps.setString(10,achivetxt1.getText());
					ps.setString(11,achivetxt2.getText());
				
					boolean rs = ps.execute();
			
					if(!rs) {
					ProjectsPage pp = new ProjectsPage();
					pp.ProjectEmail.setText(skillLabel.getText());
					pp.setVisible(true);
					dispose();
					
					}
					else {
						JOptionPane.showMessageDialog(null,"Error is occured!");
					}
				}catch(Exception e4) {
					JOptionPane.showMessageDialog(null,e4.fillInStackTrace());
				}
			
			}}
		});
		subBtn.setBorderPainted(false);
		subBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				subBtn.setBackground(Color.GREEN);
			}
			public void mouseExited(MouseEvent e) {
				subBtn.setBackground(new Color(153, 255, 153));
			}
		});
		subBtn.setForeground(Color.BLACK);
		subBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		subBtn.setBounds(1231, 716, 130, 40);
		subBtn.setBackground(new Color(153, 255, 153));
		contentPane.add(subBtn);
		
		btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(210, 105, 30));
				btnBack.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				btnBack.setForeground(Color.BLACK);
				btnBack.setBackground(new Color(204, 153, 102));	
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EducationInfo ei = new EducationInfo();
				dispose();
				ei.educationEmail.setText(skillLabel.getText());
				ei.setVisible(true);
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(204, 153, 102));
		btnBack.setBounds(1050, 716, 130, 40);
		contentPane.add(btnBack);
		
		 skillLabel = new JLabel("yashkadav52@gmail.com");
		skillLabel.setHorizontalAlignment(SwingConstants.CENTER);
		skillLabel.setForeground(Color.WHITE);
		skillLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		skillLabel.setBounds(1208, 10, 304, 32);
		contentPane.add(skillLabel);
	}
}
