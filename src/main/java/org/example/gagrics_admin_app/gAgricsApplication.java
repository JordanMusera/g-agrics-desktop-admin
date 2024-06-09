package org.example.gagrics_admin_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class gAgricsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(gAgricsApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        // Set the title of the stage
        stage.setTitle("G-AGRICS admin app");

        // Set the scene
        stage.setScene(scene);

        // Prevent the window from being resizable, which indirectly prevents maximization
        stage.setResizable(false);

        // Optionally, ensure that the window is not maximized initially
        stage.setMaximized(false);

        // Show the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
