/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.TuitionDAO;
import dataaccess.TuitionDAOImpl;
import java.util.List;
import transferobjects.Tuition;

/**
 *
 * @author Cynthia Sheng
 */
public class TuitionLogic {
    private static final int STUDENT_NUM_MAX_LENGTH = 11;
    private static final int PAID_MAX_LENGTH = 17;
    private static final int REMAINDER_MAX_LENGTH = 17;
    
     private TuitionDAO tuitionDAO = null;
    /**
     * Constructor to create a Tuition Logic
     */
    public TuitionLogic() {
        tuitionDAO = new TuitionDAOImpl();
    }
    /**
     * Get all tuition for all the students
     * 
     * @return a list of Tuition
     */
    public List<Tuition> getAllTuition() {
        return tuitionDAO.getAllTuition();
    }
/**
     * Add corresponding tuition.
     * 
     * @param tuition tuition information of the student
     * @throws ValidationException if the Student object failed validation.
     */

    public void addTuition(Tuition tuition) throws ValidationException {
        cleanTuition(tuition);
        validateTuition(tuition);
        tuitionDAO.addTuition(tuition);
    }
     public Tuition getTuitionByStudentID(String studentID){
        return tuitionDAO.getTuitionByStudentID(studentID);
    }
     
     public void deleteTuition(String studentID){
        tuitionDAO.deleteTuition(studentID);
    }
    
    public void updateTuition(String studentID, String paid,String remain){
        tuitionDAO.updateTuition(studentID, paid,remain);
    }
    private void cleanTuition(Tuition tuition) {
        if (tuition.getStudentID() != null) {
            tuition.setStudentID(tuition.getStudentID().trim());
        }
        if (tuition.getPaid() != null) {
            tuition.setPaid(tuition.getPaid().trim());
        }
        if (tuition.getRemain() != null) {
            tuition.setRemain(tuition.getRemain().trim());
        }
    }

    private void validateTuition(Tuition tuition) throws ValidationException {
        validateString(tuition.getStudentID(), "Student num", STUDENT_NUM_MAX_LENGTH, false);
        validateString(tuition.getPaid(), "paid", PAID_MAX_LENGTH, false);
        validateString(tuition.getRemain() , "remainder", REMAINDER_MAX_LENGTH, false);
    }

    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) throws ValidationException {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null && !isNullAllowed) {
            throw new ValidationException(String.format("%s cannot be null", fieldName));
        } else if (value.isEmpty()) {
            throw new ValidationException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new ValidationException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
}
