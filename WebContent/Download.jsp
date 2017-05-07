<%-- 
    Document   : Download
    Created on : Nov 4, 2014, 2:23:20 PM
    Author     : Raja
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cloud</title>
<meta name="keywords" content="free css, web template, cloudy" />
<meta name="description" content="Cloudy - free website template provided by templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/featuredcontentglider.css" />
 <link href="css/style_2.css" rel="stylesheet" type="text/css" />
 <link href="style.css" rel="stylesheet" type="text/css" />
 
<script language="javascript" type="text/javascript">

</script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="css/featuredcontentglider.js">
     
/***********************************************
* Featured Content Glider script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
</head>
<body>

<div id="templatemo_wrapper_outer">
<div id="templatemo_wrapper">

	<jsp:include page="header1.jsp" />
        
			<script type="text/javascript">
  
                        function fillTextbox(value)
                        {
                            var valueAry = value.split("|");
                            var fileName = valueAry[0];
                            var fileKey = valueAry[1];
                            document.downloadform.POwner.value = fileKey;
                            document.downloadform.File.value = fileName;
                            
                        }
                        
                        function downloadCheck()
                        {
                            var public = document.downloadform.POwner.value;
                            var private =document.downloadform.PUser.value;
                        
                            if(public.length != 16){
                                alert("Pulbic key should be of 16 digits");
                                return ;
                            }
                            
                            if(private.length != 8){
                                alert("Private key should be of 8 digits");
                                return ;
                            }
                            
                            var result = confirm("Do you want to download this file ?");
                            if(result ==  true){
                                document.downloadform.action = "downloadfile";
                                document.downloadform.submit();
                            }else{
                                
                            }
                        }
            
            </script>
          <!-- end of templatemo_banner -->
   
        <br>
        </br>
<!--        <div>    <img width="400" height="200" src="images1/download.jpg" alt="" style="border-radius:20px" ></img></div>-->
      <form  method="post" name="downloadform">
<%
    //String userid1,path1,FileName1;    
    int i=1;
        try
        {          
                       String uid=(String)session.getAttribute("uid1");
  System.err.println("uid" + uid);
//MODIFICATION 1 )...    		
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con1 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/decentralize", "root", "root");
 //MODIFICATION 1 (END)...  
		//PreparedStatement pr=con.prepareStatement("select * from Reg");
            String sa="select * from requestst where assignee='"+uid+"' and Response='Done'";
            PreparedStatement pr=con1.prepareStatement(sa);
            ResultSet rs=pr.executeQuery();
            
            ArrayList Fname=new ArrayList();
          %>
            <br>
                <br>    <br>    
                             <div>
        <% String a=(String) session.getAttribute("uname1");
    %>
        <h4 align="right" style="margin-top:-20px;margin-right: 36px;"> Name : <font color="red"><%=a%></font></h4>
   </div>
            <div align="center">
                <table border="2" bgcolor="pink" style="margin-top: 10px;">
                <tr>
                    <td></td>
                     <td>S.No</td>
                     <td>File Name</td>
                     <td>File Key</td>
                </tr>
          
                <%
                while(rs.next())
                {
                %>
                <tr>
                    <%
                        
                        System.err.println("uid" + uid);
                    String Fname1=rs.getString(3);
                    String key1=rs.getString(4);
                    //request.setAttribute("FName","Fname1");
                    Fname.add(Fname1);
                    Fname.indexOf(i);
                    Date now=new Date();
                    //int d=now;
                    request.setAttribute("TDate","Date");
                    String values = Fname1+"|"+key1;
                    %>
                    <td><input type="radio" name="filedetails" onclick="fillTextbox('<%=values%>')"/></td>
                        <td><%=(i++)%></td> 
                        <td><%=Fname1%></td>
                        <td><%=key1%></td>
                       <!-- <td><font color="white"><input type="radio" name="s" value=</%=Fname1%>>Select for Download<br></font></td>  -->                                    
                
                </tr>    
                     <%
                        }    
                     %>           
            </table><br></br>
           <table bgcolor="lightblue" border="1">
               <tr><td>
           File Name  : <input type="text" name="File"></input>
           <br></br></td></tr>
               <tr><td>
           File Key  : <input type="password" name="POwner"></input>
           <br></br></td></tr>
               <tr><td>
           Private Key : <input type="password" name="PUser" ></input>
           <br></br></td></tr>
               <tr align="center"><td>
                       <input type="button" value="Download" onclick="downloadCheck();"/>
                   </td></tr>
           </table>
           
            
            </div>
           <%            
            //
                       }
        catch(Exception e)
        {
            System.out.println("Exception"+e);
        }
            
     %>  
    </form>
        </div>
    

        
<div id="templatemo_content_wrapper_bottom"></div> <!-- end of templatemo_wrapper -->

        <div id="templatemo_footer">
<!--   	    Copyright © 2048 <a href="#">Your Company Name</a> | <a href="http://www.iwebsitetemplate.com" target="_parent">Website Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free CSS Templates</a></div>-->
</div>
</div>
</body>
</html>