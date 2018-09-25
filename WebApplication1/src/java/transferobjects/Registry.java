/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

/**
 * Registry represents the relationship between students and registered courses
 *
 * @author Cynthia Sheng
 */
public class Registry {

    private String studentID;
    private String courseID;
    private String term;
    private String year;

    public Registry() {
    }

    public Registry(String studentID, String courseID, String term, String year) {
        setStID(studentID);
        setCourseID(courseID);
        setTerm(term);
        setYear(year);
    }

    /**
     * Get student ID
     *
     * @return studentID
     */
    public String getStID() {
        return studentID;
    }

    /**
     * Get course code
     *
     * @return courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * Get term student registered
     *
     * @return term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Get the year student registered
     *
     * @return year
     */
    public String getYear() {
        return year;
    }

    /**
     * Set Student ID
     *
     * @param studentID student ID
     */
    public void setStID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Set course code
     *
     * @param courseID course code
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * Set term student registered
     *
     * @param term registered term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Set the year student registered
     *
     * @param year registered year
     */
    public void setYear(String year) {
        this.year = year;
    }
}
