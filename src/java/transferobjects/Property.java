/**
 * File: Property.java
 * Description:This class describes attributes of Table Property. This table records all property information posted by hosts
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

public class Property {
    private int propertyId;
    private int hostId;
    private String address;
    private String city;
    private String postalCode;
    private String province;
    private String country;
    private int famMembers;
    private Boolean isSmokerFriendly;
    private Boolean isPetFriendly;
    private double price;
    private Date startDate;
    private Date endDate;
    private String chores;
    private int availability; 
    
    public Property(){       
    }
    public Property(int propertyId, int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,double price,Date startDate,Date endDate,String chores,int availability) {
    setPropertyId(propertyId);
    setHostId(hostId);
    setAddress(address);
    setCity(city);
    setPostalCode(postalCode);
    setProvince(province);
    setCountry(country);
    setFamMembers(famMembers);
    setIsSmokerFriendly(isSmokerFriendly);
    setIsPetFriendly(isPetFriendly);
    setPrice(price);
    setStartDate(startDate);
    setEndDate(endDate);
    setChores(chores);
    setAvailability(availability);
    }

    public int getpropertyID() {
        return propertyId;
    }

    public int getHostID() {
        return hostId;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry(){
        return country;
    }
    public int getFamMembers(){
        return famMembers;
    }
    public Boolean getIsSmokerFriendly() {
        return isSmokerFriendly;
    }

    public Boolean getIsPetFriendly(){
        return isPetFriendly;
    }
    public double getPrice(){
        return price;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public String getChores(){
        return chores;
    }
    
    public int getAvailability(){
        return availability;
    }
    
    public void setPropertyId(int propertyId){
        this.propertyId=propertyId;
    }
    
    public void setHostId(int hostId){
        this.hostId=hostId;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setPostalCode(String postalCode){
        this.postalCode=postalCode;
    }
    public void setProvince(String province){
        this.province=province;
    }
    public void setCountry(String contry){
        this.country=country;
    }
    public void setFamMembers(int famMembers){
        this.famMembers= famMembers;
    }
    public void setIsSmokerFriendly(Boolean isSmokerFriendly){
        this.isSmokerFriendly=isSmokerFriendly;
    }
    public void setIsPetFriendly(Boolean isPetFriendly){
        this.isPetFriendly=isPetFriendly;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setStartDate(Date startDate){
        this.startDate=startDate;
    }
    public void setEndDate(Date endDate){
        this.endDate=endDate;
    }
    public void setChores(String chores){
        this.chores=chores;
    }
    public void setAvailability(int availability){
        this.availability=availability;
    }
}

