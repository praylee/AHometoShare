/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import transferobjects.Renter;

/**
 *
 * @author chris
 */
public class RenterSession {
    
    private HttpSession session;
    
    public RenterSession(HttpSession session) {
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
    
    public void setSessionAttributes(Renter renter, boolean isLoggedIn) {
        this.session.setAttribute("isLoggedIn", isLoggedIn ? String.valueOf(isLoggedIn) : null);
        if(renter != null) {
            this.session.setAttribute("userType", "renter");
            this.session.setAttribute("renterId", renter.getRenterID());
            this.session.setAttribute("email", renter.getEmail());
            this.session.setAttribute("firstName", renter.getFirstName());
            this.session.setAttribute("lastName", renter.getLastName());
            this.session.setAttribute("phone", renter.getPhone());
            this.session.setAttribute("gender", renter.getGender());
            this.session.setAttribute("dateBirth", renter.getDateBirth());
            this.session.setAttribute("isStudent", renter.getIsStudent());
            this.session.setAttribute("isEmployed", renter.getIsEmployed());
            this.session.setAttribute("isSmoker", renter.getIsSmoker());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            this.session.setAttribute("startDate", formatter.format(renter.getStartDate()));
            this.session.setAttribute("endDate", formatter.format(renter.getEndDate()));
            this.session.setAttribute("lowPrice", renter.getLowPrice());
            this.session.setAttribute("highPrice", renter.getHighPrice());
            this.session.setAttribute("referralSource", renter.getReferralSource());
            this.session.setAttribute("hasCRCheck", renter.getHasCRCheck());
        }
        
    }
}
