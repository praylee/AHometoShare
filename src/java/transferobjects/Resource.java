/**
 * File: Resource.java
 * Description:This class describes attributes of Table Resource. This table records product’s general information
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package transferobjects;


public class Resource {
    private int id;
    private String type;
    
   public Resource(){
    }

    public Resource(int id, String type) {
    setResourceId(id);
    setType(type);
    }

    public int getResourceID() {
        return id;
    }
    public String getType(){
        return type;
    }

    public void setResourceId(int id){
        this.id=id;
    }
    
    public void setType(String type){
        this.type=type;
    }
}
