package org.example.gagrics_admin_app;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FXMLLoader {
    @FXML
    Pane view;

    public Pane getPage(String fileName){
        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource(fileName));
            view = fxmlLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
