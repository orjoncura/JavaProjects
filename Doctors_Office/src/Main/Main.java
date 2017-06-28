package Main;

import Database.DB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Parent root = FXMLLoader.load(getClass().getResource("../FXML/Doctors_Office.fxml"));
        primaryStage.setTitle("Doctors Office");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.maximizedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                primaryStage.setMaximized(false);
        });

        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {

        new DB();
        launch(args);

    }
}
