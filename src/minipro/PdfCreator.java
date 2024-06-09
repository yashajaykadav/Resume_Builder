package minipro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PdfCreator extends JFrame {
	public JLabel finalMail;

    private JPanel contentPane;
       public static void main(String[] args) {
        try {
            PdfCreator frame = new PdfCreator();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PdfCreator() throws Exception {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.black);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("SELECT RESUME");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new java.awt.Font("Algerian", java.awt.Font.BOLD, 40));
        lblNewLabel.setBounds(215, 30, 446, 66);
        contentPane.add(lblNewLabel);
        
        JButton resume1 = new JButton();
        resume1.setText("FORMAT 1");
        resume1.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		String Email =finalMail.getText();
        		System.out.println(Email);
        		
        		try {
					ResumeFormat1 pc = new ResumeFormat1();
					
					pc.fetchData(Email);
					pc.createPdf(Email);
					
//					JOptionPane.showMessageDialog(null, "Resume Is Created!");
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
        		 
        	}
        });	
        resume1.setBounds(51, 155, 304, 353);
        contentPane.add(resume1);
        
        JButton resume2 = new JButton();
        resume2.setText("FORMAT 2");
        resume2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String Email =finalMail.getText();
        		System.out.println(Email);
        		try {
        		ResumeFormat2 rf2 = new ResumeFormat2 ();
        		rf2.fetchData(Email);
        		rf2.createPdf(Email);
        		JOptionPane.showMessageDialog(null,"Resume Created");
        		}
        		catch(Exception ex) {
        			ex.printStackTrace();
        		}
        		
        	}
        });
        resume2.setBounds(532, 155, 304, 353);
        contentPane.add(resume2);
        
        finalMail = new JLabel();
        finalMail.setHorizontalAlignment(SwingConstants.CENTER);
        finalMail.setForeground(Color.WHITE);
        finalMail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        finalMail.setBounds(572, 10, 304, 32);
        contentPane.add(finalMail);
    }}