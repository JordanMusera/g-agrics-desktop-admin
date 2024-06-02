package org.example.gagrics_admin_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppSwitcher {

    public static void switchToApplication(Class<? extends Application> appClass, Stage stage) {
        // Hide the current stage
        stage.hide();

        // Use Platform.runLater to ensure the JavaFX runtime remains active
        Platform.runLater(() -> {
            try {
                // Create a new instance of the application
                Application newApp = appClass.getDeclaredConstructor().newInstance();

                // Start the new application
                Stage newStage = new Stage();
                newApp.start(newStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
