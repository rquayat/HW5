

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="WEB-INF/newcss.css">
        <title>JSP Page</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Ryan's Job Leads</h1>
        <%= table %>
        
        <br><br>
        <a href="add">Add a New Job Lead</a>
        
        
    </body>
</html>
