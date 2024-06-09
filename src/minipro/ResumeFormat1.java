package minipro;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class ResumeFormat1 {
	
 
    private String Phone, Name, DOB, Address, Nation, Gender, Cast, Hobbies, linkedin, Img;
    private String PATH = "C:/Users/YASH KADAV/Downloads/";
    private String CollegeName, University, cgpa, dept, passingYear;
    private String Project1Name, Project2Name, Project1Duration, Project2Duration, 
                   Project1Tech, Project2Tech, Project1Desc, Project2Desc; 
    private String skill1, skill2, skill3, skill4;
    private String lang1, lang2, lang3, lang4;
    private String achieve1, achieve2;

    public void fetchData(String Email) throws Exception {
    	
    	
        String Query1 = "SELECT * FROM personalinformation WHERE Email_id ='"+Email+"'";
        String Query2 = "SELECT * FROM education_table WHERE Email = '"+Email+"'";
        String Query3 = "SELECT * FROM project_page WHERE Email ='"+Email+"'";
        String Query4 = "SELECT * FROM skill_table WHERE Email = '"+Email+"'";

        DataBaseCon db = new DataBaseCon();
        db.DataBase();
             java.sql.Statement stmt = db.con.createStatement();
           
            try (java.sql.ResultSet rs1 = stmt.executeQuery(Query1)) {
                if (rs1.next()) {
                    
                    Name = rs1.getString("Name");
                    DOB = rs1.getString("DOB");
                    Address = rs1.getString("Address");
                    Phone = rs1.getString("Phone");
//                    Nation = rs1.getString("Nation");
                    Gender = rs1.getString("Gender");
//                    Cast = rs1.getString("Cast");
                    Hobbies = rs1.getString("Hobbies");
                    linkedin = rs1.getString("Linkedin");
                    Img = rs1.getString(11);
                }
            }
            try (java.sql.ResultSet rs2 = stmt.executeQuery(Query2)) {
                if (rs2.next()) {
                    CollegeName = rs2.getString(2);
                    University = rs2.getString(3);
                    cgpa = rs2.getString(4);
                    dept = rs2.getString(5);
                    
                    passingYear = rs2.getString(7);
                }
            }
            try (java.sql.ResultSet rs3 = stmt.executeQuery(Query3)) {
                if (rs3.next()) {
                    Project1Name = rs3.getString(2);
                    Project1Duration = rs3.getString(3);
                    Project1Tech = rs3.getString(4);
                    Project1Desc = rs3.getString(5);
                    Project2Name = rs3.getString(6);
                    Project2Duration = rs3.getString(7);
                    Project2Tech = rs3.getString(8);
                    Project2Desc = rs3.getString(9);
                }
            }
            try (java.sql.ResultSet rs4 = stmt.executeQuery(Query4)) {
                if (rs4.next()) {
                    skill1 = rs4.getString(2);
                    skill2 = rs4.getString(3);
                    skill3 = rs4.getString(4);
                    skill4 = rs4.getString(5);
                    lang1 = rs4.getString(6);
                    lang2 = rs4.getString(7);
                    lang3 = rs4.getString(8);
                    lang4 = rs4.getString(9);
                    achieve1 = rs4.getString(10);
                    achieve2 = rs4.getString(11);
                }
            }
        
    }

    public void createPdf(String Email) throws Exception {
        Document doc = new Document();
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(new File(PATH + Name + ".pdf")));
        doc.open();

        
        if (Img != null && !Img.isEmpty()) {
            Path imgPath = Paths.get(Img);
            Image img = Image.getInstance(imgPath.toAbsolutePath().toString());
            img.scaleAbsolute(100f, 100f);
            img.setAlignment(Element.ALIGN_LEFT);
            
            Font nameFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 25, BaseColor.ORANGE);
            Chunk nameChunk = new Chunk(Name, nameFont);
            Paragraph nameParagraph = new Paragraph(nameChunk);
            nameParagraph.add(img);
            nameParagraph.setAlignment(Element.ALIGN_CENTER);
            doc.add(nameParagraph); 
        }

        // Add a horizontal line
        LineSeparator horizontalLine = new LineSeparator();
        horizontalLine.setLineColor(BaseColor.BLACK);
        horizontalLine.setPercentage(100); // Line width relative to page width
        horizontalLine.setOffset(10);
        horizontalLine.setAlignment(Element.ALIGN_CENTER);
        Chunk linebreak = new Chunk(horizontalLine);
        doc.add(linebreak);

        // Add Contact Details Section
        Font ContactFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Paragraph ContactTitle = new Paragraph("Contact                                            Project Details", ContactFont);
        ContactTitle.setSpacingBefore(5f);
        ContactTitle.setSpacingAfter(10f);
        doc.add(ContactTitle);

        Font infoFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        // Add Personal Information
        if(!Project1Name.equals("")&& !Project2Name.equals("")) {
        	doc.add(new Paragraph("Email: " + Email+"        "+" Project Name: - "+Project1Name, infoFont));
            doc.add(new Paragraph("Phone: " + Phone+"                            "+"Project Tech Used: -"+Project1Tech, infoFont));
            doc.add(new Paragraph("Address: "+ Address+"                         "+"Description: -"+Project1Desc    , infoFont));
            doc.add(new Paragraph("                                                                                       "));
            doc.add(new Paragraph("                                                                                       "));
            doc.add(new Paragraph("                                                           Project Name: -           "+Project2Name,infoFont));
            doc.add(new Paragraph("                                                           Project Tech. Used: -     "+Project2Tech,infoFont));
            doc.add(new Paragraph("                                                           Description: -            "+Project2Desc,infoFont));
        }
        else if(!Project1Name.equals("")) {
        	doc.add(new Paragraph("Email: " + Email+"        "+" Project Name: - "+Project1Name, infoFont));
            doc.add(new Paragraph("Phone: " + Phone+"                            "+"Project Tech Used: -"+Project1Tech, infoFont));
            doc.add(new Paragraph("Address: "+ Address+"                         "+"Description: -"+Project1Desc    , infoFont));
            }
        else if(!Project2Name.equals("")) {
        	doc.add(new Paragraph("                                                           Project Name: -           "+Project2Name,infoFont));
            doc.add(new Paragraph("                                                           Project Tech. Used: -     "+Project2Tech,infoFont));
            doc.add(new Paragraph("                                                           Description: -            "+Project2Desc,infoFont));
        
        }
        
        Paragraph SkillTitle = new Paragraph("Skills", ContactFont);
        SkillTitle.setSpacingBefore(10f);
        doc.add(SkillTitle);
        
        if(!skill1.isEmpty()) {
        	doc.add(new Paragraph("* "+skill1));
        }
        if(!skill2.isEmpty()) {
        	doc.add(new Paragraph("* "+skill2));
        }
        if(!skill3.isEmpty()) {
        	doc.add(new Paragraph("* "+skill3));
        }
        if(!skill4.isEmpty()) {
        	doc.add(new Paragraph("* "+skill4));
        }
        
        
        Paragraph education = new Paragraph("Education",ContactFont);
        education.setSpacingBefore(15f);
        doc.add(education);
        
        doc.add(new Paragraph(passingYear));
        doc.add(new Paragraph(CollegeName));
        doc.add(new Paragraph(University));
        doc.add(new Paragraph(dept+"  "+cgpa));
        
        Paragraph Language = new Paragraph("Languages",ContactFont);
        Language.setSpacingBefore(15f);
        doc.add(Language);
        
        if(!lang1.isEmpty()) {
        	doc.add(new Paragraph("* "+lang1));
        }
        
        if(!lang2.isEmpty()) {
        	doc.add(new Paragraph("* "+lang2));
        }
        
        if(!lang3.isEmpty()) {
        	doc.add(new Paragraph("* "+lang3));
        }
        
        if(!lang4.isEmpty()) {
        	doc.add(new Paragraph("* "+lang4));
        }

        
        Paragraph achievement = new Paragraph("Achievements",ContactFont);
        achievement.setSpacingBefore(15f);
        doc.add(achievement);
        
        if(!achieve1.isEmpty()) 
        doc.add(new Paragraph(achieve1));
    
        if(!achieve2.isEmpty())
        	doc.add(new Paragraph(achieve2));
        
        
        Paragraph hobbies = new Paragraph("Hobbies",ContactFont);
        hobbies.setSpacingBefore(15f);
        doc.add(hobbies);
        
        doc.add(new Paragraph(Hobbies));
        
        // Add a vertical line
        PdfContentByte canvas = writer.getDirectContent();
        float lineX = 225;
        canvas.setLineWidth(1f);
        canvas.moveTo(lineX, doc.bottom(25f));
        canvas.lineTo(lineX, doc.top(183f));
        canvas.stroke();

        doc.addAuthor("YASH KADAV");
        doc.close();
        
        try {
        	File files = new File(PATH + Name + ".pdf");
        	if(files.exists()) {
        		if(Desktop.isDesktopSupported()){
        			Desktop.getDesktop().open(files);
        		}
        		else {
        			JOptionPane.showMessageDialog(null,"File Not Found");
        		}
        	}
        }catch(Exception exc) {
        	JOptionPane.showMessageDialog(null,"File Not Found");
        }

        System.out.println("Resume PDF created successfully at " + PATH + Name + ".pdf");
    }
}
