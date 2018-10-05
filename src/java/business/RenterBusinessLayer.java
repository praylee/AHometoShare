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
import transferobjects.Renter;

/**
 *
 * @author Chris
 */
public class RenterBusinessLayer {
 
    private RenterDAO renterDAO = null;
    
    public RenterBusinessLayer() {
        renterDAO = new RenterDAOImpl();
    }
    
    
    public Renter getRenterByRenterId(int renterId) {
        return renterDAO.getRenterByRenterId(renterId);
    }
    
    public Renter getRenterByRenterUname(String username) {
        return renterDAO.getRenterByRenterUname(username);
    }
    
    
    RenterDAO renterDAO;
    
    public RenterBusinessLayer() {
        renterDAO = new RenterDAOImpl();
    }
    
    public void addRenter(Renter renter) throws ValidationException {
        try {
            validateFields(renter);
            renterDAO.addRenter(renter);
        }
        catch(ValidationException e) {
            throw e;
        }
    }   
    
    public Renter getRenterByEmail(String email) {
        return renterDAO.getRenterByEmail(email);
    }
    
    public Renter getRenterByRenterId(int id) {
        return renterDAO.getRenterByRenterId(id);
    }
    
    public boolean renterExists(String email) {
        boolean exists = true;
        if(renterDAO.getRenterByEmail(email) == null) {
            exists = false;
        }
        return exists;
    }
    
    public boolean passwordCorrect(String email, String password) {
        boolean correct = false;
        if(renterDAO.passwordCorrect(email, password)) {
            correct = true;
        }
        return correct;
    }
    
    private void validateFields(Renter renter) throws ValidationException {
        // if email doesn't match [\w\d\._\-!#$%&'*+/=?^_`{|}~]+@[\w\d\.\[\]]+  then throw exception
        // if password doesn't match whatever we need it to     then throw exception
        // if price range isn't a number, or is a negative number   then throw exception
    }
}

