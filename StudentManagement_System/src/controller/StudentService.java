package controller;

import model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Amayru
 * @created 20/09/2022 - 10:21
 * @project StudentManagement_System
 */
public interface StudentService {
    public boolean saveStudent(Student s1) throws SQLException, ClassNotFoundException;
    public boolean updateStudent(Student s1) throws SQLException, ClassNotFoundException;
    public boolean deleteStudent(String studentId) throws SQLException, ClassNotFoundException;
    public Student getStudent(String studentId) throws SQLException, ClassNotFoundException;
    public ArrayList<Student> getAllStudent() throws SQLException, ClassNotFoundException;
}
