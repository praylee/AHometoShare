/**
 * File: PropertyPicture.java
 * Description:This class describes attributes of Table PropertyXResource. This table is an associate table for resource and property
 * Create: Oct,28,2018
 * Author: LiangliangDu
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package transferobjects;

import java.sql.Blob;


public class PropertyPicture {
    private int pictureId;
    private int propertyId;
    private Blob picture;
   
   public PropertyPicture(){
    }

    public PropertyPicture(int pictureId,int propertyId, Blob picture) {
    setPictureId(pictureId);
    setPropertyId(propertyId);
    setPicture(picture);   
    }

    public int getPictureID() {
        return pictureId;
    }
    public int getPropertyID() {
        return propertyId;
    }
     
    public Blob getPicture() {
        return picture;
    }
    
    public void setPictureId(int pictureId){
        this.pictureId=pictureId;
    }
    public void setPropertyId(int propertyId){
        this.propertyId=propertyId;
    }
    
    public void setPicture(Blob picture){
        this.picture=picture;
    }
}
