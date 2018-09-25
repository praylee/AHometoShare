/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Students;

/**
 * Database access object for Student table. It provides functions including add
 * student, get all students, get student by ID, update student, delete student.
 *
 * @author Cynthia Sheng
 */
public interface StudentsDAO {
	/**
	 * Get all students.
	 * 
	 * @return a list of Students
	 */
    List<Students> getAllStudents();
	/**
	 * add student.
	 * @param student to be added
	 */
    void addStudents(Students student);
	/**
	 * Get student by ID
	 * @param studentID student ID
	 * @return student with the specified ID or null if not found
	 */
    Students getStudentByStudentID(String studentID);
	/**
	 * deleted student by ID
	 * @param studentID student ID to be deleted
	 */
    void deleteStudent(String studentID);
	
	/**
	 * update student by ID
	 * 
	 * @param studentID to be updated
         * @param firstName to be updated
         * @param lastName to be updated
         * @param birth to be updated
         * @param enroll to be updated
	 */
    void updateStudent(String studentID, String firstName, String lastName, String birth, String enroll);
}
