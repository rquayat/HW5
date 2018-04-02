

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.JobLeads"%>
<%JobLeads lead = (JobLeads) request.getAttribute("lead"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="WEB-INF/newcss.css">
        <title>Update a Job Lead</title>
    </head>
    <body>
        <h1>Update a Job Lead</h1>
        
        <form name="updateForm" action="updatelead" method="get">
            <table class="table">
                <tr> 
                    <td> Lead ID: </td>
                    <td><input type="text" name="lead_id" value="<% lead.getlead_id(); %>" > </td>
                </tr>          
                <br>
                <tr> 
                    <td> Company: </td>
                    <td><input type="text" name="company" value="<% lead.getcompany(); %>" > </td>
                </tr>
            <br>
                <tr> 
                    <td> Position: </td>
                    <td><input type="text" name="position" value="<% lead.getposition(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Location: </td>
                    <td><input type="text" name="location" value="<% lead.getlocation(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Contact Name: </td>
                    <td><input type="text" name="contact_name" value="<% lead.getcontact_name(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Contact Method: </td>
                    <td><input type="text" name="contact_method" value="<% lead.getcontact_method(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Notes: </td>
                    <td><input type="text" name="notes" value="<% lead.getnotes(); %>" > </td>
                </tr>           
            <br>
            <tr> 
                    <td> Contact Date: </td>
                    <td><input type="text" name="contact_date" value="<% lead.getcontact_date(); %>" ></td>
                </tr>           
            </table>
            <br>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Update" />
            <br>
        </form>
    </body>
</html>
