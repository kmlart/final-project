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
public class Procedures {
    
	private String procCode;
                        private String procName;
                        private String description;
                        
                       
                        private String proc_cost;
                 
                       
		

                public Procedures() {
			procCode="";
                        
		procName="";
			description="";
                        
                        
			proc_cost="";
                        
                       
		}




		public Procedures(String i, String fo, String ln, String em) {
			
                    procCode = i;
                    procName = fo;
                    description=ln;
                    
                    proc_cost=em;
                
		}
                
  /*********************************************************************
 *
 * The selectDB class is used to select from database
 * 
 *******************************************************************/              
                
                
		public void selectDB(String i) {
                                          procCode=i;
			try {    //Load DB Driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            			Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Kevin/Downloads/ChiropractorOfficeMDB.accdb");


			           //Execute SQL Statement
				Statement stmt =con1.createStatement();
			        String sql = "Select * from Procedures where procCode='"+getprocCode()+"'";
			          //Process ResultSet
				System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            
            // not sure why I had to make these out of order to be displayed properly
            
            setprocName(rs.getString(1));
            setdescription(rs.getString(4));
            setproc_cost(rs.getString(2));
                   
			}
			catch(Exception se) {
				System.out.println(se);
			}
		} //end selectDB()
                
       
                
		
		public String getprocCode() { return procCode; }
		public void setprocCode(String i) { procCode=i; }
                
                
		
		public String getprocName() { return procName; }
		public void setprocName(String fo) { procName=fo; }
		
		public String getdescription() { return description; }
		public void setdescription(String ln) { description=ln; }

		
		public String getproc_cost() { return proc_cost; }
		public void setproc_cost(String em) { proc_cost=em; }
		
              
   
                
                
		public void display() {
			System.out.println("Code            =   "+ procCode);
                       
			System.out.println("Procuder Name     =   "+ procName);
			System.out.println("Description     =   "+ description);
			
			System.out.println("Cost           =   "+ proc_cost);
                        
		}
		
		public static void main(String args[]) {
			// Testing Database methods
			
                   Procedures p1;
           p1 = new Procedures();
	 p1.selectDB("PR301");
           p1.display();    
                  
             
                        
                      
                }

   

}
