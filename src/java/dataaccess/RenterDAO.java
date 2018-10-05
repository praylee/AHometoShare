/**
 * File: RenterDAO.java
 * Description:This is an abstract Data Access Object interface defines the standard operations to be performed.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;
import java.sql.Date;
import java.util.List;
import transferobjects.Renter;

public interface RenterDAO {
    List<Renter> getAllRenter();
    void addRenter(Renter renter);
    Renter getRenterByRenterId(int renterId);  
    void deleteRenter(int renterId);
    void updateRenter(String email, String passWord, String firstName, String lastName,String phone,int gender,Date dateBirth, Boolean isStudent,Boolean isEmployed,Boolean isSmoker,Date startDate,Date endDate,int availability, double lowPrice, double highPrice,String referralSource,Boolean hasCRCheck,int renterId);
    Renter getRenterByEmail(String email);
    boolean passwordCorrect(String email, String password);
}
