package RRc.AROGYAHOPITAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class AROGYA_HOPITAL {
	public void insertData() {
		Connection con;
        try {
      
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
            Scanner sc = new Scanner(System.in);
           System.out.println("Enter patient Id");
            int id = sc.nextInt();
            System.out.println("Enter age of the patient");
            int age = sc.nextInt();
            System.out.println("Enter patient name");
            String name = sc.next();
            System.out.println("Enter patient gender");
            String gender=sc.next();
            System.out.println("Enter patient city");
            String city=sc.next();
            System.out.println("Enter patient address");
            String address=sc.next();
            System.out.println("Enter guardian name");
            String guardianName=sc.next();
            System.out.println("Enter guardian Address");
            String guardianaddress=sc.next();
            System.out.println("Enter dateofadmission in the format 'YYYY-MM-DD' " );
            String dateofadmission=sc.next();
            System.out.println("Enter aadharcard number");
            String aadharcard=sc.next();
            System.out.println("Enter patient contact number");
            String pcontact = sc.next();
            System.out.println("Enter guardian contact number");
            String gcontact = sc.next();
            System.out.println("Enter Recovery Date in the format 'YYYY-MM-DD' " );
            String recoveryDate=sc.next();
 

            Statement stmt = (Statement) con.createStatement();
 

            String s = "INSERT INTO PATIENT_TABLE VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(s);
            pstmt.setInt(1,id);
            pstmt.setInt(2, age);
            pstmt.setString(3, name);
            pstmt.setString(4, gender);
            pstmt.setString(5,city);
            pstmt.setString(6, address);
            pstmt.setString(7, guardianName);
            pstmt.setString(8, guardianaddress);
            pstmt.setString(9, dateofadmission);
            pstmt.setString(10, aadharcard);
            pstmt.setString(11, pcontact);
            pstmt.setString(12,gcontact);
            pstmt.setString(13, recoveryDate);
            
            
            pstmt.executeUpdate();
            System.out.println("Data inserted sucessfully");
            con.close();
        } catch (Exception e) {
            System.out.println("Failed in inserting Data");
        }
		
	}
	
	
	
	
	
    public void patientDetails() {
    	Connection con;
    	try {
    	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
    	 Statement stmt = (Statement) con.createStatement();
         ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM PATIENT_TABLE");

         while(rs.next()){
           
             System.out.println(rs.getInt(1 )+" "+rs.getInt(2) +" "+rs.getString(3)
                     +" "+rs.getString(4) +" "+rs.getString(5)+" "+rs.getString(6)
                     +" "+rs.getString(7) +" "+rs.getString(8) +" "+rs.getString(9)
                     +" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)
                     +" "+rs.getString(13));
         }
     
         rs.close();
    con.close();
    	 
    	
    	}catch(Exception e) {
    		System.out.println("Failed in Displaying patient details");
    	}
	}
    
    
    
    
    public void searchById() {
    	Connection con;
    	try {
    	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
    	 
        System.out.println("Enter id to search patient details");
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PATIENT_TABLE WHERE ID= ?");
        pstmt.setInt(1,s);
          ResultSet rs = pstmt.executeQuery();
       
          while (rs.next()){
              
              System.out.println(rs.getInt(1 )+" "+rs.getInt(2) +" "+rs.getString(3)
                      +" "+rs.getString(4) +" "+rs.getString(5)+" "+rs.getString(6)
                      +" "+rs.getString(7) +" "+rs.getString(8) +" "+rs.getString(9)
                      +" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)
                      +" "+rs.getString(13));
          }
          rs.close();
          con.close();
      }	 
    	
    	catch(Exception e) {
    		System.out.println("Failed searching patient details using with patient ID");
    	}
	}
    
    
    
    
    
    
    public void searchByCity() {
    	Connection con;
    	try {
    	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
    	 Statement stmt = (Statement) con.createStatement();
    	 System.out.println("Enter city name to find patient details");
         Scanner sc=new Scanner(System.in);
         String m=sc.next();
         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PATIENT_TABLE WHERE city = ? ");
         pstmt.setString(1,m);
           ResultSet rs = pstmt.executeQuery();
        
           while (rs.next()){
               
               System.out.println(rs.getInt(1 )+" "+rs.getInt(2) +" "+rs.getString(3)
                       +" "+rs.getString(4) +" "+rs.getString(5)+" "+rs.getString(6)
                       +" "+rs.getString(7) +" "+rs.getString(8) +" "+rs.getString(9)
                       +" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)
                       +" "+rs.getString(13));
           }
           rs.close();
           con.close();
    	}catch(Exception e) {
    		System.out.println("Failed searching patient details using with patient city name");
    	}
	}
    
    
    
    
    public void searchByAge() {
    	Connection con;
    	try {
    	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
    	 Statement stmt = (Statement) con.createStatement();
    	 System.out.println("Enter age to search patient details");
         Scanner sc=new Scanner(System.in);
         int p=sc.nextInt();
         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PATIENT_TABLE WHERE AGE = ?");
         pstmt.setInt(1,p);
           ResultSet rs = pstmt.executeQuery();
        
           while (rs.next()){
               
               System.out.println(rs.getInt(1 )+" "+rs.getInt(2) +" "+rs.getString(3)
                       +" "+rs.getString(4) +" "+rs.getString(5)+" "+rs.getString(6)
                       +" "+rs.getString(7) +" "+rs.getString(8) +" "+rs.getString(9)
                       +" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)
                       +" "+rs.getString(13));
           }
           rs.close();
           con.close();
    	 
    	
    	}catch(Exception e) {
    		System.out.println("Failed Searching patient details using whith patient Age");
    	}
	}
    
    
    
    
    
    public void searchByRecoveyDate() {
    	Connection con;
    	try {
    	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
    	 Statement stmt = (Statement) con.createStatement();
    	 System.out.println("Enter recoveryDate to find patient details in the format of YYYY-MM-DD ");
         Scanner sc=new Scanner(System.in);
         String r=sc.next();
         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PATIENT_TABLE WHERE recoveryDate = ?");
         pstmt.setString(1,r);
           ResultSet rs = pstmt.executeQuery();
        
           while (rs.next()){
               
               System.out.println(rs.getInt(1 )+" "+rs.getInt(2) +" "+rs.getString(3)
                       +" "+rs.getString(4) +" "+rs.getString(5)+" "+rs.getString(6)
                       +" "+rs.getString(7) +" "+rs.getString(8) +" "+rs.getString(9)
                       +" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)
                       +" "+rs.getString(13));
           }
           rs.close();
           con.close();
    	 
    	
    	}catch(Exception e) {
    		System.out.println("Failed Searching patient details using with recovery date");
    	}
	}
    
    
    
    
    
    public void deleteById() {
    	Connection con;
    	try {
    	
    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AROGYA_HOSPITAL", "root", "sespl!@3");
    	 Statement stmt = (Statement) con.createStatement();
    	 System.out.println("Enter id to delete the patient details");
         Scanner sc=new Scanner(System.in);
         int r=sc.nextInt();
         PreparedStatement pstmt = con.prepareStatement("DELETE FROM PATIENT_TABLE WHERE ID = ?");
         pstmt.setInt(1,r);
           int rs = pstmt.executeUpdate();
        
         
           
           con.close();
    	 System.out.println("patient id is: "+r+" succefully delted");
    	
    	}catch(Exception e) {
    		System.out.println("Failed when deleting patient details");
    	}
		
	}
	
	
public void viewOptions() {
        Scanner sc=new Scanner(System.in);
        int option=0;
        do {
        
        System.out.println("1. Insert Data");
        System.out.println("2. view the patient details");
        System.out.println("3. Search the patient by ID");
        System.out.println("4. Search the patient by City");
        System.out.println("5. Search the patient by Age");
        System.out.println("6. Search the patient by Recovery date");
        System.out.println("7. delete the patient details using patientID");
        System.out.println("0. EXIT");
        System.out.println("Choose your option");
         option=sc.nextInt();
        if(option==1) {
            insertData();
        }
        else if(option==2) {
            patientDetails();
        }
        else if(option==3) {
            searchById();
        }
        else if(option==4) {
            searchByCity();
        }
        else if(option==5) {
            searchByAge();
        }
        else if(option==6) {
            searchByRecoveyDate();
        }
        else if(option==7) {
            deleteById();
        }
        else if(option==0) {
            System.out.println("Thank you");
        }
        else {
            System.out.println("Invalid option");
        }
        }
        while(option!=0);
}
	
	
	
	
	
	public static void main(String[] args) {
		AROGYA_HOPITAL obj= new AROGYA_HOPITAL();
        obj.viewOptions();
		
	}

}


