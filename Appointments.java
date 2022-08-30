/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kevin
 */
public class Appointments {
    
private String apptDateTime;
                        private String patient_id;
                        private String chiroprac_id;
                        
                       
                        private String proc_code;
                        private String office_num;
                       
		

                public Appointments() {
			apptDateTime="";
                        patient_id="";
			chiroprac_id="";
			proc_code="";
                        
                        
			office_num="";
                    
                       
		}




		public Appointments(String i, String fo, String ln, String em, String in ) {
			
                    apptDateTime = i;
                    patient_id = fo;
                    chiroprac_id=ln;
                    
                    proc_code=em;
                    office_num=in;
		}
                
  /*********************************************************************
 *
 * The selectDB class is used to select from database
 * 
 *******************************************************************/              
                
                
		public void selectDB(String i) {
                                           patient_id=i;
			try {    //Load DB Driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            			Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Kevin/Downloads/ChiropractorOfficeMDB.accdb");


			           //Execute SQL Statement
				Statement stmt =con1.createStatement();
			        String sql = "Select * from Appointments where patient_id='"+getpatient_id()+"'";
			          //Process ResultSet
				System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            
            
           
            setpatient_id(rs.getString(1));
            setchiroprac_id(rs.getString(2));
            
            setproc_code(rs.getString(3));
            setoffice_num(rs.getString(4));          
			}
			catch(Exception se) {
				System.out.println(se);
			}
		} //end selectDB()
                
       
                
		
		public String getapptDateTime() { return apptDateTime; }
		public void setapptDateTime (String i) { apptDateTime=i; }
                
                
		
		public String getpatient_id() { return patient_id; }
		public void setpatient_id(String fo) { patient_id=fo; }
		
		public String getchiroprac_id() { return chiroprac_id; }
		public void setchiroprac_id(String ln) { chiroprac_id=ln; }

		
		public String getproc_code() { return proc_code; }
		public void setproc_code(String em) {proc_code=em; }
		
              public String getoffice_num() { return office_num; }
		public void setoffice_num(String in) { office_num=in; }
               
   
                
                
		public void display() {
			System.out.println("Date            =   "+ apptDateTime);
                       
			System.out.println("Patient ID     =   "+ patient_id);
			System.out.println("Chiropractor ID    =   "+ chiroprac_id);
			
			System.out.println("Code           =   "+ proc_code);
                        System.out.println("Office number           =   "+ office_num);
		}
		
		public static void main(String args[]) {
			// Testing Database methods
			
                   Appointments a1;
           a1 = new Appointments();
	 a1.selectDB("P202");
           a1.display();    
                  
             
                        
                      
                }

   

}
