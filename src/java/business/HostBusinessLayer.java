/*
 * File: HostBusinessLayer.java
 * Description: transfer function between Java and database
 * Create: Sep,30,2018
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
import transferobjects.Host;

/**
 *
 * @author 29751
 */
public class HostBusinessLayer {
    
    private HostDAO hostDAO = null;
    
    public HostBusinessLayer() {
        hostDAO = new HostDAOImpl();
    }
      
    public List<Host> getAllHost(){
        return hostDAO.getAllHost();
    }
    public void addHost(Host host) throws ValidationException {
        try {
            validateFields(host);
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
    
    public void deleteHost(int hostId){
        hostDAO.deleteHost(hostId);
    }
    public void updateHost( String email, String passWord, String firstName, String lastName,String phone,int gender,String dateBirth, Boolean retired,Boolean pets,Boolean smoker,String referralSource,int hostId){
        hostDAO.updateHost(email, passWord, firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
    }
    
    public boolean passwordCorrect(String email, String password){
        return hostDAO.passwordCorrect(email, password);
    }

    private void validateFields(Host host) throws ValidationException {
        // if email doesn't match [\w\d\._\-!#$%&'*+/=?^_`{|}~]+@[\w\d\.\[\]]+  then throw exception
        // if password doesn't match whatever we need it to     then throw exception
        // if price range isn't a number, or is a negative number   then throw exception
    }
}
