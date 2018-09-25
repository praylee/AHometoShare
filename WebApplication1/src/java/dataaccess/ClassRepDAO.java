/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.ClassRep;

/**
 * ClassRepDAO provides database access functions for table "ClassRep". The
 * functions includes get all ClassRep, getClassRepby ID, delete
 * ClassRepregistry.
 *
 *
 * @author Cynthia Sheng
 */
public interface ClassRepDAO {

    List<ClassRep> getAllClassRep();

    ClassRep getClassRepByStudentID(String studentID);

    void deleteClassRep(String studentID);
}
