/**
 * File: Host.java
 * Description:This class describes attributes of Table Host. This table records all hosts’ general information.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package transferobjects;


public class Host {
    private int hostId;
    private String email;
    private String passWord;
    private String firstName;
    private String lastName;
    private String phone;
    private int gender;
    private String dateBirth;
    private Boolean retired;
    private Boolean pets;
    private Boolean smoker;
    private String referralSource;
 
    public Host(){
    }

    public Host(int hostId, String email, String passWord, String firstName, String lastName,String phone,int gender,String dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource) {
    setHostId(hostId);
    setEmail(email);
    setPassWord(passWord);
    setFirstName(firstName);
    setLastName(lastName);
    setPhone(phone);
    setGender(gender);
    setDOB(dateBirth);
    setRetired(retired);
    setPets(pets);
    setSmoker(smoker);
    setReferralSource(referralSource);
    }



    public int getHostID() {
        return hostId;
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

    public Boolean getRetired(){
        return retired;
    }
    public Boolean getPets(){
        return pets;
    }
    public Boolean getSmoker(){
        return smoker;
    }

    public String getReferralSource(){
        return referralSource;
    }

    public void setHostId(int hostId){
        this.hostId=hostId;
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
     public void setRetired(Boolean retired){
         this.retired=retired;
     }
     public void setPets(Boolean pets){
         this.pets=pets;
     }
     public void setSmoker(Boolean smoker){
         this.smoker=smoker;
     }
     public void setReferralSource(String referralSource){
         this.referralSource=referralSource;
     }
  
}
