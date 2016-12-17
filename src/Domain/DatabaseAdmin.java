package domain;

import java.io.Serializable;
import java.util.Objects;

public class DatabaseAdmin implements Serializable {
    private String account;
    private String id;
    private boolean status;
   

    public DatabaseAdmin() {
    }

    public DatabaseAdmin(String account, String id, boolean status) {
        this.account = account;
        this.id = id;
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DatabaseAdmin other = (DatabaseAdmin) obj;
        if (Objects.equals(this.account, other.account)) {
            return false;
        }
        return true;
    }

    
    
}
