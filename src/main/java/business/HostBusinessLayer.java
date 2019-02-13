/*
 * File: HostBusinessLayer.java
 * Description: transfer function between Java and database
 * Create: Sep.30,2018 by Xia Sheng
 * Author: Liangliang Du
 * Modified:Oct,13,2018
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package business;

import dataaccess.HostDAO;
import dataaccess.HostDAOImpl;
import java.util.List;

import business.ValidationException;
import transferobjects.Host;


public class HostBusinessLayer {
    
    private static final int EMAIL_LENGTH = 42;
    private static final int FIRST_NAME_LENGTH = 45;
    private static final int LAST_NAME_LENGTH = 45;
    private static final int PHONE_LENGTH = 12;
    private static final int DOB_LENGTH = 4;
    private static final int REFERRAL_LENGTH = 45;
    
    private HostDAO hostDAO = null;
    
    public HostBusinessLayer() {
        hostDAO = new HostDAOImpl();
    }
      
    public List<Host> getAllHost(){
        return hostDAO.getAllHost();
    }
    public void addHost(Host host) throws ValidationException {
        try {
            validateSignUpFields(host);
            hostDAO.addHost(host);
        }
        catch(ValidationException e) {
            throw e;
        }
    }
    public Host getHostByHostId(int hostId){
        return hostDAO.getHostByHostId(hostId);
    } 
    
    public Host getHostByEmail(String email){
        return hostDAO.getHostByEmail(email);
    }
    
    public boolean hostExists(String email) {
        return getHostByEmail(email) != null;
    }
    
    public void deleteHost(int hostId){
        hostDAO.deleteHost(hostId);
    }
    public void updateHost( String email, String passWord, String firstName, String lastName,String phone,int gender,String dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource,int hostId){
        hostDAO.updateHost(email, passWord, firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
    }
    public void updateHost(String firstName, String lastName,String phone,int gender,String dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource,int hostId){
        hostDAO.updateHost(firstName, lastName, phone, gender, dateBirth, retired, pets, smoker,referralSource, hostId);
    }
    
    public void updateHost(String passWord, int hostId){
        hostDAO.updateHost(passWord, hostId);
    }
    public boolean passwordCorrect(String email, String password){
        return hostDAO.passwordCorrect(email, password);
    }
    
    private void validateSignUpFields(Host host) throws ValidationException {
        
        if(host.getFirstName() == null || host.getFirstName().length() > FIRST_NAME_LENGTH) {
            throw new ValidationException("Invalid first name format");
        } 
        if(host.getLastName() == null || host.getLastName().length() > LAST_NAME_LENGTH) {
            throw new ValidationException("Invalid last name format");
        }
        if(host.getEmail() == null || host.getEmail().length() > EMAIL_LENGTH) {
            throw new ValidationException("Invalid email format");
        }
        if(host.getPhone() == null || host.getPhone().length() > PHONE_LENGTH) {
            throw new ValidationException("Invalid phone format");
        }
        if(host.getGender() != 1 && host.getGender() != 0) {
            throw new ValidationException("Invalid gender value");
        }
        if(host.getDateBirth() == null || host.getDateBirth().length() > DOB_LENGTH) {
            throw new ValidationException("Invalid date of birth");
        }
        if(host.getReferralSource() == null || host.getReferralSource().length() > REFERRAL_LENGTH) {
            throw new ValidationException("Invalid referral source");
        }
    }
}
