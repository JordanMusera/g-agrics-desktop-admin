package org.example.gagrics_admin_app;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class mainActivityController {
    @FXML
    public BorderPane borderPane;

    @FXML
    public void onDashboardClikedBtn(MouseEvent mouseEvent) {
        FXMLLoader object = new FXMLLoader();
        Pane view = object.getPage("p1-view.fxml");
        borderPane.setCenter(view);
    }
}
