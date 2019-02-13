/*
 * File: HostSession.java
 * Description:
 * Create: Oct 5,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import javax.servlet.http.HttpSession;
import transferobjects.Host;


public class HostSession {
    
    private HttpSession session;
    
    public HostSession(HttpSession session) {
        this.session = session;
    }
    
    public Object getAttribute(String key) {
        return this.session.getAttribute(key);
    }
    
    public void setAttribute(String key, Object value) {
        this.session.setAttribute(key, value);
    }
    
    public void removeAttribute(String key) {
        try {
           this.session.removeAttribute(key); 
        }
        catch(NullPointerException e) {
            System.out.println("Attribute '" + key + "' does not exist.");
        } 
    }
    
    public void endSession() {
        this.session.invalidate();
    }
    
    public void setSessionAttributes(Host host, boolean isLoggedIn) {
        this.session.setAttribute("isLoggedIn", isLoggedIn ? String.valueOf(isLoggedIn) : null);
        if(host != null) {
            this.session.setAttribute("userType", "host");
            this.session.setAttribute("hostId", host.getHostID());
            this.session.setAttribute("email", host.getEmail());
            this.session.setAttribute("firstname", host.getFirstName());
            this.session.setAttribute("lastname", host.getLastName());
            this.session.setAttribute("phone", host.getPhone());
            this.session.setAttribute("gender", host.getGender());
            this.session.setAttribute("dateBirth", host.getDateBirth());
            this.session.setAttribute("isRetired", host.getRetired());
            this.session.setAttribute("isPets", host.getPets());
            this.session.setAttribute("isSmoker", host.getSmoker());
            this.session.setAttribute("referralSource", host.getReferralSource());                                  
        }
        
    }
}