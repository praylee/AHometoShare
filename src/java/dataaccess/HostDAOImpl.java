/*
 * File: HostDAOImpl.java
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
import transferobjects.Host;
/**
 *
 * @author Xia Sheng
 */
public class HostDAOImpl implements HostDAO{

    private static final String GET_ALL_HOST = "SELECT"
            +"host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            +"pets,smoker, referral_source"
            +"FROM host ORDER BY host_id";
    
    private static final String INSERT_HOST = "INSERT INTO host ("
            +"host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            +"pets,smoker, referral_source"
            +") VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_BY_HOST_ID = "SELECT"
            +"host_id,email, password, first_name, last_name,phone, gender, date_of_birth, retired, "
            +"pets,smoker, referral_source"
            +"FROM host WHERE host_id = ?";
    private static final String DELETE_HOST= "DELETE FROM host WHERE host_id = ?";
    private static final String UPDATE_HOST = "UPDATE host SET "
            +"email= ?, password= ?, first_name= ?, last_name= ?,"
            +"phone = ?, gender= ?, date_of_birth= ?, retired= ?, "
            +"pets= ?,smoker= ?, referral_source= ?"
                    +"WHERE host_id= ?";
    
   @Override
    public List<Host> getAllHost(){
        List<Host> hosts= Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_ALL_HOST);
            rs = pstmt.executeQuery();
            hosts = new ArrayList<>(400);
            while(rs.next()){
                Host host = new Host();
                host.setHostId(rs.getInt("host_id"));
                host.setEmail(rs.getString("email"));
                host.setPassWord(rs.getString("password"));
                host.setFirstName(rs.getString("first_name"));
                host.setLastName(rs.getString("last_name"));
                host.setPhone(rs.getString("phone"));
                host.setGender(rs.getInt("gender"));
                host.setDOB(rs.getDate("date_of_birth"));
                host.setRetired(rs.getBoolean("retired"));
                host.setPets(rs.getBoolean("pets"));   
                host.setSmoker(rs.getBoolean("smoker"));
                host.setReferralSource(rs.getString("referral_source"));
                hosts.add(host);
            }
        }catch(SQLException ex){
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            try{
            if(rs !=null){
                rs.close();
            }
          }catch(SQLException ex){
                    System.out.println(ex.getMessage());
          }
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }
        return hosts;
    }
    @Override
    public void addHost(Host host){
        try{
            Connection con=new DataSource().createConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_HOST);
            pstmt.setInt(1,host.getHostID());
            pstmt.setString(2,host.getEmail());
            pstmt.setString(3,host.getPassWord());           
            pstmt.setString(4,host.getFirstName());
            pstmt.setString(5,host.getLastName());
            pstmt.setString(6,host.getPhone());
            pstmt.setInt(7,host.getGender());
            pstmt.setDate(8,host.getDateBirth());
            pstmt.setBoolean(9,host.getRetired());
            pstmt.setBoolean(10,host.getPets());
            pstmt.setBoolean(11,host.getSmoker());
            pstmt.setString(12,host.getReferralSource());
            pstmt.executeUpdate();         
        }catch(SQLException ex){
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Host getHostByHostId(int hostId){
      
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Host host= new Host();
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_BY_HOST_ID);
            pstmt.setInt(1, hostId);
            //pstmt.executeUpdate();
           
            rs = pstmt.executeQuery();
            
            if(rs.next()){              
                host.setHostId(rs.getInt("host_id"));
                host.setEmail(rs.getString("email"));
                host.setPassWord(rs.getString("password"));
                host.setFirstName(rs.getString("first_name"));
                host.setLastName(rs.getString("last_name"));
                host.setPhone(rs.getString("phone"));
                host.setGender(rs.getInt("gender"));
                host.setDOB(rs.getDate("date_of_birth"));
                host.setRetired(rs.getBoolean("retired"));
                host.setPets(rs.getBoolean("ptes"));   
                host.setSmoker(rs.getBoolean("smoker"));
                host.setReferralSource(rs.getString("referral_source"));
                
            } 
        }catch(SQLException ex){
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            try{
            if(rs !=null){
                rs.close();
            }
          }catch(SQLException ex){
                    System.out.println(ex.getMessage());
          }
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }
        return host;
    }
    
    @Override
     public void deleteHost(int hostId){
         
         Connection con = null;
        PreparedStatement pstmt = null;
      
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(DELETE_HOST);
            pstmt.setInt(1, hostId);
            pstmt.executeUpdate();
           
        }catch(SQLException ex){
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
           
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }    
     }
     
     @Override
      public void updateHost( String email, String passWord, String firstName, String lastName,String phone,int gender,Date dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource,int hostId){
            Connection con = null;
        PreparedStatement pstmt = null;
      
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(UPDATE_HOST);   
            pstmt.setString(1,email);
            pstmt.setString(2,passWord);           
            pstmt.setString(3,firstName);
            pstmt.setString(4,lastName);
            pstmt.setString(5,phone);
            pstmt.setInt(6,gender);
            pstmt.setDate(7,dateBirth);
            pstmt.setBoolean(8,retired);
            pstmt.setBoolean(9,pets);
            pstmt.setBoolean(10,smoker);
            pstmt.setString(11,referralSource);    
            pstmt.setInt(12,hostId);
            pstmt.executeUpdate();
           
        }catch(SQLException ex){
            Logger.getLogger(HostDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
           
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }
        
      }
    
}
