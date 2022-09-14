<%-- 
    Document   : patient_dashboard
    Created on : Aug 31, 2022, 11:25:37 AM
    Author     : pach3
--%>

<%@page import="Business_Object.Chiropractor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Business_Object.Patient"%>
<%@page import="Business_Object.Appointments"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
  <link
    href="https://fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700"
    rel="stylesheet">
  <style>
      
  </style>
    <title>Patient Dashboard</title>
</head>
<body>  
    <%
        Patient currentPatient;
        currentPatient = (Patient)session.getAttribute("currentPatient");
        String patientID = currentPatient.getPatientId();
        
        Appointments appt;
        appt = (Appointments)session.getAttribute("appt");
        appt.selectDB(patientID);
        
        Chiropractor chiro;
        chiro = (Chiropractor)session.getAttribute("chiro");
       
        
    %>
    
    <header>
        <div class="container-fluid bg-dark">
            <div class="container">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                  <a href="#" class="navbar-brand">Patient Dashboard</a>
                  <ul class="navbar-nav mb-2 ms-auto">
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <iconify-icon icon="carbon:user-avatar"></iconify-icon>
                      </a>
                      <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="UpdatePatientInfo.jsp">Update Profile</a></li>
                        <li><a class="dropdown-item" href="#">View Appointments</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Log out</a></li>
                      </ul>
                  </ul>
                </nav>
            </div>
        </div>
    </header>
    <section id="ads">
     <div class="container">
      <div class="bg-light shadow-sm">
        <h1 class="display-5 mt-4 p-5">  Welcome <%=currentPatient.getFirstName()%></h1>
      </div>
     </div>
    </section>
      
    <section id=" info-table">
 
    
    <div class="container-fluid">
      <div class="container">
             <button class="btn btn-secondary mt-2"type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">ADD AN APPOINTMENT</button>
               <!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Book an appointment</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form action="bookAppointmentServlet" method="POST">
              <p>
                  <label>Pick a date</label><br>
                  <input class="form-control form-control-md" type="date" name="date">
              </p>
              <p><label>Choose a Chiropractor</label></p>
              <p>
                  
                  <%
                     try{
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//Downloads//ChiropractorOfficeMDB.accdb/");
                    //Execute SQL Statement
                    Statement stmt =con1.createStatement();
                    String sql = "SELECT chiroprac_id  FROM Chiropractors";
                    //Process ResultSet
                    System.out.println(sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    %> 
                    <select class="form-control form-control-md" name="chiropract_id" require>Chiropractor 
                    <%
                    while(rs.next()){
                        
                            %>
                                <option><%=rs.getString(1)%></option>
                            <%    
                        }   
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                 %>
                 </select>
              </p>
              
              <%-------------------------- Procedure ----------------------------%>
              
              <p><label>Choose a procedure</label></p>
              <p>
                  
                  <%
                     try{
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//Downloads//ChiropractorOfficeMDB.accdb/");
                    //Execute SQL Statement
                    Statement stmt =con1.createStatement();
                    String sql = "SELECT procCode  FROM Procedures ";
                    //Process ResultSet
                    System.out.println(sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    %> 
                    <select class="form-control form-control-md" name="proc_code">Chiropractor 
                    <%
                    while(rs.next()){
                        
                            %>
                                <option><%=rs.getString(1)%></option>
                            <%    
                        }   
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                 %>
                 </select>
              </p>
              <%-------------------------- Office Number ----------------------------%>
              
              <p><label>Choose an office number</label></p>
              <p>
                  
                  <%
                     try{
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    Connection con1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//pach3//Downloads//ChiropractorOfficeMDB.accdb/");
                    //Execute SQL Statement
                    Statement stmt =con1.createStatement();
                    String sql = "SELECT office_num  FROM Chiropractors ";
                    //Process ResultSet
                    System.out.println(sql);
                    ResultSet rs = stmt.executeQuery(sql);
                    %> 
                    <select class="form-control form-control-md" name="office_num">Chiropractor 
                    <%
                    while(rs.next()){
                        
                            %>
                                <option><%=rs.getString(1)%></option>
                            <%    
                        }   
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }
                 %>
                 </select>
              </p>
              
          </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
        <input type="submit" class="btn btn-primary" value="Confirm your appointment">
      </div>
    </div>
  </div>
</div>
        <div class="row mt-5">
          <!--Appointment table-->
          <div class="col">
            <table class="table table-striped custab" style="width:100%">
              <thead class="thead-light">
                <tr>
                  <th>Appointment date and time</th>
                  <th>Chiropractor's name</th>
                  <th>Procedure Code</th>
                  <th class="text-center">Action</th>
                </tr>
              </thead>
              <tr>
                <td><%=currentPatient.getPatAppt().getApptDateTime()%></td>
                <td><%=appt.getChiropractorId()%></td>
                <td><%= appt.getProcCode()%></td>
                <td class="text-center"><a class='btn btn-info btn-xs' href="#"><span
                      class="glyphicon glyphicon-edit "></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span
                      class="glyphicon glyphicon-remove"></span> Del</a></td>
              </tr>
            </table>
          </div>
        </div>
      </div>
  </section>
  <!-- Bootstrap Javascript-->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
    crossorigin="anonymous"></script>
      <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <!-- End of Bootstrap Javascript-->
  <!--Icony cdn Script-->
  <script src="https://code.iconify.design/iconify-icon/1.0.0-beta.3/iconify-icon.min.js"></script>

</body>

</html>