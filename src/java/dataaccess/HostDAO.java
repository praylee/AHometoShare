/*
 * File: HostDAO.java
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
import transferobjects.Host;
/**
 *
 * @author 29751
 */
public interface HostDAO {
   List<Host> getAllHost();
    void addHost(Host host);
    Host getHostByHostId(int hostId);  
    void deleteHost(int hostId);
    void updateHost( String email, String passWord, String firstName, String lastName,String phone,int gender,Date dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource,int hostId);
}
