/**
 * File: PropetyXResource.java
 * Description:This class describes attributes of Table PropertyXResource. This table is an associate table for resource and property
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package transferobjects;

public class PropertyXResource {
    private int propertyId;
    private int resourceId;
   
   public PropertyXResource(){
    }

    public PropertyXResource(int propertyId, int resourceId) {
    setPropertyId(propertyId);
    setResourceId(resourceId);   
    }

    public int getPropertyID() {
        return propertyId;
    }
     
    public int getResourceID() {
        return resourceId;
    }
    
    public void setPropertyId(int propertyId){
        this.propertyId=propertyId;
    }
        public void setResourceId(int resourceId){
        this.resourceId=resourceId;
    }
}
