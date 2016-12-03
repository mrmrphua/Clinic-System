package domain;

import java.io.Serializable;
import java.util.Objects;

public class DatabaseStaff implements Serializable {
    private String sid;
    private String sname;
    private String sic;
    private String saddress;
    private String sgender;
    private String sphone;
    private String sage;
    private String semail;

    public DatabaseStaff() {
    }
 public DatabaseStaff(String sid) {
        this.sid = sid;
      
    }
    public DatabaseStaff(String sid,String sname) {
        this.sid = sid;
        this.sname=sname;
       
    }

    public DatabaseStaff(String sid, String sname, String sic,String saddress,String sgender,String sphone,String sage,String semail) {
        this.sid = sid;
        this.sname = sname;
        this.sic = sic;
        this.saddress=saddress;
        this.sgender=sgender;
        this.sphone = sphone;
        this.sage=sage;
        this.semail=semail;
        
    
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSic(String sic) {
        this.sic = sic;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSic() {
        return sic;
    }

    public String getSaddress() {
        return saddress;
    }

    public String getSgender() {
        return sgender;
    }

    public String getSphone() {
        return sphone;
    }

    public String getSage() {
        return sage;
    }

    public String getSemail() {
        return semail;
    }


    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DatabaseStaff other = (DatabaseStaff) obj;
        if (!Objects.equals(this.sid, other.sid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %-13s %-50s %-7s %-13s %-7s %-30s %-7s", sid, sname, sic, saddress,sgender,sphone,sage,semail);
    
    
    
}}
