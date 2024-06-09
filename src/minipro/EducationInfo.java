package minipro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.time.Year;

public class EducationInfo extends JFrame {

	private JPanel contentPane;
	private JTextField dipName, cgpaTxt,colname;
	public JLabel educationEmail;
	private JComboBox Dis;
	private JTextField pasingYeartxt;

	public static void main(String[] args) {
		
					EducationInfo frame = new EducationInfo();
					frame.setVisible(true);
	}

	public EducationInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		
		
		JLabel headlbl = new JLabel("EDUCATION INFORMATION");
		headlbl.setHorizontalAlignment(SwingConstants.CENTER);
		headlbl.setForeground(Color.WHITE);
		headlbl.setFont(new Font("Algerian", Font.BOLD, 50));
		headlbl.setBounds(115, 52, 667, 70);
		contentPane.add(headlbl);
		
		
		JLabel lbl1 = new JLabel("Fill College Details Carefully !");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbl1.setBounds(258, 119, 346, 35);
		contentPane.add(lbl1);
		
		
		JLabel lblCollegeName_1 = new JLabel("College Name");
		lblCollegeName_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCollegeName_1.setBounds(20, 10, 98, 25);
		getContentPane().add(lblCollegeName_1);
		
		dipName = new JTextField();
		dipName.setEditable(false);
		dipName.setBackground(Color.LIGHT_GRAY);
		dipName.setBounds(20, 45, 521, 34);
		getContentPane().add(dipName);
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonalInfo pi = new PersonalInfo();
				pi.PersonalEmail.setText(educationEmail.getText());
				pi.setVisible(true);
				dispose();
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
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
		btnBack.setBounds(560, 513, 130, 40);
		contentPane.add(btnBack);
		
	     educationEmail = new JLabel("");
		educationEmail.setHorizontalAlignment(SwingConstants.CENTER);
		educationEmail.setForeground(Color.WHITE);
		educationEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		educationEmail.setBounds(560, 10, 304, 32);
		contentPane.add(educationEmail);
		
		
		
		JLabel universitylbl = new JLabel("University");
		universitylbl.setForeground(Color.WHITE);
		universitylbl.setBounds(533, 183, 191, 25);
		contentPane.add(universitylbl);
		universitylbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		String University[]= {"Select University","SHIVAJI UNIVERSITY","SBPU","DBATU"};
		JComboBox uniname = new JComboBox(University);
		uniname.setBounds(533, 240, 304, 39);
		contentPane.add(uniname);
		uniname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		
		
		cgpaTxt = new JTextField(3);
		cgpaTxt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cgpaTxt.setBounds(60, 370, 87, 40);
		contentPane.add(cgpaTxt);
		
		JLabel cgpalbl = new JLabel("CGPA");
		cgpalbl.setForeground(Color.WHITE);
		cgpalbl.setBounds(60, 331, 69, 20);
		contentPane.add(cgpalbl);
		cgpalbl.setHorizontalAlignment(SwingConstants.CENTER);
		cgpalbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel deptlbl = new JLabel("Department");
		deptlbl.setForeground(Color.WHITE);
		deptlbl.setBounds(210, 329, 122, 25);
		contentPane.add(deptlbl);
		deptlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		String[] dept= {"Select Department","CSE","IOT","ECE","ME","CE","AERO","ENTC"};
		JComboBox deptTxt = new JComboBox(dept);
		deptTxt.setBounds(210, 371, 162, 39);
		contentPane.add(deptTxt);
		deptTxt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		deptTxt.setBackground(Color.LIGHT_GRAY);
		
		JLabel collbl = new JLabel("College Name ");
		collbl.setForeground(Color.WHITE);
		collbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		collbl.setBounds(60, 191, 191, 25);
		contentPane.add(collbl);
		
		colname = new JTextField(3);
		colname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		colname.setBounds(60, 244, 410, 35);
		contentPane.add(colname);
		
		
		
		JLabel distlbl = new JLabel("District");
		distlbl.setForeground(Color.WHITE);
		distlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		distlbl.setBounds(442, 329, 122, 25);
		contentPane.add(distlbl);
		
		String District[] = {"Select District","Ahmednagar","Akola","Amravati","Beed","Bhandara",
				"Buldhana","Chandrapur","Jalgaon","Jalna","Kolhapur","Latur","Mumbai City",
		         "Mumbai Suburban","Nagpur","Nanded","Nandurbar","Nashik","Palghar",
		      "Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur",
		      "Thane","Wardha","Washim","Yavatmal"
		};

		Dis = new JComboBox(District);
		Dis.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Dis.setEditable(false);
		Dis.setBackground(Color.WHITE);
		Dis.setBounds(426, 370, 147, 40);
		contentPane.add(Dis);
		
		
		
		JLabel pasyearlbl = new JLabel("Passing Year");
		pasyearlbl.setForeground(Color.WHITE);
		pasyearlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		pasyearlbl.setBounds(636, 326, 122, 25);
		contentPane.add(pasyearlbl);
		
		pasingYeartxt = new JTextField(4);
		pasingYeartxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int length =pasingYeartxt.getText().length(); 
				char c = e.getKeyChar();
				
				if(c>='0'&&c<='9') {
					if(length<4) {
						pasingYeartxt.setEditable(true);
					}
				else {
					pasingYeartxt.setEditable(false);
				}
				}
				else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						
						pasingYeartxt.setEditable(true);
					}
					else {
						pasingYeartxt.setEditable(false);
					}
				}
				
			}
		});
		pasingYeartxt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		pasingYeartxt.setBounds(636, 370, 122, 40);
		contentPane.add(pasingYeartxt);
		
		
		JButton personalBtn = new JButton("NEXT");
		personalBtn.addMouseListener(new MouseAdapter() {
			
			public void mouseExited(MouseEvent e) {
				personalBtn.setBackground(new Color(153, 255, 153));
				
			}
			public void mouseEntered(MouseEvent e) {
				personalBtn.setBackground(Color.GREEN);
			}
		});
		personalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String College = colname.getText();
			String University = uniname.getSelectedItem().toString();
			String Department = deptTxt.getSelectedItem().toString();
			String District = Dis.getSelectedItem().toString();
			String PassingYear = pasingYeartxt.getText();
			String Cgpa = cgpaTxt.getText();
			String Email = educationEmail.getText();
			int passYear = 0;
			
			 passYear= Integer.parseInt(PassingYear);
			
			if(passYear >2100 || passYear < 2000) {
				JOptionPane.showMessageDialog(null,"Passing Date is not valid");
			}
			else {
			
				if(College.equals("")||University.equals("Select Univercity")||Email.equals("")
						||Cgpa.equals("")||Department.equals("Select Department")
						||District.equals("Select District")||PassingYear.equals("")) {
					
					JOptionPane.showMessageDialog(null,"Fill All Details");
					
				}else {
						
					String Query = "INSERT INTO `education_table`(`Email`, `Collage_Name`, `University`, `cgpa`, `department`, `District`, `Passing_year`) VALUES ('"+Email+"','"+College+"','"+University+"','"+Cgpa+"','"+Department+"','"+District+"','"+PassingYear+"')";
					
					try {
					DataBaseCon db = new DataBaseCon();
					db.DataBase();
					PreparedStatement ps = db.con.prepareStatement(Query);
					boolean rs = ps.execute();
					
					if(!rs) {
						SkillsPage sp = new SkillsPage();
						sp.skillLabel.setText(Email);
						sp.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Values Are Not Filled In DataBase");
					}
					
					
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "DataBase is not Started");
					}
				}
			}}
		});
		personalBtn.setForeground(Color.BLACK);
		personalBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		personalBtn.setBorderPainted(false);
		personalBtn.setBackground(new Color(153, 255, 153));
		personalBtn.setBounds(726, 513, 130, 40);
		contentPane.add(personalBtn);
		
		
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setSize(900,600);
		setLocationRelativeTo(null);
		contentPane.setBackground(Color.BLACK);
	
	}
}
