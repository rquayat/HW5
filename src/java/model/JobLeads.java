
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
    public JobLeads(int lead_id, String company, String position, String location, String contact_name, String contact_method, String notes, String contact_date) {
        this.lead_id = lead_id;
        this.company = company;
        this.position = position;
        this.location = location;
        this.contact_name = contact_name;
        this.contact_method = contact_method;
        this.notes = notes;
        this.contact_date = contact_date;
        
        
    }

    public int getLead_id() {
        return lead_id;
    }

    public void setLead_id(int lead_id) {
        this.lead_id = lead_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_method() {
        return contact_method;
    }

    public void setContact_method(String contact_method) {
        this.contact_method = contact_method;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getContact_date() {
        return contact_date;
    }

    public void setContact_date(String contact_date) {
        this.contact_date = contact_date;
        
        
    }

    @Override
    public String toString() {
        return "JobLeads{" + "lead_id=" + lead_id + ", company=" + company + ", position=" + position + ", location=" + location + ", contact_name=" + contact_name + ", contact_method=" + contact_method + ", notes=" + notes + ", contact_date=" + contact_date + '}';
    }
    
    
}
