package controller;

import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Amayru
 * @created 20/09/2022 - 10:23
 * @project StudentManagement_System
 */
public class StudentController implements StudentService{

    @Override
    public boolean saveStudent(Student s1) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateStudent(Student s1) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Student getStudent(String studentId) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException {
        return null;
    }
}
