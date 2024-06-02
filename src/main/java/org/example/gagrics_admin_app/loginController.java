package org.example.gagrics_admin_app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

public class loginController {

    @FXML
    public TextField emailInput;
    @FXML
    public PasswordField passwordInput;
    @FXML
    public Button loginBtn;

    @FXML
    public void handleLoginAction(ActionEvent actionEvent) {
        String email = emailInput.getText();
        String password = passwordInput.getText();
        
        callApi(email,password);

        Stage stage = (Stage) loginBtn.getScene().getWindow();
        AppSwitcher.switchToApplication(mainActivity.class, stage);
    }

    private void callApi(String email, String password) {
        JSONObject data = new JSONObject();
        data.put("email",email);
        data.put("password",password);

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(data.toString(),JSON);
        Request request = new Request.Builder()
                .url("http://localhost:3002/users")
                .post(body)
                .header("Content-Type","application/json")
                .build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("Request failed");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseBody = response.body().string();
                System.out.println(responseBody);
            }
        });
    }

    public void handleSignUpBtn(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message to the user)
        }
    }

}