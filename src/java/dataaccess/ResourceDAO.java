/*
 * File: ResourceDAO.java
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
import java.util.List;
import transferobjects.Resource;
/**
 *
 * @author 29751
 */
public interface ResourceDAO {
     List<Resource> getAllResource();
    void addResource(Resource resource);
    Resource getResourceByResourceId(int resourceId);  
    void deleteReource(int resourceId);
    void updateResource( String type, int resourceId);
}
