/*
 * File: RenterBusinessLayer.java
 * Description:
 * Create: Sep,30,2018
 * Author: Bits & Bytes Team-Christopher Labelle,Liangliang Du,Melissa Rajala,Zhan Shen,Xia Sheng,Bin Yang
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package business;

import dataaccess.RenterDAO;
import dataaccess.RenterDAOImpl;
import java.sql.Date;
import java.util.List;
import transferobjects.Renter;

/**
 *
 * @author Chris
 * Modified by Liangliang: add getAllRenter(),deleteRenter(), and updateRenter()
 */
public class RenterBusinessLayer {
 
    private static final int EMAIL_LENGTH = 42;
    private static final int FIRST_NAME_LENGTH = 45;
    private static final int LAST_NAME_LENGTH = 45;
    private static final int PHONE_LENGTH = 12;
    private static final int DOB_LENGTH = 4;
    private static final int REFERRAL_LENGTH = 45;
    
    private RenterDAO renterDAO = null;
    
    public RenterBusinessLayer() {
        renterDAO = new RenterDAOImpl();
    }
    
    public List<Renter> getAllRenter() {
        return renterDAO.getAllRenter();
    }
    
    public Renter getRenterByRenterId(int renterId) {
        return renterDAO.getRenterByRenterId(renterId);
    }
    
    public Renter getRenterByRenterUname(String username) {
        return renterDAO.getRenterByRenterUname(username);
    }

    public void addRenter(Renter renter) throws ValidationException {
        try {
            validateSignUpFields(renter);
            renterDAO.addRenter(renter);
        }
        catch(ValidationException e) {
            throw e;
        }
    }   
    
    public Renter getRenterByEmail(String email) {
        return renterDAO.getRenterByEmail(email);
    }
    
    public boolean renterExists(String email) {   
        if(renterDAO.getRenterByEmail(email) == null) 
            return false;
        else {
            return true;
        }
        
    }
    
    public boolean passwordCorrect(String email, String password) {
        return renterDAO.passwordCorrect(email, password); //updated by Zhan
//        boolean correct = false;
//        if(renterDAO.passwordCorrect(email, password)) {
//            correct = true;
//        }
//        return correct;
    }
    
    public void deleteRenter(int renterId){
        renterDAO.deleteRenter(renterId);
    }
    
    public void updateRenter(String email, String passWord, String firstName, String lastName,
            String phone,int gender,String dateBirth, Boolean isStudent,Boolean isEmployed,Boolean isSmoker,
            Date startDate,Date endDate,int availability, double lowPrice, double highPrice,String referralSource,
            Boolean hasCRCheck,int renterId) throws ValidationException {
        renterDAO.updateRenter(email, passWord, firstName, lastName, phone, gender, dateBirth, 
                isStudent, isEmployed, isSmoker, startDate, endDate, availability, lowPrice, highPrice, 
                referralSource, hasCRCheck, renterId);
    }
    
    public void updateRenter(String firstName, String lastName,
            String phone,int gender,String dateBirth, Boolean isStudent,Boolean isEmployed,Boolean isSmoker,
            Date startDate, Date endDate, double lowPrice, double highPrice, int renterId){
        renterDAO.updateRenter(firstName, lastName, phone, gender, dateBirth, 
                isStudent, isEmployed, isSmoker, startDate, endDate, lowPrice, highPrice, renterId);
    }
    
    public void updateRenter(String passWord, int renterId){
        renterDAO.updateRenter(passWord, renterId);
    }
    
    private void validateSignUpFields(Renter renter) throws ValidationException {
        
        if(renter.getFirstName() == null || renter.getFirstName().length() > FIRST_NAME_LENGTH) {
            throw new ValidationException("Invalid first name format");
        } 
        if(renter.getLastName() == null || renter.getLastName().length() > LAST_NAME_LENGTH) {
            throw new ValidationException("Invalid last name format");
        }
        if(renter.getEmail() == null || renter.getEmail().length() > EMAIL_LENGTH) {
            throw new ValidationException("Invalid email format");
        }
        if(renter.getPhone() == null || renter.getPhone().length() > PHONE_LENGTH) {
            throw new ValidationException("Invalid phone format");
        }
        if(renter.getGender() != 1 && renter.getGender() != 0) {
            throw new ValidationException("Invalid gender value");
        }
        if(renter.getDateBirth() == null || renter.getDateBirth().length() > DOB_LENGTH) {
            throw new ValidationException("Invalid date of birth");
        }
        if(renter.getReferralSource() == null || renter.getReferralSource().length() > REFERRAL_LENGTH) {
            throw new ValidationException("Invalid referral source");
        }
    }
}

