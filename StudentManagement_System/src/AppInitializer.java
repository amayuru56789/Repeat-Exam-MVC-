/**
 * @author Amayru
 * @created 20/09/2022 - 09:54
 * @project StudentManagement_System
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("views/StudentForm.fxml"))));
        primaryStage.setTitle("School management System");
        primaryStage.show();
    }
}
