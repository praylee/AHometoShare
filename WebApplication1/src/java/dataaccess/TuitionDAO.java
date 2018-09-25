/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Tuition;

/**
 * Database access object for tuition table. It provides functions including add
 * tuition, get all tuitions, get tuition by ID, update tuition, delete tuition
 * by student ID.
 *
 * @author Cynthia Sheng
 */
public interface TuitionDAO {
	/**
	 * Get all tuitions.
	 * @return a list of Tuition
	 */
    List<Tuition> getAllTuition();
	/**
	 * Add tuition
	 * @param tuition to be added
	 */
    void addTuition(Tuition tuition);
/**
	 * Get tuition by studentID
	 * @param studentID student ID
	 * @return tuition with the specified ID or null if not found
	 */
    Tuition getTuitionByStudentID(String studentID);
/**
	 * deleted tuition by studentID
	 * @param studentID student ID to be deleted
	 */
    void deleteTuition(String studentID);
/**
	 * update tuition by ID
	 * 
	 * @param studentID to be updated
         * @param paid to be updated
         * @param remain to be updated

	 */
    void updateTuition(String studentID, String paid, String remain);
}
