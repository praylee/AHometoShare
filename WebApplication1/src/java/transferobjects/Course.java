package transferobjects;

/**
 * transfer object for Course
 *
 * @author Shawn
 */
public class Course {

    private String name;
    private String code;

    public Course() {
    }

    public Course(String name, String code) {
        setName(name);
        setCode(code);
    }

    /**
     * Get name of the course
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get code of the course
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * set name of the course
     *
     * @param name course name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set code of the course
     *
     * @param code course code
     */
    public void setCode(String code) {
        this.code = code;
    }
}
