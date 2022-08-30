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
public class Admin {
    
		private String Admin_id;
                        private String firstName;
                        private String lastName;
                        
                       
                        private String email;
                        private String phoneNum;
                       
		

                public Admin() {
			Admin_id="";
                        
			firstName="";
			lastName="";
                        
                        
			email="";
                        phoneNum="";
                       
		}




		public Admin(String i, String fo, String ln, String em, String in ) {
			
                    Admin_id = i;
                    firstName = fo;
                    lastName=ln;
                    
                    email=em;
                    phoneNum=in;
		}
                
  /*********************************************************************
 *
 * The selectDB class is used to select from database
 * 
 *******************************************************************/              
                
                
		public void selectDB(String i) {
                                           Admin_id=i;
			try {    //Load DB Driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            			Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Kevin/Downloads/ChiropractorOfficeMDB.accdb");


			           //Execute SQL Statement
				Statement stmt =con1.createStatement();
			        String sql = "Select * from Admin where Admin_id='"+getAdmin_id()+"'";
			          //Process ResultSet
				System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            
            
            
            setfirstName(rs.getString(1));
            setlastName(rs.getString(2));
            
            setemail(rs.getString(3));
            setphoneNum(rs.getString(4));          
			}
			catch(Exception se) {
				System.out.println(se);
			}
		} //end selectDB()
                
       
                
		
		public String getAdmin_id() { return Admin_id; }
		public void setAdmin_id(String i) { Admin_id=i; }
                
                
		
		public String getfirstName() { return firstName; }
		public void setfirstName(String fo) { firstName=fo; }
		
		public String getlastName() { return lastName; }
		public void setlastName(String ln) { lastName=ln; }

		
		public String getemail() { return email; }
		public void setemail(String em) { email=em; }
		
              public String getphoneNum() { return phoneNum; }
		public void setphoneNum(String in) { phoneNum=in; }
               
   
                
                
		public void display() {
			System.out.println("ID             =   "+ Admin_id);
                       
			System.out.println("Firat Name     =   "+ firstName);
			System.out.println("Last Name      =   "+ lastName);
			
			System.out.println("Email            =   "+ email);
                        System.out.println("Phone number           =   "+ phoneNum);
		}
		
		public static void main(String args[]) {
			// Testing Database methods
			
                   Admin a1;
           a1 = new Admin();
	 a1.selectDB("A100");
           a1.display();    
                  
             
                        
                      
                }

   

}