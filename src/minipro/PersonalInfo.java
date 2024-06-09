package minipro;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class PersonalInfo extends JFrame {

	private JPanel contentPane;
	private String path;
	private JFileChooser fc;
	private JTextField FNText, phoneTxt ,linkedtxt;
	public JLabel PersonalEmail;

	
	public static void main(String[] args) {
		
					PersonalInfo frame = new PersonalInfo();
					frame.setVisible(true);
				
	}

	
	public PersonalInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(45, 134, 180, 150);
		contentPane.add(lblNewLabel);
		JButton imgSelect = new JButton("SELECT IMAGE");
		imgSelect.setBorderPainted(false);
		imgSelect.setForeground(Color.WHITE);
		imgSelect.setBackground(Color.GRAY);
		imgSelect.setFont(new Font("Times New Roman", Font.BOLD, 16));
		imgSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 fc = new JFileChooser();
				int res = fc.showOpenDialog(null);
				
				if(res==JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					 path = file.toString();
					BufferedImage bi;
					try {
					bi = ImageIO.read(file);
					lblNewLabel.setIcon(new ImageIcon(new ImageIcon(bi).getImage().getScaledInstance(180, 150,Image.SCALE_REPLICATE)));
					}
					catch(Exception e2) {
						e2.printStackTrace();
					}
					System.out.println(path);
					System.out.println(file);
					
					
				}
			}
		});
		imgSelect.setBounds(45, 333, 185, 28);
		contentPane.add(imgSelect);
		
		JLabel headingText = new JLabel("PERSONAL INFORMATION");
		headingText.setHorizontalAlignment(SwingConstants.CENTER);
		headingText.setForeground(Color.WHITE);
		headingText.setFont(new Font("Algerian", Font.BOLD, 50));
		headingText.setBounds(467, 25, 610, 70);
		contentPane.add(headingText);
		
		JLabel lbldate = new JLabel("Date Will Appear Here");
		lbldate.setHorizontalAlignment(SwingConstants.CENTER);
		lbldate.setForeground(new Color(255, 255, 255));
		lbldate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbldate.setBounds(1193, 314, 206, 28);
		contentPane.add(lbldate);
	
		
		JLabel lblNewLabel_1 = new JLabel("Enter Full Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(340, 188, 143, 28);
		contentPane.add(lblNewLabel_1);
		
		FNText = new JTextField();
		FNText.setHorizontalAlignment(SwingConstants.CENTER);
		FNText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e5) {
				
                  char c = e5.getKeyChar();
				
				if(c>='0'||c<='9'){
					
					FNText.setEditable(true);
				}
				else {
					
					
					FNText.setEditable(false);
						
				}
			}
		});
		FNText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
   FNText.setEditable(true);
		FNText.setBounds(507, 187, 547, 31);
		contentPane.add(FNText);
		FNText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DOB");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(1102, 184, 81, 37);
		contentPane.add(lblNewLabel_2);
		
		JCalendar calendar = new JCalendar();
		calendar.setDecorationBackgroundColor(new Color(153, 204, 204));
		calendar.setBounds(1193, 134, 206, 152);
	calendar.getDate();
		contentPane.add(calendar);
		
		JButton DateBtn = new JButton("SET");
		DateBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		DateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date day = calendar.getDate();
				System.out.println(day);
				String date = String.format("%1$td/%1$tm/%1$ty",day);
				lbldate.setText(date);
			}
		});
		DateBtn.setBounds(1421, 194, 65, 21);
		contentPane.add(DateBtn);
		
		JLabel genderlbl = new JLabel("Gender");
		genderlbl.setHorizontalAlignment(SwingConstants.CENTER);
		genderlbl.setForeground(Color.WHITE);
		genderlbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		genderlbl.setBounds(368, 516, 100, 28);
		contentPane.add(genderlbl);
		
		JLabel phonelbl = new JLabel("Phone");
		phonelbl.setHorizontalAlignment(SwingConstants.CENTER);
		phonelbl.setForeground(Color.WHITE);
		phonelbl.setFont(new Font("Times New Roman", Font.BOLD, 20));
		phonelbl.setBounds(368, 436, 117, 28);
		contentPane.add(phonelbl);
		
		
		
		JRadioButton RBM = new JRadioButton("MALE");
		RBM.setForeground(Color.WHITE);
		RBM.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		RBM.setBackground(new Color(0, 0, 0));
		RBM.setHorizontalAlignment(SwingConstants.CENTER);
		RBM.setBounds(476, 520, 65, 25);
		contentPane.add(RBM);
		
		JRadioButton RBF = new JRadioButton("FEMALE");
		RBF.setBackground(Color.BLACK);
		RBF.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		RBF.setForeground(Color.WHITE);
		RBF.setHorizontalAlignment(SwingConstants.CENTER);
		RBF.setBounds(577, 520, 90, 25);
		contentPane.add(RBF);
		
		ButtonGroup rbg = new ButtonGroup();
		rbg.add(RBF);
		rbg.add(RBM);
		
		phoneTxt = new JTextField();
		phoneTxt.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				String phone = phoneTxt.getText();
				int len = phone.length();
				char c = e.getKeyChar();
				
				if(c>='0'&&c<='9') {
					if(len<10) {
						phoneTxt.setEditable(true);
					}
					else {
						phoneTxt.setEditable(false);
					}
					
				}else {
					
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						phoneTxt.setEditable(true);		
						
					}
					else {
						phoneTxt.setEditable(false);
					}
					
				}
				
			}
		});
		phoneTxt.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(509, 435, 344, 31);
		contentPane.add(phoneTxt);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdress.setForeground(Color.WHITE);
		lbladdress.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lbladdress.setBounds(340, 279, 143, 28);
		contentPane.add(lbladdress);
		
		JTextArea addresstxt = new JTextArea(20,20);
		addresstxt.setLineWrap(true);
		addresstxt.setWrapStyleWord(true);
		addresstxt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		addresstxt.setBounds(507, 267, 547, 124);
		contentPane.add(addresstxt);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setHorizontalAlignment(SwingConstants.CENTER);
		lblNationality.setForeground(Color.WHITE);
		lblNationality.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNationality.setBounds(983, 436, 117, 28);
		contentPane.add(lblNationality);
		
		String[] nations = {
				"Select Nationality",
	            "Chinese",
	            "Indian",
	            "American",
	            "Indonesian",
	            "Pakistani",
	            "Brazilian",
	            "Nigerian",
	            "Bangladeshi",
	            "Russian",
	            "Mexican",
	            "Japanese",
	            "Ethiopian",
	            "Filipino",
	            "Egyptian",
	            "Vietnamese",
	            "Turkish",
	            "Iranian",
	            "German",
	            "Thai",
	            "French"
	        };
		JComboBox nation = new JComboBox(nations);
		nation.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		nation.setBounds(1133, 437, 266, 28);
		contentPane.add(nation);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCategory.setBounds(983, 516, 100, 28);
		contentPane.add(lblCategory);
		
	
		
		JLabel lblHoobies = new JLabel("Hobbies");
		lblHoobies.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoobies.setForeground(Color.WHITE);
		lblHoobies.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHoobies.setBounds(368, 594, 117, 28);
		contentPane.add(lblHoobies);
		
		JTextArea hobbieTxt = new JTextArea(20, 20);
		hobbieTxt.setWrapStyleWord(true);
		hobbieTxt.setLineWrap(true);
		hobbieTxt.setFont(new Font("Monospaced", Font.PLAIN, 14));
		hobbieTxt.setBounds(507, 573, 356, 94);
		contentPane.add(hobbieTxt);
		
		JLabel lblLinkedin = new JLabel("LinkedIn");
		lblLinkedin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLinkedin.setForeground(Color.WHITE);
		lblLinkedin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblLinkedin.setBounds(983, 594, 100, 28);
		contentPane.add(lblLinkedin);
		
		linkedtxt = new JTextField();
		linkedtxt.setHorizontalAlignment(SwingConstants.CENTER);
		linkedtxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		linkedtxt.setColumns(10);
		linkedtxt.setBounds(1133, 594, 266, 31);
		contentPane.add(linkedtxt);
		
		String Caste[] = {"Select Caste","ST","SC","OBC", "NTD","OPEN","SBC"};
		
		JComboBox Combocast = new JComboBox(Caste);
		Combocast.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Combocast.setBounds(1133, 517, 266, 28);
		contentPane.add(Combocast);
		
		JButton personalBtn = new JButton("NEXT");
		personalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Email = PersonalEmail.getText();
				String firstName = FNText.getText();
				String date = lbldate.getText();
				String address = addresstxt.getText();
				String phone = phoneTxt.getText();
				String national = nation.getSelectedItem().toString();
				String castes = Combocast.getSelectedItem().toString();
				String Gender="";
				if(RBM.isSelected()) {
					Gender = "Male";
				}
				else if(RBF.isSelected()){
					Gender = "Female";
				}
				String Hobbie = hobbieTxt.getText();
				String Linked = linkedtxt.getText();
				
				
				 
				if(firstName.equals("")||date.equals("")||address.equals("")||phone.equals("")
				  ||national.equals("Select Nationality")||castes.equals("Select Caste")||Gender.equals("")
				   ||Hobbie.equals("") || path.equals("")) {
					JOptionPane.showMessageDialog(null," Please Fill The details!!");
				}
				else {
					String query = "Insert into personalinformation Values(?,?,?,?,?,?,?,?,?,?,?)";
					try {
						DataBaseCon db = new DataBaseCon();
						db.DataBase();
						System.out.println("Connected!");
					
						java.sql.PreparedStatement ps = db.con.prepareStatement(query);
						ps.setString(1,Email);
						ps.setString(2,firstName);
						ps.setString(3,date);
						ps.setString(4,address);
						ps.setString(5,phone);
						ps.setString(6,national);
						ps.setString(7,Gender);
						ps.setString(8,castes);
						ps.setString(9,Hobbie);
						ps.setString(10,Linked);
						ps.setString(11,path);
                        
                        boolean rs = ps.execute();
                        if(!rs) {
                        	EducationInfo ei = new EducationInfo();
                        	ei.educationEmail.setText(PersonalEmail.getText());
                        	ei.setVisible(true);
                        	dispose();
                        }
                        else {
                        	JOptionPane.showMessageDialog(null, "Error Occurd");
                        }
					
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Record Already existed");
					
				}}
			
			}
		});
		
		
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
				MainPage mp = new MainPage();
				mp.LblMail.setText(PersonalEmail.getText());
				mp.setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(255, 153, 102));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnBack.setBounds(1133, 727, 130, 40);
		contentPane.add(btnBack);
		
		personalBtn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				personalBtn.setBackground(Color.GREEN);
				
			}
            public void mouseExited(MouseEvent e) {
            	personalBtn.setBackground(new Color(153, 204, 153));	
			}
			
		});
		personalBtn.setForeground(new Color(0, 0, 0));
		personalBtn.setBorderPainted(false);
		personalBtn.setBackground(new Color(153, 204, 153));
		personalBtn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		personalBtn.setBounds(1329, 727, 130, 40);
		contentPane.add(personalBtn);
		
	    PersonalEmail = new JLabel("");
		PersonalEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		PersonalEmail.setHorizontalAlignment(SwingConstants.CENTER);
		PersonalEmail.setForeground(Color.WHITE);
		PersonalEmail.setBounds(1209, 10, 304, 32);
		contentPane.add(PersonalEmail);
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
	}
}
