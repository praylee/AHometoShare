/**
 * File: ResourceDAO.java
 * Description:This is an abstract Data Access Object interface defines the standard operations to be performed.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;
import java.util.List;
import transferobjects.Resource;

public interface ResourceDAO {
     List<Resource> getAllResource();
    void addResource(Resource resource);
    Resource getResourceByResourceId(int resourceId);  
    void deleteReource(int resourceId);
    void updateResource( String type, int resourceId);
}
