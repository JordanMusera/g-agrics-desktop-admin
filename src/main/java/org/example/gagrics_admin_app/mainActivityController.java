package org.example.gagrics_admin_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class mainActivityController {
    @FXML
    public BorderPane borderPane;
    public Label dashboardHoverTitle;
    public Label ordersHoverTitle;
    public Label productsHoverTitle;
    public Label sellersHoverTitle;
    public Label usersHoverTitle;
    public Label eventsHoverTitle;
    public Label withdrawHoverTitle;
    public Label settingsHoverTitle;

    public ImageView dashboardIcon;
    public ImageView ordersIcon;
    public ImageView productsIcon;
    public ImageView sellersIcon;
    public ImageView usersIcon;
    public ImageView eventsIcon;
    public ImageView withdrawIcon;
    public ImageView settingsIcon;
    public AnchorPane centerAnchorPane;

    @FXML
    public void onDashboardClikedBtn(MouseEvent mouseEvent) {
        FXMLLoader object = new FXMLLoader();
        Pane view = object.getPage("dashboard-view.fxml");
        centerAnchorPane.getChildren().add(view);
        //borderPane.setCenter(view);
        centerAnchorPane.setLeftAnchor(view, 0.0);
        centerAnchorPane.setRightAnchor(view, 0.0);

    }





    public void initialize() {
        addHoverEffect(dashboardIcon, dashboardHoverTitle);
        addHoverEffect(ordersIcon,ordersHoverTitle);
        addHoverEffect(productsIcon,productsHoverTitle);
        addHoverEffect(sellersIcon,sellersHoverTitle);
        addHoverEffect(usersIcon,usersHoverTitle);
        addHoverEffect(eventsIcon,eventsHoverTitle);
        addHoverEffect(withdrawIcon,withdrawHoverTitle);
        addHoverEffect(settingsIcon,settingsHoverTitle);
    }



    private void addHoverEffect(ImageView icon, Label title) {
        icon.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> title.setVisible(true));
        icon.addEventHandler(MouseEvent.MOUSE_EXITED, event -> title.setVisible(false));
    }

}
