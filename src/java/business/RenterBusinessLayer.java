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
 * @author 29751
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
    
    
}

