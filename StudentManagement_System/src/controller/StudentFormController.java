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
    public TextField txtSearch;

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
        Student s1 = new Student(
                txtID.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),
                txtAddress.getText(),txtNic.getText()
        );
        try {
            if (new StudentController().updateStudent(s1))
                new Alert(Alert.AlertType.CONFIRMATION,"Student Updated...").show();
            else
                new Alert(Alert.AlertType.WARNING,"Try again..").show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        try {
            if (new StudentController().deleteStudent(txtID.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Try again").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String studentId = txtSearch.getText();
        Student s1 = new StudentController().getStudent(studentId);
        if (s1==null){
            new Alert(Alert.AlertType.WARNING, "Empty Result SET...").show();
        }else {
            setData(s1);
        }
    }

    private void setData(Student s1) {
        txtID.setText(s1.getStudentId());
        txtName.setText(s1.getStudentName());
        txtEmail.setText(s1.getEmail());
        txtContact.setText(s1.getContact());
        txtAddress.setText(s1.getAddress());
        txtNic.setText(s1.getNic());
    }
}
