/**
 * File: Renter.java
 * Description:This class describes attributes of Table Renter. This table records all renters’ general information
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package transferobjects;
import java.sql.Date;

public class Renter {
    private int renterId;
    private String email;
    private String passWord;
    private String firstName;
    private String lastName;
    private String phone;
    private int gender;
    private String dateBirth;
    private Boolean isStudent;
    private Boolean isEmployed;
    private Boolean isSmoker;
    private Date startDate;
    private Date endDate;
    private int availability;
    private double lowPrice;
    private double highPrice; 
    private String referralSource;
    private Boolean hasCRCheck;
    
    
    public Renter(){
    }
    

    public Renter(int renterId, String email, String passWord, String firstName, String lastName,String phone,int gender,String dateBirth, Boolean isStudent,Boolean isEmployed,Boolean isSmoker,Date startDate,Date endDate,int availability, double lowPrice, double highPrice,String referralSource,Boolean hasCRCheck) {
    setRenterId(renterId);
    setEmail(email);
    setPassWord(passWord);
    setFirstName(firstName);
    setLastName(lastName);
    setPhone(phone);
    setGender(gender);
    setDOB(dateBirth);
    setIsStudent(isStudent);
    setIsEmployed(isEmployed);
    setIsSmoker(isSmoker);
    setStartDate(startDate);
    setEndDate(endDate);
    setAvailability(availability);
    setLowPrice(lowPrice);
    setHighPrice(highPrice); 
    setReferralSource(referralSource);
    setHasCRCheck(hasCRCheck);
    }



    public int getRenterID() {
        return renterId;
    }
    public String getEmail(){
        return email;
    }
    public String getPassWord(){
        return passWord;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone(){
        return phone;
    }
    public int getGender(){
        return gender;
    }
    public String getDateBirth() {
        return dateBirth;
    }

    public Boolean getIsStudent(){
        return isStudent;
    }
    public Boolean getIsEmployed(){
        return isEmployed;
    }
    public Boolean getIsSmoker(){
        return isSmoker;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public int getAvailability(){
        return availability;
    }
    public double getLowPrice(){
        return lowPrice;
    }
    public double getHighPrice(){
        return highPrice;
    }
    public String getReferralSource(){
        return referralSource;
    }
    public Boolean getHasCRCheck(){
        return hasCRCheck;
    }

    public void setRenterId(int renterId){
        this.renterId=renterId;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassWord(String passWord){
        this.passWord=passWord;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     public void setPhone(String phone){
         this.phone=phone;
     }
     public void setGender(int gender){
         this.gender=gender;
     }
     public void setDOB(String dateBirth){
         this.dateBirth=dateBirth;
     }
     public void setIsStudent(Boolean isStudent){
         this.isStudent=isStudent;
     }
     public void setIsEmployed(Boolean isEmployed){
         this.isEmployed=isEmployed;
     }
     public void setIsSmoker(Boolean isSmoker){
         this.isSmoker=isSmoker;
     }
     public void setStartDate(Date startDate){
         this.startDate=startDate;
     }
     public void setEndDate(Date endDate){
         this.endDate=endDate;
     }
     public void setAvailability(int availability){
         this.availability=availability;
     }
     public void setLowPrice(double lowPrice){
         this.lowPrice=lowPrice;
     }
     public void setHighPrice(double highPrice){
         this.highPrice=highPrice;
     } 
     public void setReferralSource(String referralSource){
         this.referralSource=referralSource;
     }
     public void setHasCRCheck(Boolean hasCRCheck){
         this.hasCRCheck=hasCRCheck;
     }
}
