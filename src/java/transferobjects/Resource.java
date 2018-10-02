/*
 * File: Resource.java
 * Description:
 * Create: Sep,30,2018
 * Author: Bits & Bytes Team-Christopher Labelle,Liangliang Du,Melissa Rajala,Zhan Shen,Xia Sheng,Bin Yang
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package transferobjects;

/**
 *
 * @author Xia Sheng
 */
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
