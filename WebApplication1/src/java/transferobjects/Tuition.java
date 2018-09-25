/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

/**
 * Tuition class represent a student's including paid and remainder tuition
 * information.
 *
 * @author Cynthia Sheng
 */
public class Tuition {

    private String studentID;
    private String paid;
    private String remainder;

    public Tuition() {
    }

    public Tuition(String studentID, String paid, String remainder) {
        setStudentID(studentID);
        setPaid(paid);
        setRemain(remainder);
    }

    /**
     * Get the student ID that is associated with the tuition
     *
     * @return studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Get paid tuition amount
     *
     * @return paid
     */

    public String getPaid() {
        return paid;
    }

    /**
     * Get remainder tuition amount
     *
     * @return remainder
     */

    public String getRemain() {
        return remainder;
    }

    /**
     * Set the student ID that is associated with the tuition
     *
     * @param studentID student ID
     */

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Set paid tuition amount
     *
     * @param paid paid tuition amount
     */
    public void setPaid(String paid) {
        this.paid = paid;
    }

    /**
     * Set remainder tuition amount
     *
     * @param remainder tuition remainder
     */

    public void setRemain(String remainder) {
        this.remainder = remainder;
    }
}
