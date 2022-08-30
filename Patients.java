package Business;


//Java 111 Kevin Lyons



import java.sql.*;

/*********************************************************************
 *
 * The Patients class is used to hold Patients
 * 
 *******************************************************************/



public class Patients {
		
		
			private String Patient_id;
                        private String firstName;
                        private String lastName;
                        private String address;
                        private String city;
                        private String state;
                        private String zip;
                        private String email;
                        private String ins_co;
                       
		

                public Patients() {
			Patient_id="";
                        
			firstName="";
			lastName="";
                        address="";
                        city="";
                        state="";
                        zip="";
                        
			email="";
                        ins_co="";
                       
		}




		public Patients(String i, String fo, String ln, String p, String ci, String st, String zp, String em, String in ) {
			
                    Patient_id = i;
                    firstName = fo;
                    lastName=ln;
                    address=p;
                    city=ci;
                    state=st;
                    zip=zp;
                    email=em;
                    ins_co=in;
		}
                
  /*********************************************************************
 *
 * The selectDB class is used to select from database
 * 
 *******************************************************************/              
                
                
		public void selectDB(String i) {
                                           Patient_id=i;
			try {    //Load DB Driver
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            			Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Kevin/Downloads/ChiropractorOfficeMDB.accdb");


			           //Execute SQL Statement
				Statement stmt =con1.createStatement();
			        String sql = "Select * from Patients where Patient_id='"+getPatient_id()+"'";
			          //Process ResultSet
				System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            
            
            
            setfirstName(rs.getString(1));
            setlastName(rs.getString(2));
            setaddress(rs.getString(3));
            setcity(rs.getString(4));
            setstate(rs.getString(5));
            setzip(rs.getString(6));
            setemail(rs.getString(7));
            setins_co(rs.getString(8));          
			}
			catch(Exception se) {
				System.out.println(se);
			}
		} //end selectDB()
                
       
                
		
		public String getPatient_id() { return Patient_id; }
		public void setPatient_id(String i) { Patient_id=i; }
                
                
		
		public String getfirstName() { return firstName; }
		public void setfirstName(String fo) { firstName=fo; }
		
		public String getlastName() { return lastName; }
		public void setlastName(String ln) { lastName=ln; }

		public String getaddress() { return address; }
		public void setaddress(String p) { address=p; }
		
		public String getcity() { return city; }
		public void setcity(String ci) { city=ci; }
                
                
                
                
                
                
                public String getstate() { return state; }
		public void setstate(String st) { state=st; }
		
		public String getzip() { return zip; }
		public void setzip(String zp) {zip=zp; }

		public String getemail() { return email; }
		public void setemail(String em) { email=em; }
		
              public String getins_co() { return ins_co; }
		public void setins_co(String in) { ins_co=in; }
               
   
                
                
		public void display() {
			System.out.println("ID             =   "+ Patient_id);
                       
			System.out.println("Firat Name     =   "+ firstName);
			System.out.println("Last Name      =   "+ lastName);
			System.out.println("Address  =   "+ address);
			System.out.println("City            =   "+ city);
                        System.out.println("State      =   "+ state);
			System.out.println("Zip =   "+ zip);
			System.out.println("Email            =   "+ email);
                        System.out.println("Ins_Co           =   "+ ins_co);
		}
		
		public static void main(String args[]) {
			// Testing Database methods
			
                   Patients p1;
           p1 = new Patients();
	 p1.selectDB("P201");
           p1.display();    
                  
             
                        
                      
		}
}