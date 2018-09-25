/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.RegistryDAO;
import dataaccess.RegistryDAOImpl;
import java.util.List;
import transferobjects.ClassRep;
import transferobjects.Registry;

/**
 * provides the function to get all registries, and add registry. It delegates
 * the operation to {@link RegistryDAO}.
 *
 * @author Cynthia Sheng
 */
public class RegistryLogic {

    private static final int STUDENT_NUM_MAX_LENGTH = 11;
    private static final int COURSE_NUM_MAX_LENGTH = 20;
    private static final int TERM_MAX_LENGHTH = 1;
    private static final int YEAR_MAX_LENGTH = 11;
    private RegistryDAO registryDAO = null;

    /**
     * Constructor to create a Registry Logic
     */
    public RegistryLogic() {
        registryDAO = new RegistryDAOImpl();
    }
/**
     * Get all registries.
     * 
     * @return a list of Registry records
     */

    public List<Registry> getAllRegistry() {
        return registryDAO.getAllRegistry();
    }

/**
     * Add registry to database.
     * 
     * @param registry the registry to add.
     * @throws ValidationException if the registry object failed validation.
     */

    public void addRegistry(Registry registry) throws ValidationException {
        cleanRegistry(registry);
        validateRegistry(registry);
        registryDAO.addRegistry(registry);
    }

    public Registry getRegistryByStudentID(String studentID) {
        return registryDAO.getRegistryByStudentID(studentID);
    }

    public void deleteRegistry(String studentID) {
        registryDAO.deleteRegistry(studentID);
    }

    public void updateRegistry(String studentID, String courseID, String term, String year) {
        registryDAO.updateRegistry(studentID, courseID, term, year);
    }

    private void cleanRegistry(Registry registry) {
        if (registry.getStID() != null) {
            registry.setStID(registry.getStID().trim());
        }
        if (registry.getCourseID() != null) {
            registry.setCourseID(registry.getCourseID().trim());
        }
        if (registry.getTerm() != null) {
            registry.setTerm(registry.getTerm().trim());
        }
        if (registry.getYear() != null) {
            registry.setYear(registry.getYear().trim());
        }
    }

    private void validateRegistry(Registry registry) throws ValidationException {
        validateString(registry.getStID(), "student num", STUDENT_NUM_MAX_LENGTH, false);
        validateString(registry.getCourseID(), "course num", COURSE_NUM_MAX_LENGTH, false);
        validateString(registry.getTerm(), "term", TERM_MAX_LENGHTH, false);
        validateString(registry.getYear(), "year", YEAR_MAX_LENGTH, false);
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
