
package model;

public class JobLeads {
    private int lead_id;
    private String company;
    private String position;
    private String location;
    private String contact_name;
    private String contact_method;
    private String notes;
    private String contact_date;
    
     public JobLeads() {
        this.lead_id = 0;
        this.company = "";
        this.position = "";
        this.location = "";
        this.contact_name = "";
        this.contact_method = "";
        this.notes = "";
        this.contact_date = "";
    
     }
    public JobLeads( int lead_id, String company, String position, String location, String contact_name, String contact_method, String notes, String contact_date) {
        this.lead_id = lead_id;
        this.company = company;
        this.position = position;
        this.location = location;
        this.contact_name = contact_name;
        this.contact_method = contact_method;
        this.notes = notes;
        this.contact_date = contact_date;
        
        
    }

    public int getlead_id() {
        return lead_id;
    }

    public void setlead_id(int lead_id) {
        this.lead_id = lead_id;
    }

    public String getcompany() {
        return company;
    }

    public void setcompany(String company) {
        this.company = company;
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {
        this.position = position;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public String getcontact_name() {
        return contact_name;
    }

    public void setcontact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getcontact_method() {
        return contact_method;
    }

    public void setcontact_method(String contact_method) {
        this.contact_method = contact_method;
    }

    public String getnotes() {
        return notes;
    }

    public void setnotes(String notes) {
        this.notes = notes;
    }

    public String getcontact_date() {
        return contact_date;
    }

    public void setcontact_date(String contact_date) {
        this.contact_date = contact_date;
        
        
    }

    @Override
    public String toString() {
        return "JobLeads{" + "lead_id=" + lead_id + ", company=" + company + ", position=" + position + ", location=" + location + ", contact_name=" + contact_name + ", contact_method=" + contact_method + ", notes=" + notes + ", contact_date=" + contact_date + '}';
    }
    
    
}
