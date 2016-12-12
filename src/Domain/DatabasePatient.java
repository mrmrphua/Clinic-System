package domain;

import java.io.Serializable;
import java.util.Objects;

public class DatabasePatient implements Serializable {
    private String id;
    private String name;
    private String ic;
    private String address;
    private String gender;
    private String phone;
    private String age;
    private String email;
    private String bloodType;

    public DatabasePatient() {
    }
 public DatabasePatient(String id) {
        this.id = id;
      
    }
    public DatabasePatient(String id,String name) {
        this.id = id;
        this.name=name;
       
    }
    
   


    public DatabasePatient(String id, String name, String ic,String address,String gender,String phone,String age,String email,String bloodType) {
        this.id = id;
        this.name = name;
        this.ic = ic;
        this.address=address;
        this.gender=gender;
        this.phone = phone;
        this.age=age;
        this.email=email;
        this.bloodType=bloodType;
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodType() {
        return bloodType;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DatabasePatient other = (DatabasePatient) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %-13s %-50s %-7s %-13s %-7s %-30s %-7s", id, name, ic, address,gender,phone,age,email,bloodType);
    
    
    
}}
