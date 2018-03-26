

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a Job Lead</title>
    </head>
    <body>
        <h1>Add a Job Lead</h1>
        
        <form name="addForm" action="addJobLead" method="get">
            <label> Company: </label>
            <input type="text" name="company" value="" />
            <br>
            <label> Position: </label>
            <input type="text" name="position" value="" />
            <br>
            <label> Location: </label>
            <input type="text" name="location" value="" />
            <br>
            <label> Contact Name : </label>
            <input type="text" name="contactname" value="" />
            <br>
            <label> Contact Method: </label>
            <input type="text" name="contactmethod" value="" />
            <br>
            <label> Notes: </label>
            <input type="text" name="notes" value="" />
            <br>
            <label> Contact Date: </label>
            <input type="text" name="contactdate" value="" />
            <br>
            <label> Submit </label>
            <input type="submit" name="submit" value="Submit" />
            <br>
        </form>
    </body>
</html>
