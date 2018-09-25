/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

/**
 * Students class provide information about student's name, date of birth,
 * enrolled date.
 *
 * @author Cynthia Sheng
 */
public class Students {

    private String studentID;
    private String firstName;
    private String lastName;
    private String birth;
    private String enroll;

    public Students() {
    }

    public Students(String studentID, String firstName, String lastName, String birth, String enroll) {
        setStuID(studentID);
        setFirstName(firstName);
        setLastName(lastName);
        setBirth(birth);
        setEnroll(enroll);
    }

    /**
     * Get student ID
     *
     * @return studentID
     */
    public String getStuID() {
        return studentID;
    }

    /**
     * Get student first name
     *
     * @return firstName
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Get student last name
     *
     * @return lastName
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Get student date of birth
     *
     * @return birth
     */

    public String getBirth() {
        return birth;
    }

    /**
     * Get student enrollment date
     *
     * @return enroll
     */

    public String getEnroll() {
        return enroll;
    }

    /**
     * Set Student ID
     *
     * @param studentID student ID
     */
    public void setStuID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Set student first name
     *
     * @param firstName student's first name
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set student last name
     *
     * @param lastName student's last name
     */ 

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set student birth day
     *
     * @param birth student date of birth
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * Set student enrolled date
     *
     * @param enroll student enrolled date
     */

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }
}
