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
    
    public void doRead() {
        try {
            String query ="Select * from jobleads";
            PreparedStatement ps = conn.prepareStatement (query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String GetHTMLtable() {
        String table = "";
            table += "<table border=1>";
        
        
        try {
           
            
            while (this.results.next()) {
                JobLeads lead = new JobLeads();
                lead.setLead_id(this.results.getInt("lead_id"));
                lead.setCompany(this.results.getString("company"));
                lead.setPosition(this.results.getString("position"));
                lead.setLocation(this.results.getString("location"));
                lead.setContact_name(this.results.getString("contact_name"));
                lead.setContact_method(this.results.getString("contact_method"));
                lead.setNotes(this.results.getString("notes"));
                lead.setContact_date(this.results.getString("contact_date"));
                
                table += "<tr>";
                table += "<td>";
                table += lead.getLead_id();
                table += "</td>";
                
                table += "<td>";
                table += lead.getCompany();
                table += "</td>";
                
                table += "<td>";
                table += lead.getPosition();
                table += "</td>";
                
                table += "<td>";
                table += lead.getLocation();
                table += "</td>";
                
                table += "<td>";
                table += lead.getContact_name();
                table += "</td>";
                
                table += "<td>";
                table += lead.getContact_method();
                table += "</td>";
                
                table += "<td>";
                table += lead.getNotes();
                table += "</td>";
                
                table += "<td>";
                table += lead.getContact_date();
                table += "</td>";
                table += "</tr>";
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
            return table;
     
    }


    public String getHTMLTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
