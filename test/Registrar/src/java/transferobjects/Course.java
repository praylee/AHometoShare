package transferobjects;

/**
 * transfer object for Course
 * 
 * @author Shawn
 */
public class Course {
    
    private String name;
    private String code;
    
    public Course(){}
    
    public Course( String name, String code){
        setName( name);
        setCode( code);
    }
    
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public void setName( String name){
        this.name = name;
    }
    
    public void setCode( String code){
        this.code = code;
    }
}