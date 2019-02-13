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
    private Boolean hydroIncl;
    private Boolean waterIncl;
    private Boolean gasIncl;
    private Boolean cableIncl;
    private Boolean internet;
    private Boolean parking;
    private Boolean laundry;
    private Boolean familyRoom;
    private Boolean priBedroom;
    private Boolean shaBedroom;
    private Boolean priKitchen;
    private Boolean shaKitchen;
    private Boolean priWashroom;
    private Boolean shaWashroom;    
    private double price;
    private Date startDate;
    private Date endDate;
    private String chores;
    private int availability; 
    
    public Property(){       
    }
    public Property(int propertyId, int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,Boolean hydroIncl,Boolean waterIncl,Boolean gasIncl,Boolean cableIncl,Boolean internet,Boolean parking,Boolean laundry,Boolean familyRoom,Boolean priBedroom,Boolean shaBedroom,Boolean priKitchen,Boolean shaKitchen,Boolean priWashroom,Boolean shaWashroom,double price,Date startDate,Date endDate,String chores,int availability) {
    setPropertyId(propertyId);
    setHostId(hostId);
    setAddress(address);
    setCity(city);
    setPostalCode(postalCode);
    setProvince(province);
    setCountry(country);
    setFamMembers(famMembers);
    setIsSmokerFriendly(isSmokerFriendly);
    setHydroIncl(hydroIncl);
    setWaterIncl(waterIncl);
    setGasIncl(gasIncl);
    setCableIncl(cableIncl);
    setInternet(internet);
    setParking(parking);
    setLaundry(laundry);
    setFamilyRoom(familyRoom);
    setPriBedroom(priBedroom);
    setShaBedroom(shaBedroom);
    setPriKitchen(priKitchen);
    setShaKitchen(shaKitchen);
    setPriWashroom(priWashroom);
    setShaWashroom(shaWashroom);
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
    
    public Boolean getHydroIncl(){
        return hydroIncl;
    }
    
    public Boolean getWaterIncl(){
        return waterIncl;
    }
    
    public Boolean getGasIncl(){
        return gasIncl;
    }
    
    public Boolean getCableIncl(){
        return cableIncl;
    }
    
    public Boolean getInternet(){
        return internet;
    }
    
    public Boolean getParking(){
        return parking;
    }
    
    public Boolean getLaundry(){
        return laundry;
    }
    
    public Boolean getFamilyRoom(){
        return familyRoom;
    }
    
    public Boolean getPriBedroom(){
        return priBedroom;
    }
    
    public Boolean getShaBedroom(){
        return shaBedroom;
    }
    
    public Boolean getPriKitchen(){
        return priKitchen;
    }
    
    public Boolean getShaKitchen(){
        return shaKitchen;
    }
    
    public Boolean getPriWashroom(){
        return priWashroom;
    }
    
    public Boolean getShaWashroom(){
        return shaWashroom;
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
    public void setCountry(String country){
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
        
    public void setHydroIncl(Boolean hydroIncl){
        this.hydroIncl=hydroIncl;
    }
    
    public void setWaterIncl(Boolean waterIncl){
        this.waterIncl=waterIncl;
    }
    
    public void setGasIncl(Boolean gasIncl){
        this.gasIncl=gasIncl;
    }
    
    public void setCableIncl(Boolean cableIncl){
        this.cableIncl=cableIncl;
    }
    
    public void setInternet(Boolean internet){
        this.internet=internet;
    }
    
    public void setParking(Boolean parking){
        this.parking=parking;
    }
    
    public void setLaundry(Boolean laundry){
        this.laundry=laundry;
    }
    
    public void setFamilyRoom(Boolean familyRoom){
        this.familyRoom=familyRoom;
    }
    
    public void setPriBedroom(Boolean priBedroom){
        this.priBedroom=priBedroom;
    }
    
    public void setShaBedroom(Boolean shaBedroom){
        this.shaBedroom=shaBedroom;
    }
    
    public void setPriKitchen(Boolean priKitchen){
        this.priKitchen=priKitchen;
    }
    
    public void setShaKitchen(Boolean shaKitchen){
        this.shaKitchen=shaKitchen;
    }
    
    public void setPriWashroom(Boolean priWashroom){
        this.priWashroom=priWashroom;
    }
    
    public void setShaWashroom(Boolean shaWashroom){
        this.shaWashroom=shaWashroom;
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

