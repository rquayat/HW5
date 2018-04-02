
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

/**
 *
 * @author rquayat
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private JobLeads lead = new JobLeads();
    private int lead_id;
    
    public ReadRecord (int lead_id) {

        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
       
       this.lead_id = lead_id; 
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}
    
    public void doRead() {
    
        PreparedStatement ps = null;
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM jobleads WHERE lead_id=?";
            //create a prepared statement using our query string
            ps = conn.prepareStatement (query);
            //fill in the prepared statement
            ps.setInt(1, lead_id);
            //execute the query
            this.results = ps.executeQuery();
            this.results.next();
            lead.setlead_id(this.results.getInt("lead_id"));
            lead.setcompany(this.results.getString("company"));
            lead.setposition(this.results.getString("position"));
            lead.setlocation(this.results.getString("location"));
            lead.setcontact_name(this.results.getString("contact_name"));
            lead.setcontact_method(this.results.getString("contact_method"));
            lead.setnotes(this.results.getString("notes"));
            lead.setcontact_date(this.results.getString("contact_date"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    public JobLeads getlead() {
        return this.lead;
    }
}
