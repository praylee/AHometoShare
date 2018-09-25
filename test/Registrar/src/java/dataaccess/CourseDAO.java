/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Course;

/**
 *
 * @author Shawn
 */
public interface CourseDAO {
	List<Course> getAllCourses();
	void addCourse(Course author);
	//List<Course> getAuthorsByFirstName(String firstName);
	//Course getAuthorByAuthorId(Integer authorID);
	//void updateAuthor(Course author);
	//void deleteAuthor(Course author);
}
