/*
 * File: RenterDAO.java
 * Description:
 * Create: Sep,30,2018
 * Author: Bits & Bytes Team-Christopher Labelle,Liangliang Du,Melissa Rajala,Zhan Shen,Xia Sheng,Bin Yang
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
/**
 *
 * @author Xia Sheng
 */
public interface RenterDAO {
    List<Renter> getAllRenter();
    void addRenter(Renter renter);
    Renter getRenterByRenterId(int renterId);  
    void deleteRenter(int renterId);
    void updateRenter(String email, String passWord, String firstName, String lastName,String phone,int gender,Date dateBirth, Boolean isStudent,Boolean isEmployed,Boolean isSmoker,Date startDate,Date endDate,int availability, double lowPrice, double highPrice,String referralSource,Boolean hasCRCheck,int renterId);
}
