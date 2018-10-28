/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.servlet.http.HttpSession;
import transferobjects.Host;

/**
 *
 * @author chris
 */
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
            this.session.setAttribute("firstName", host.getFirstName());
            this.session.setAttribute("lastName", host.getLastName());
            this.session.setAttribute("phone", host.getPhone());
            this.session.setAttribute("gender", host.getGender());
            this.session.setAttribute("dateBirth", host.getDateBirth());
            this.session.setAttribute("isRetired", host.getRetired());
            this.session.setAttribute("hasPets", host.getPets());
            this.session.setAttribute("isSmoker", host.getSmoker());
            this.session.setAttribute("referralSource", host.getReferralSource());                                  
        }
        
    }
}
