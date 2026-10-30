package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAPP extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Sesuaikan path FXML dengan folder resources kamu
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Input-UI.fxml"));
        primaryStage.setTitle("Kalkulator BMI");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}