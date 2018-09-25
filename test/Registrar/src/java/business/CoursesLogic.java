package business;

import dataaccess.CourseDAO;
import dataaccess.CourseDAOImpl;
import java.util.List;
import transferobjects.Course;

/**
 *
 * @course Shahriar Emami
 * @author Stanley Pieda
 */
public class CoursesLogic {

    private static final int COURSE_CODE_MAX_LENGTH = 45;
    private static final int COURSE_NAME_MAX_LENGTH = 45;

    private CourseDAO courseDAO = null;

    public CoursesLogic() {
        courseDAO = new CourseDAOImpl();
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public void addCourse(Course course) throws ValidationException {
        cleanCourse(course);
        validateCourse(course);
        courseDAO.addCourse(course);
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
