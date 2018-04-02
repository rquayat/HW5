package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JobLeads;




public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // SOLID CONNECTION TO DATABASE SHOULD BE ESTABLISHED AFTER ABOVE IS RUN!
    
    
    public void doRead() {
        try {
            String query ="SELECT * FROM jobleads ORDER BY lead_id asc";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable() {
        String table = "";
            table += "<table>";
        
        
        try {
           
            
            while (this.results.next()) {
                JobLeads lead = new JobLeads();
                lead.setlead_id(this.results.getInt("lead_id"));
                lead.setcompany(this.results.getString("company"));
                lead.setposition(this.results.getString("position"));
                lead.setlocation(this.results.getString("location"));
                lead.setcontact_name(this.results.getString("contact_name"));
                lead.setcontact_method(this.results.getString("contact_method"));
                lead.setnotes(this.results.getString("notes"));
                lead.setcontact_date(this.results.getString("contact_date"));
                
                table += "<tr class='.table'>";
                
                table += "<td class='.td'>";
                table += lead.getlead_id();
                table += "</td>";
                
                table += "<td class='.td'>";
                table += lead.getcompany();
                table += "</td>";
               
                table += "<td class='.td'>";
                table += lead.getposition();
                table += "</td>";
                
                table += "<td class='.td'>";
                table += lead.getlocation();
                table += "</td>";
                
                table += "<td class='.td'>";
                table += lead.getcontact_name();
                table += "</td>";
                
                table += "<td class='.td'>";
                table += lead.getcontact_method();
                table += "</td>";
                
                table += "<td class='.td'>";
                table += lead.getnotes();
                table += "</td>";
                
                table += "<td class='.td'>";
                table += lead.getcontact_date();
                table += "</td>";
                
                
                table += "<td class='.td'>";
                table += "<a href=update?lead_id=" + lead.getlead_id() + "> Update </a>" + "<a href=delete?lead_id=" + lead.getlead_id() + "> Delete <a/>";
                table += "</td>";
                table += "</tr>";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
            return table;
     
    }


   
    
}
