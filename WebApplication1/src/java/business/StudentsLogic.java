/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.StudentsDAO;
import dataaccess.StudentsDAOImpl;
import java.util.List;
import transferobjects.Students;

/**
 * StudentsLogic provides the function to get student by ID, get all students,
 * and add new student. It delegates the operation to {@link StudentsDAO} 
 *
 * @author Cynthia Sheng
 */
public class StudentsLogic {

    private static final int STUDENT_NUM_MAX_LENGTH = 11;
    private static final int FIRST_NAME_MAX_LENGTH = 45;
    private static final int LAST_NAME_MAX_LENGTH = 45;
    private static final int BIRTH_MAX_LENGTH = 20;
    private static final int ENROLLED_MAX_LENGTH = 20;

    private StudentsDAO studentDAO = null;

    /**
     * Constructor to create a Student Logic
     */
    public StudentsLogic() {
        studentDAO = new StudentsDAOImpl();
    }

    /**
     * Get all students from database.
     *
     * @return a list of Students
     */
    public List<Students> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    /**
     * Add student
     *
     * @param student student to be added
     * @throws ValidationException if the Student object failed validation.
     */

    public void addStudent(Students student) throws ValidationException {
        cleanStudent(student);
        validateStudent(student);
        studentDAO.addStudents(student);
    }

    public Students getStudentByStudentID(String studentID) {
        return studentDAO.getStudentByStudentID(studentID);
    }

    public void deleteStudent(String studentID) {
        studentDAO.deleteStudent(studentID);
    }

    public void updateStudent(String studentID, String firstName, String lastName, String birth, String enroll) {
        studentDAO.updateStudent(studentID, firstName, lastName, birth, enroll);
    }

    private void cleanStudent(Students student) {
        if (student.getStuID() != null) {
            student.setStuID(student.getStuID().trim());
        }
        if (student.getFirstName() != null) {
            student.setFirstName(student.getFirstName().trim());
        }
        if (student.getLastName() != null) {
            student.setLastName(student.getLastName().trim());
        }
        if (student.getBirth() != null) {
            student.setBirth(student.getBirth().trim());
        }
        if (student.getEnroll() != null) {
            student.setEnroll(student.getEnroll().trim());
        }
    }

    private void validateStudent(Students student) throws ValidationException {
        validateString(student.getStuID(), "student_num", STUDENT_NUM_MAX_LENGTH, false);
        validateString(student.getFirstName(), "first name", FIRST_NAME_MAX_LENGTH, false);
        validateString(student.getLastName(), "last name", LAST_NAME_MAX_LENGTH, false);
        validateString(student.getBirth(), "date of birth", BIRTH_MAX_LENGTH, false);
        validateString(student.getEnroll(), "enrolled date", ENROLLED_MAX_LENGTH, false);
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
