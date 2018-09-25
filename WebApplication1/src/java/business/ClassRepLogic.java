/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*test*/

package business;
import dataaccess.ClassRepDAO;
import dataaccess.ClassRepDAOImpl;
import java.util.List;
import transferobjects.ClassRep;
/**
 *
 * @author Cynthia Sheng
 * January 7th, 2018
 */

/**
 * create length limitation of each variable 
 */
public class ClassRepLogic {

private ClassRepDAO classRepDAO = null;
        /**
     * Constructor to create a Class Representative
     */
    public ClassRepLogic(){
        classRepDAO= (ClassRepDAO) new ClassRepDAOImpl();
    }
        /**
     * Get all class rep.
     * 
     * @return a list of Class Representative
     */
    public List<ClassRep> getAllClassRep(){
        return classRepDAO.getAllClassRep();
    }
    
          public ClassRep getClassRepByStudentID(String studentID){
        return classRepDAO.getClassRepByStudentID(studentID);
    }
        
       public void deleteClassRep(String studentID){
        classRepDAO.deleteClassRep(studentID);
    }
    
}

