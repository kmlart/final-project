/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.*;

/**
 *
 * @author Kevin
 */




public class Chiropractors {
private String chiroprac_id;
               
		private String firstName;
		private String lastName;
		
		private String email;
                private String office_num;
               private String admin_id;
		
		public Chiropractors() {
			chiroprac_id="";
                        
			firstName="";
			lastName="";
			email="";
                        office_num="";
                        admin_id="";
                       
		}
		public Chiropractors(String i, String fn, String ln, String ed, String ap, String ad) {
			chiroprac_id=i;
                        
			firstName=fn;
			lastName=ln;
			email=ed;
                        office_num=ap;
                        admin_id= ad;
                        
		}


                
                
 /*********************************************************************
 *
 * The selectDB gets dentist info from database
 * 
 *******************************************************************/               
                
                
                
                
public void selectDB(String i) {
                              chiroprac_id=i;           
			try {    //Load DB Driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            			Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Kevin/Downloads/ChiropractorOfficeMDB.accdb");


			           //Execute SQL Statement
				Statement stmt =con1.createStatement();
			        String sql = "Select * from Chiropractors where chiroprac_id='"+getchiroprac_id()+"'";
			          //Process ResultSet
				System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
                                
                                
                                //Not sure why I had to number them out of order
                                
                                //had to unorganize so they would show up correctly when displayed
                                
				setfirstName(rs.getString(1));
            setlastName(rs.getString(2));
            setemail(rs.getString(4));
            setoffice_num(rs.getString(3));
            setadmin_id(rs.getString(6));
            
			}
			catch(Exception se) {
				System.out.println(se);
			}
		} //end selectDB()
                
       








                public String getchiroprac_id() { return chiroprac_id; }
		public void setchiroprac_id(String i) { chiroprac_id=i; }
                
               public String getfirstName() { return firstName; }
		public void setfirstName(String fn) { firstName=fn; }
                
                
                public String getlastName() { return lastName; }
		public void setlastName(String ln) { lastName=ln; }
		
	

		
		
		public String getemail() { return email; }
		public void setemail(String ed) { email=ed; }
                
                
                public String getoffice_num() { return office_num; }
		public void setoffice_num(String ap) { office_num=ap; }
                
                public String getadmin_id() { return admin_id; }
		public void setadmin_id(String ad) { admin_id=ad; }
                

		
		
               
    
                
                
		public void display() {
			System.out.println("ID             =   "+ chiroprac_id);
                        
			System.out.println("First Name     =   "+ firstName);
			System.out.println("Last Name      =   "+ lastName);
			
			System.out.println("Email            =   "+ email);
                        System.out.println("Office           =   "+ office_num);
                        System.out.println("Admin id = " + admin_id);
		}
		
		public static void main(String args[]) {
			
                  Chiropractors c1;
           c1 = new Chiropractors();
	 c1.selectDB("C510");
           c1.display();    
            
                        
                        
                }
}
