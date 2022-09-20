package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Student;
import views.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;

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
    public TableView<Student> tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void initialize(){
        colID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        try {
            setStudentToTable(new StudentController().getAllStudent());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setStudentToTable(ArrayList<Student> students){
        ObservableList<Student> obList = FXCollections.observableArrayList();
        students.forEach(e->{
            obList.add(
                    new StudentTM(e.getStudentId(), e.getStudentName(), e.getEmail(), e.getContact(),e.getAddress(), e.getNic()));
        });
//        System.out.println(obList);
        tblStudent.setItems(obList);

    }

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
