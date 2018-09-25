/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Registry;

/**
 * Registry DAO provides database access functions for table "registry". The
 * functions includes add registry, get all registries, get registry by ID,
 * update registry, delete registry.
 *
 * @author Cynthia Sheng
 */
public interface RegistryDAO {

    /**
     * Get all registries.
     *
     * @return a list of Registry
     */
    List<Registry> getAllRegistry();

    /**
     * Add registry.
     *
     * @param registry to be added
     */

    void addRegistry(Registry registry);

    /**
     * Get Registry by studentID
     *
     * @param studentID student ID
     *
     * @return Registry with the specified ID or null if not found
     */
    Registry getRegistryByStudentID(String studentID);

    /**
     * Update Registry by studentID
     *
     * @param studentID to be updated
     *
     * @param courseID to be updated
     *
     * @param term to be updated
     *
     * @param year to be updated
     */
    void updateRegistry(String studentID, String courseID, String term, String year);

    /**
     * delete registry by student ID and course ID
     *
     * @param studentID student ID to be deleted
     */
    void deleteRegistry(String studentID);
}
