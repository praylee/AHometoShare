package business;

import dataaccess.CourseDAO;
import dataaccess.CourseDAOImpl;
import java.util.List;
import transferobjects.Course;

/**
 * provides function to add courses and get all courses. It delegates the
 * operation to {@link CourseDAO}.
 *
 *
 * @author Stanley Pieda
 */
public class CoursesLogic {

    private static final int COURSE_CODE_MAX_LENGTH = 45;
    private static final int COURSE_NAME_MAX_LENGTH = 45;

    private CourseDAO courseDAO = null;

    /**
     * Construct a Course Logic.
     */

    public CoursesLogic() {
        courseDAO = new CourseDAOImpl();
    }

    /**
     * Get all courses from database.
     *
     * @return a list of Courses
     */

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    /**
     * Add course to the database.
     *
     * @param course the course to add
     *
     * @throws ValidationException if the course object failed validation.
     */

    public void addCourse(Course course) throws ValidationException {
        cleanCourse(course);
        validateCourse(course);
        courseDAO.addCourse(course);
    }

    public Course getCourseByCourseID(String code) {
        return courseDAO.getCourseByCourseID(code);
    }

    public void deleteCourse(String code) {
        courseDAO.deleteCourse(code);
    }

    public void updateCourse(String code, String name) {
        courseDAO.updateCourse(code, name);
    }

    private void cleanCourse(Course course) {
        if (course.getCode() != null) {
            course.setCode(course.getCode().trim());
        }
        if (course.getName() != null) {
            course.setName(course.getName().trim());
        }
    }

    private void validateCourse(Course course) throws ValidationException {
        validateString(course.getCode(), "Course Code", COURSE_CODE_MAX_LENGTH, false);
        validateString(course.getName(), "Course Name", COURSE_NAME_MAX_LENGTH, false);
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
