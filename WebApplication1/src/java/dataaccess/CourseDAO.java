/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.Course;

/**
 * Course DAO provides database access functions for table "course". The
 * functions includes add course, get all courses, get course by ID, update
 * course, delete course.
 *
 * @author Shawn
 */
public interface CourseDAO {

    /**
     * Get all courses.
     *
     * @return a list of Course
     */
    List<Course> getAllCourses();

    /**
     * Add course.
     *
     * @param course to be added
     */
    void addCourse(Course course);

    /**
     * Get course by course ID
     *
     * @param code course ID
     *
     * @return course with the specified ID or null if not found
     */
    Course getCourseByCourseID(String code);

    /**
     * Update course name by course ID
     *
     * @param code to be updated
     *
     * @param name to be updated
     */
    void updateCourse(String code, String name);

    /**
     * delete course by course ID
     *
     * @param code course ID to be deleted
     */
    void deleteCourse(String code);
}
