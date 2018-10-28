/**
 * File: HostDAOImpl.java
 * Description:This class implements interface HostDAO. This class is responsible to get data from Table Host.
 * Create: Sep,30,2018
 * Author: Xia Sheng
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Host;

public class HostDAOImpl implements HostDAO {

    private static final String GET_ALL_HOST = "SELECT "
            + "host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            + "pets,smoker, referral_source "
            + "FROM host ORDER BY host_id";

    private static final String INSERT_HOST = "INSERT INTO host ("
            + "host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            + "pets,smoker, referral_source "
            + ") VALUES(?,?,AES_ENCRYPT(?,'secret'),?,?,?,?,?,?,?,?,?)";          //Encrypt password - Bin
    private static final String GET_BY_HOST_ID = "SELECT "
            + "host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            + "pets,smoker, referral_source "
            + "FROM host WHERE host_id = ?";
    private static final String GET_BY_HOST_EMAIL = "SELECT "
            + "host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            + "pets,smoker, referral_source "
            + "FROM host WHERE email = ?";
    private static final String DELETE_HOST = "DELETE FROM host WHERE host_id = ?";
    private static final String UPDATE_HOST = "UPDATE host SET "
            + "email= ?, password= ?, first_name= ?, last_name= ?,"
            + "phone = ?, gender= ?, date_of_birth= ?, retired= ?, "
            + "pets= ?,smoker= ?, referral_source= ?"
            + "WHERE host_id= ?";
    private static final String UPDATE_HOST_EDIT_FILE = "UPDATE host SET "
            + "first_name= ?, last_name= ?,"
            + "phone = ?, gender= ?, date_of_birth= ?, retired= ?, "
            + "pets= ?,smoker= ?,referral_source= ?"
            + "WHERE host_id= ?";
    private static final String UPDATE_HOST_PASSWORD = "UPDATE host SET " //Modified by Liangliang
            + "password= AES_ENCRYPT(?,'secret') "
            + "WHERE host_id = ?";
    
    private static final String PASSWORD_CORRECT = "SELECT host_id FROM host WHERE email = ? AND password = AES_ENCRYPT(?,'secret')";      //Validate encrypted password - Bin

    @Override
    public List<Host> getAllHost() {
        List<Host> hosts = Collections.EMPTY_LIST;
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_HOST);
                ResultSet rs = pstmt.executeQuery();) {

            hosts = new ArrayList<>(400);
            while (rs.next()) {
                Host host = new Host();
                host.setHostId(rs.getInt("host_id"));
                host.setEmail(rs.getString("email"));
                host.setPassWord(rs.getString("password"));
                host.setFirstName(rs.getString("first_name"));
                host.setLastName(rs.getString("last_name"));
                host.setPhone(rs.getString("phone"));
                host.setGender(rs.getInt("gender"));
                host.setDOB(rs.getString("date_of_birth"));
                host.setRetired(rs.getBoolean("retired"));
                host.setPets(rs.getBoolean("pets"));
                host.setSmoker(rs.getBoolean("smoker"));
                host.setReferralSource(rs.getString("referral_source"));
                hosts.add(host);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hosts;
    }

    @Override
    public void addHost(Host host) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_HOST);) {
            pstmt.setInt(1, host.getHostID());
            pstmt.setString(2, host.getEmail());
            pstmt.setString(3, host.getPassWord());
            pstmt.setString(4, host.getFirstName());
            pstmt.setString(5, host.getLastName());
            pstmt.setString(6, host.getPhone());
            pstmt.setInt(7, host.getGender());
            pstmt.setString(8, host.getDateBirth());
            pstmt.setBoolean(9, host.getRetired());
            pstmt.setBoolean(10, host.getPets());
            pstmt.setBoolean(11, host.getSmoker());
            pstmt.setString(12, host.getReferralSource());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Host getHostByHostId(int hostId) {
        Host host = new Host();
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_HOST_ID);
                ResultSet rs = pstmt.executeQuery();) {
            if (rs.next()) {
                host.setHostId(rs.getInt("host_id"));
                host.setEmail(rs.getString("email"));
                host.setPassWord(rs.getString("password"));
                host.setFirstName(rs.getString("first_name"));
                host.setLastName(rs.getString("last_name"));
                host.setPhone(rs.getString("phone"));
                host.setGender(rs.getInt("gender"));
                host.setDOB(rs.getString("date_of_birth"));
                host.setRetired(rs.getBoolean("retired"));
                host.setPets(rs.getBoolean("ptes"));
                host.setSmoker(rs.getBoolean("smoker"));
                host.setReferralSource(rs.getString("referral_source"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return host;
    }
    
    @Override
    public Host getHostByEmail(String email) {//added by Liangliang 
     
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_HOST_EMAIL);) {
            
            Host host = new Host();
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if(rs.first()) {
                host.setHostId(rs.getInt("host_id"));
                host.setEmail(rs.getString("email"));
                host.setPassWord(rs.getString("password"));
                host.setFirstName(rs.getString("first_name"));
                host.setLastName(rs.getString("last_name"));
                host.setPhone(rs.getString("phone"));
                host.setGender(rs.getInt("gender"));
                host.setDOB(rs.getString("date_of_birth"));
                host.setRetired(rs.getBoolean("retired"));
                host.setPets(rs.getBoolean("pets"));
                host.setSmoker(rs.getBoolean("smoker"));
                host.setReferralSource(rs.getString("referral_source"));

            }
            else {
                host = null;
            }
            try {rs.close();}
            catch(SQLException ex) {}
            return host;
        }
        catch(SQLException e) {
             Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, e);
             return null;
        }
    }

    @Override
    public void deleteHost(int hostId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_HOST);) {
            pstmt.setInt(1, hostId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateHost(String email, String passWord, String firstName, String lastName, String phone, int gender, String dateBirth, Boolean retired, Boolean pets, Boolean smoker, String referralSource, int hostId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_HOST);) {
            pstmt.setString(1, email);
            pstmt.setString(2, passWord);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, phone);
            pstmt.setInt(6, gender);
            pstmt.setString(7, dateBirth);
            pstmt.setBoolean(8, retired);
            pstmt.setBoolean(9, pets);
            pstmt.setBoolean(10, smoker);
            pstmt.setString(11, referralSource);
            pstmt.setInt(12, hostId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateHost(String firstName, String lastName,String phone,int gender,String dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource,int hostId){
    try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_HOST_EDIT_FILE);) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setInt(4, gender);
            pstmt.setString(5, dateBirth);
            pstmt.setBoolean(6, retired);
            pstmt.setBoolean(7, pets);
            pstmt.setBoolean(8, smoker);
            pstmt.setString(9, referralSource);
            pstmt.setInt(10, hostId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    @Override
    public void updateHost(String passWord, int hostId){
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_HOST_PASSWORD);) {

            pstmt.setString(1, passWord);
            pstmt.setInt(2, hostId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public boolean passwordCorrect(String email, String password) { // added by Bin
        try (Connection con = new DataSource().createConnection();
         PreparedStatement pstmt = con.prepareStatement(PASSWORD_CORRECT);) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            boolean isCorrect = rs.first();
            try {rs.close();}
            catch(SQLException ex) {}
            return isCorrect;
        }
        catch(SQLException e) {
             Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, e);
             return false;
        }
    }

   
}
