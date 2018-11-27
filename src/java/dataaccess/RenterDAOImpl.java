/**
 * File: RenterDAOImpl.java
 * Description:This class implements interface RenterDAO. This class is responsible to get data from Table Renter.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Modified By: Melissa Rajala
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Renter;

public class RenterDAOImpl implements RenterDAO {

  //  private static final String GET_ALL_RENTER = "SELECT * FROM renter ORDER BY id";
    private static final String GET_ALL_RENTER = "SELECT "
            + "id,email, password, "
            + "first_name, last_name,phone, gender, date_of_birth, student, "
            + "employed, smoker, rent_start_date, rent_end_date,availability, "
            + "low_price, high_price, referral_source,criminality_check "
            + "FROM renter ORDER BY id";

    private static final String INSERT_RENTER = "INSERT INTO renter ("
            + "id,email, password, "
            + "first_name, last_name,phone, gender, date_of_birth, student, "
            + "employed, smoker, rent_start_date, rent_end_date,availability, "
            + "low_price, high_price, referral_source,criminality_check "
            + ") VALUES(?,?,AES_ENCRYPT(?,'secret'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    //Encrypt password - Bin
    private static final String GET_BY_RENTER_ID = "SELECT "
            + "id, email, password, "
            + "first_name, last_name,phone, gender, date_of_birth, student, "
            + "employed, smoker, rent_start_date, rent_end_date,availability, "
            + "low_price, high_price, referral_source,criminality_check "
            + "FROM renter WHERE id = ?";
    
    private static final String GET_BY_RENTER_EMAIL = "SELECT " 
            + "id,email, password, "
            + "first_name, last_name,phone, gender, date_of_birth, student, "
            + "employed, smoker, rent_start_date, rent_end_date,availability, "
            + "low_price, high_price, referral_source,criminality_check "
            + "FROM renter WHERE email = ?";
    
    private static final String DELETE_RENTER = "DELETE FROM renter WHERE id = ?";
    private static final String UPDATE_RENTER_DEFAULT = "UPDATE renter SET "
            + "email = ?, password= ?, "
            + "first_name= ?, last_name= ?,phone= ?, gender= ?, date_of_birth= ?, student= ?, "
            + "employed= ?, smoker= ?, rent_start_date= ?, rent_end_date= ?,availability= ?, "
            + "low_price= ?, high_price= ?, referral_source= ?,criminality_check = ? "
            + "WHERE id= ?";
    
    private static final String UPDATE_RENTER_EDIT_PROFILE = "UPDATE renter SET " // updated by Christohper Labelle
            + "first_name= ?, last_name= ?,phone= ?, gender= ?, date_of_birth= ?, student= ?, "
            + "employed= ?, smoker= ? "
            + "WHERE id= ?";
    
    private static final String UPDATE_RENTER_PASSWORD = "UPDATE renter SET "
            + "password= AES_ENCRYPT(?,'secret') "
            + "WHERE id= ?";
    
    private static final String GET_RENTER_BY_EMAIL = "SELECT " // added by Christopher Labelle
            + "id,email, password, "
            + "first_name, last_name,phone, gender, date_of_birth, student, "
            + "employed, smoker, rent_start_date, rent_end_date,availability, "
            + "low_price, high_price, referral_source,criminality_check "
            + "FROM renter WHERE email = ?";
    
    private static final String PASSWORD_CORRECT = "SELECT id FROM renter WHERE email = ? AND password = AES_ENCRYPT(?,'secret')";      //Validate encrypted password - Bin

    @Override
    public List<Renter> getAllRenter() {      
        List<Renter> renters = Collections.EMPTY_LIST;
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_RENTER);
                ResultSet rs = pstmt.executeQuery();) {
            renters = new ArrayList<>(400);
            while (rs.next()) {
                Renter renter = new Renter();
                renter.setRenterId(rs.getInt("id"));
                renter.setEmail(rs.getString("email"));
                renter.setPassWord(rs.getString("password"));
                renter.setFirstName(rs.getString("first_name"));
                renter.setLastName(rs.getString("last_name"));
                renter.setPhone(rs.getString("phone"));
                renter.setGender(rs.getInt("gender"));
                renter.setDOB(rs.getString("date_of_birth"));
                renter.setIsStudent(rs.getBoolean("student"));
                renter.setIsEmployed(rs.getBoolean("employed"));
                renter.setIsSmoker(rs.getBoolean("smoker"));
                renter.setStartDate(rs.getDate("rent_start_date"));
                renter.setEndDate(rs.getDate("rent_end_date"));
                renter.setAvailability(rs.getInt("availability"));
                renter.setLowPrice(rs.getInt("low_price"));
                renter.setHighPrice(rs.getInt("high_price"));
                renter.setReferralSource(rs.getString("referral_source"));
                renter.setHasCRCheck(rs.getBoolean("criminality_check"));
                renters.add(renter);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return renters;
    }

    @Override
    public void addRenter(Renter renter) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_RENTER);) {
            pstmt.setInt(1, renter.getRenterID());
            pstmt.setString(2, renter.getEmail());
            pstmt.setString(3, renter.getPassWord());
            pstmt.setString(4, renter.getFirstName());
            pstmt.setString(5, renter.getLastName());
            pstmt.setString(6, renter.getPhone());
            pstmt.setInt(7, renter.getGender());
            pstmt.setString(8, renter.getDateBirth());
            pstmt.setBoolean(9, renter.getIsStudent());
            pstmt.setBoolean(10, renter.getIsEmployed());
            pstmt.setBoolean(11, renter.getIsSmoker());
            pstmt.setDate(12, renter.getStartDate());
            pstmt.setDate(13, renter.getEndDate());
            pstmt.setInt(14, renter.getAvailability());
            pstmt.setDouble(15, renter.getLowPrice());
            pstmt.setDouble(16, renter.getHighPrice());
            pstmt.setString(17, renter.getReferralSource());
            pstmt.setBoolean(18, renter.getHasCRCheck());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** Modified By: Melissa Rajala
     *      Moved ResultSet out of the try-with-resources to correct location 
     */
    @Override
    public Renter getRenterByRenterId(int renterId) {

        Renter renter = new Renter();
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_RENTER_ID);) {
            pstmt.setInt(1, renterId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                renter.setRenterId(rs.getInt("id"));
                renter.setEmail(rs.getString("email"));
                renter.setPassWord(rs.getString("password"));
                renter.setFirstName(rs.getString("first_name"));
                renter.setLastName(rs.getString("last_name"));
                renter.setPhone(rs.getString("phone"));
                renter.setGender(rs.getInt("gender"));
                renter.setDOB(rs.getString("date_of_birth"));
                renter.setIsStudent(rs.getBoolean("student"));
                renter.setIsEmployed(rs.getBoolean("employed"));
                renter.setIsSmoker(rs.getBoolean("smoker"));
                renter.setStartDate(rs.getDate("rent_start_date"));
                renter.setEndDate(rs.getDate("rent_end_date"));
                renter.setAvailability(rs.getInt("availability"));
                renter.setLowPrice(rs.getInt("low_price"));
                renter.setHighPrice(rs.getInt("high_price"));
                renter.setReferralSource(rs.getString("referral_source"));
                renter.setHasCRCheck(rs.getBoolean("criminality_check"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return renter;
    }
    

    @Override
    public void deleteRenter(int renterId) {

        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_RENTER);) {
            pstmt.setInt(1, renterId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateRenter(String email, String passWord, String firstName, String lastName, String phone, int gender, String dateBirth, Boolean isStudent, Boolean isEmployed, Boolean isSmoker, Date startDate, Date endDate, int availability, double lowPrice, double highPrice, String referralSource, Boolean hasCRCheck, int renterId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_RENTER_DEFAULT);) {

            pstmt.setString(1, email);
            pstmt.setString(2, passWord);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, phone);
            pstmt.setInt(6, gender);
            pstmt.setString(7, dateBirth);
            pstmt.setBoolean(8, isStudent);
            pstmt.setBoolean(9, isEmployed);
            pstmt.setBoolean(10, isSmoker);
            pstmt.setDate(11, startDate);
            pstmt.setDate(12, endDate);
            pstmt.setInt(13, availability);
            pstmt.setDouble(14, lowPrice);
            pstmt.setDouble(15, highPrice);
            pstmt.setString(16, referralSource);
            pstmt.setBoolean(17, hasCRCheck);
            pstmt.setInt(18, renterId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override // added by Christopher Labelle
    public void updateRenter(String firstName, String lastName, String phone, int gender, String dateBirth, Boolean isStudent, Boolean isEmployed, Boolean isSmoker, int renterId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_RENTER_EDIT_PROFILE);) {

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setInt(4, gender);
            pstmt.setString(5, dateBirth);
            pstmt.setBoolean(6, isStudent);
            pstmt.setBoolean(7, isEmployed);
            pstmt.setBoolean(8, isSmoker);
            pstmt.setInt(9, renterId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateRenter(String passWord, int renterId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_RENTER_PASSWORD);) {

            pstmt.setString(1, passWord);
            pstmt.setInt(2, renterId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Renter getRenterByEmail(String email) { //added by Christopher Labelle
        
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_RENTER_BY_EMAIL);) {
            
            Renter renter = new Renter();
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if(rs.first()) {
                renter.setRenterId(rs.getInt("id"));
                renter.setEmail(rs.getString("email"));
                renter.setPassWord(rs.getString("password"));
                renter.setFirstName(rs.getString("first_name"));
                renter.setLastName(rs.getString("last_name"));
                renter.setPhone(rs.getString("phone"));
                renter.setGender(rs.getInt("gender"));
                renter.setDOB(rs.getString("date_of_birth"));
                renter.setIsStudent(rs.getBoolean("student"));
                renter.setIsEmployed(rs.getBoolean("employed"));
                renter.setIsSmoker(rs.getBoolean("smoker"));
                renter.setStartDate(rs.getDate("rent_start_date"));
                renter.setEndDate(rs.getDate("rent_end_date"));
                renter.setAvailability(rs.getInt("availability"));
                renter.setLowPrice(rs.getInt("low_price"));
                renter.setHighPrice(rs.getInt("high_price"));
                renter.setReferralSource(rs.getString("referral_source"));
                renter.setHasCRCheck(rs.getBoolean("criminality_check"));
            }
            else {
                renter = null;
            }
            try {rs.close();}
            catch(SQLException ex) {}
            return renter;
        }
        catch(SQLException e) {
             Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, e);
             return null;
        }
    }
    
    @Override
    public boolean passwordCorrect(String email, String password) { // added by Christopher Labelle
        try (Connection con = new DataSource().createConnection();
         PreparedStatement pstmt = con.prepareStatement(PASSWORD_CORRECT);) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(!rs.first())
                return false;      
            try {rs.close();}
            catch(SQLException ex) {}
            return true;
        }
        catch(SQLException e) {
             Logger.getLogger(RenterDAOImpl.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
    }
}
