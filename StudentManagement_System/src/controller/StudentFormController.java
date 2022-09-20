package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Student;

import java.sql.SQLException;

/**
 * @author Amayru
 * @created 20/09/2022 - 09:58
 * @project StudentManagement_System
 */
public class StudentFormController {

    public TextField txtID;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;
    public TableView tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void SaveOnAction(ActionEvent actionEvent) {
        Student s1 = new Student(
                txtID.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getId()
        );
        try {
            if (addStudent(s1)){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Saved...").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try Again...").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean addStudent(Student s1) throws SQLException, ClassNotFoundException {
        return new StudentController().saveStudent(s1);
    }

    public void UpdateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {

    }
}
